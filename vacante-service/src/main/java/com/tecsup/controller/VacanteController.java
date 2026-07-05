package com.tecsup.controller;

import com.tecsup.dto.VacanteDTO;
import com.tecsup.model.Vacante;
import com.tecsup.services.VacanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vacantes")
public class VacanteController {

    @Autowired
    private VacanteService service;

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> info() {
        Map<String, String> info = new HashMap<>();
        info.put("servicio", "vacante-service");
        info.put("mensaje", mensajeBienvenida);
        return ResponseEntity.ok(info);
    }

    @GetMapping
    public ResponseEntity<List<Vacante>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Vacante>> listarActivas() {
        return ResponseEntity.ok(service.listarActivas());
    }

    @GetMapping("/area/{area}")
    public ResponseEntity<List<Vacante>> listarPorArea(@PathVariable String area) {
        return ResponseEntity.ok(service.listarPorArea(area));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacante> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Vacante> guardar(@Valid @RequestBody VacanteDTO dto) {
        Vacante v = new Vacante();
        v.setTitulo(dto.getTitulo());
        v.setDescripcion(dto.getDescripcion());
        v.setArea(dto.getArea());
        v.setModalidad(dto.getModalidad());
        v.setSalario(dto.getSalario());
        v.setFechaPublicacion(dto.getFechaPublicacion());
        v.setFechaCierre(dto.getFechaCierre());
        v.setReclutadorId(dto.getReclutadorId());
        return ResponseEntity.status(201).body(service.guardar(v));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacante> actualizar(@PathVariable Long id,
                                              @Valid @RequestBody VacanteDTO dto) {
        Vacante v = new Vacante();
        v.setTitulo(dto.getTitulo());
        v.setDescripcion(dto.getDescripcion());
        v.setArea(dto.getArea());
        v.setModalidad(dto.getModalidad());
        v.setSalario(dto.getSalario());
        v.setFechaCierre(dto.getFechaCierre());
        return ResponseEntity.ok(service.actualizar(id, v));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Vacante> cambiarEstado(@PathVariable Long id,
                                                 @RequestParam String estado) {
        return ResponseEntity.ok(service.cambiarEstado(id, estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Vacante eliminada correctamente");
    }
}