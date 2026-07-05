package com.tecsup.services;

import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.model.Vacante;
import com.tecsup.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacanteService {

    @Autowired
    private VacanteRepository repo;

    public List<Vacante> listar() { return repo.findAll(); }

    public List<Vacante> listarActivas() { return repo.findByEstado("ACTIVA"); }

    public List<Vacante> listarPorArea(String area) { return repo.findByArea(area); }

    public Vacante obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vacante no encontrada con id: " + id));
    }

    public Vacante guardar(Vacante v) { return repo.save(v); }

    public Vacante actualizar(Long id, Vacante datos) {
        Vacante existente = obtener(id);
        existente.setTitulo(datos.getTitulo());
        existente.setDescripcion(datos.getDescripcion());
        existente.setArea(datos.getArea());
        existente.setModalidad(datos.getModalidad());
        existente.setSalario(datos.getSalario());
        existente.setFechaCierre(datos.getFechaCierre());
        return repo.save(existente);
    }

    public Vacante cambiarEstado(Long id, String nuevoEstado) {
        Vacante v = obtener(id);
        v.setEstado(nuevoEstado);
        return repo.save(v);
    }

    public void eliminar(Long id) {
        repo.delete(obtener(id));
    }
}