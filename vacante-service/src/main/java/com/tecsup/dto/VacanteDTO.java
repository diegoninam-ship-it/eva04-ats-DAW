package com.tecsup.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VacanteDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private String descripcion;

    @NotBlank(message = "El área es obligatoria")
    private String area;

    @NotBlank(message = "La modalidad es obligatoria")
    private String modalidad;

    @NotNull(message = "El salario es obligatorio")
    @Min(value = 1, message = "El salario debe ser mayor a cero")
    private Double salario;

    @NotNull(message = "La fecha de publicación es obligatoria")
    private LocalDate fechaPublicacion;

    @NotNull(message = "La fecha de cierre es obligatoria")
    private LocalDate fechaCierre;

    @NotNull(message = "El reclutador es obligatorio")
    private Long reclutadorId;

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

    public Long getReclutadorId() { return reclutadorId; }
    public void setReclutadorId(Long id) { this.reclutadorId = id; }
}