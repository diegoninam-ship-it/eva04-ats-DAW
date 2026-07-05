package com.tecsup.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacantes")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacante;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String area;

    @Column(nullable = false, length = 50)
    private String modalidad; // PRESENCIAL, REMOTO, HIBRIDO

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private LocalDate fechaPublicacion;

    @Column(nullable = false)
    private LocalDate fechaCierre;

    @Column(nullable = false, length = 20)
    private String estado = "ACTIVA"; // ACTIVA, CERRADA, PAUSADA

    // ID del reclutador en usuario-service (sin FK directa)
    private Long reclutadorId;

    public Vacante() {}

    public Long getIdVacante() { return idVacante; }
    public void setIdVacante(Long id) { this.idVacante = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String t) { this.titulo = t; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String d) { this.descripcion = d; }

    public String getArea() { return area; }
    public void setArea(String a) { this.area = a; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String m) { this.modalidad = m; }

    public Double getSalario() { return salario; }
    public void setSalario(Double s) { this.salario = s; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate f) { this.fechaPublicacion = f; }

    public LocalDate getFechaCierre() { return fechaCierre; }
    public void setFechaCierre(LocalDate f) { this.fechaCierre = f; }

    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }

    public Long getReclutadorId() { return reclutadorId; }
    public void setReclutadorId(Long id) { this.reclutadorId = id; }
}