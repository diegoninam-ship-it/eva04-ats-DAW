package com.tecsup.repository;

import com.tecsup.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

    List<Postulacion> findByUsuarioId(Long usuarioId);

    List<Postulacion> findByVacanteId(Long vacanteId);

    // Evita postulaciones duplicadas
    boolean existsByVacanteIdAndUsuarioId(Long vacanteId, Long usuarioId);
}