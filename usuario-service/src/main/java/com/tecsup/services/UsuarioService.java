package com.tecsup.services;

import com.tecsup.exception.ResourceNotFoundException;
import com.tecsup.model.Usuario;
import com.tecsup.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listar() { return repo.findAll(); }

    public Usuario obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario no encontrado con id: " + id));
    }

    public Usuario registrar(Usuario u) {
        if (repo.existsByEmail(u.getEmail()))
            throw new IllegalArgumentException(
                    "Ya existe un usuario con email: " + u.getEmail());
        return repo.save(u);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario existente = obtener(id);
        existente.setNombres(datos.getNombres());
        existente.setApellidos(datos.getApellidos());
        existente.setRol(datos.getRol());
        return repo.save(existente);
    }

    public void eliminar(Long id) {
        repo.delete(obtener(id));
    }

    public Map<String, Object> login(String email, String password) {
        Usuario u = repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuario no encontrado con email: " + email));

        if (!u.getPassword().equals(password))
            throw new IllegalArgumentException("Contraseña incorrecta");

        return Map.of(
                "mensaje", "Login exitoso",
                "idUsuario", u.getIdUsuario(),
                "nombres", u.getNombres(),
                "email", u.getEmail(),
                "rol", u.getRol()
        );
    }
}