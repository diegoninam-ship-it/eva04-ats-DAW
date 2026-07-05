package com.tecsup.services;

import com.tecsup.client.UsuarioClient;
import com.tecsup.client.VacanteClient;
import com.tecsup.dto.*;
import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.model.Postulacion;
import com.tecsup.repository.PostulacionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostulacionService {

    @Autowired private PostulacionRepository repo;
    @Autowired private VacanteClient vacanteClient;
    @Autowired private UsuarioClient usuarioClient;

    public List<Postulacion> listar() { return repo.findAll(); }

    public List<Postulacion> listarPorUsuario(Long usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

    public List<Postulacion> listarPorVacante(Long vacanteId) {
        return repo.findByVacanteId(vacanteId);
    }

    public Postulacion obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Postulación no encontrada con id: " + id));
    }

    /*
     * @CircuitBreaker: si vacante-service o usuario-service fallan
     * consecutivamente, el circuito se abre y llama al fallback.
     * @Retry: antes de abrir el circuito, reintenta 3 veces
     * con 2 segundos de espera entre intentos.
     */
    @CircuitBreaker(name = "vacante-service", fallbackMethod = "fallbackObtenerDetalle")
    @Retry(name = "vacante-service")
    public PostulacionResponse obtenerDetalle(Long id) {

        Postulacion p = obtener(id);

        VacanteDTO vacante = vacanteClient.obtenerVacante(p.getVacanteId());
        UsuarioDTO usuario = usuarioClient.obtenerUsuario(p.getUsuarioId());

        PostulacionResponse response = new PostulacionResponse();
        response.setIdPostulacion(p.getIdPostulacion());
        response.setFechaPostulacion(p.getFechaPostulacion().toString());
        response.setEstado(p.getEstado());
        response.setCartaPresentacion(p.getCartaPresentacion());

        PostulacionResponse.VacanteInfo vi = new PostulacionResponse.VacanteInfo();
        vi.setTitulo(vacante.getTitulo());
        vi.setArea(vacante.getArea());
        vi.setModalidad(vacante.getModalidad());
        vi.setSalario(vacante.getSalario());
        response.setVacante(vi);

        PostulacionResponse.UsuarioInfo ui = new PostulacionResponse.UsuarioInfo();
        ui.setNombres(usuario.getNombres());
        ui.setApellidos(usuario.getApellidos());
        ui.setEmail(usuario.getEmail());
        response.setPostulante(ui);

        return response;
    }

    /*
     * Fallback: se ejecuta cuando el circuito está abierto
     * o cuando los reintentos se agotan.
     * Devuelve datos parciales de la BD sin llamar a otros servicios.
     */
    public PostulacionResponse fallbackObtenerDetalle(Long id, Throwable t) {

        Postulacion p = repo.findById(id).orElse(null);

        PostulacionResponse response = new PostulacionResponse();

        if (p != null) {
            response.setIdPostulacion(p.getIdPostulacion());
            response.setFechaPostulacion(p.getFechaPostulacion().toString());
            response.setEstado(p.getEstado());
        }

        PostulacionResponse.VacanteInfo vi = new PostulacionResponse.VacanteInfo();
        vi.setTitulo("No fue posible consultar el servicio. Intente nuevamente.");
        response.setVacante(vi);

        PostulacionResponse.UsuarioInfo ui = new PostulacionResponse.UsuarioInfo();
        ui.setNombres("No fue posible consultar el servicio. Intente nuevamente.");
        response.setPostulante(ui);

        return response;
    }

    public Postulacion postular(PostulacionDTO dto) {

        if (repo.existsByVacanteIdAndUsuarioId(dto.getVacanteId(), dto.getUsuarioId()))
            throw new IllegalArgumentException(
                    "El usuario ya postuló a esta vacante");

        Postulacion p = new Postulacion();
        p.setVacanteId(dto.getVacanteId());
        p.setUsuarioId(dto.getUsuarioId());
        p.setFechaPostulacion(LocalDate.now());
        p.setCartaPresentacion(dto.getCartaPresentacion());
        p.setEstado("ENVIADA");

        return repo.save(p);
    }

    public Postulacion cambiarEstado(Long id, String nuevoEstado) {
        Postulacion p = obtener(id);
        p.setEstado(nuevoEstado);
        return repo.save(p);
    }

    public void eliminar(Long id) {
        repo.delete(obtener(id));
    }
}