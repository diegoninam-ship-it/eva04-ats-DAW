package com.tecsup.repository;

import com.tecsup.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacanteRepository extends JpaRepository<Vacante, Long> {

    List<Vacante> findByEstado(String estado);

    List<Vacante> findByArea(String area);

    List<Vacante> findByReclutadorId(Long reclutadorId);
}