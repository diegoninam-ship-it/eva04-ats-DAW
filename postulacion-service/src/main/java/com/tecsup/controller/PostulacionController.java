package com.tecsup.controller;

import com.tecsup.dto.PostulacionDTO;
import com.tecsup.dto.PostulacionResponse;
import com.tecsup.model.Postulacion;
import com.tecsup.services.PostulacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {

    @Autowired
    private PostulacionService service;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        Map<String, String> info = new HashMap<>();
        info.put("servicio", "postulacion-service");
        info.put("mensaje", mensajeBienvenida);
        return ResponseEntity.ok(info);
    }

    @GetMapping
    public ResponseEntity<List<Postulacion>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Respuesta enriquecida con datos de otros servicios
    @GetMapping("/{id}/detalle")
    public ResponseEntity<PostulacionResponse> obtenerDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerDetalle(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Postulacion>> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }

    @GetMapping("/vacante/{vacanteId}")
    public ResponseEntity<List<Postulacion>> listarPorVacante(
            @PathVariable Long vacanteId) {
        return ResponseEntity.ok(service.listarPorVacante(vacanteId));
    }

    @PostMapping
    public ResponseEntity<Postulacion> postular(
            @Valid @RequestBody PostulacionDTO dto) {
        return ResponseEntity.status(201).body(service.postular(dto));
    }

    // Gestión de estados del postulante
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Postulacion> cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(service.cambiarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Postulación eliminada correctamente");
    }
}