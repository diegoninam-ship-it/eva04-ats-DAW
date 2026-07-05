package com.tecsup.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postulaciones")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulacion;

    @Column(nullable = false)
    private Long vacanteId;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private LocalDate fechaPostulacion;

    /*
     * Estados del postulante según el requerimiento funcional:
     * ENVIADA → EN_REVISION → ENTREVISTA → SELECCIONADO / DESCARTADO
     */
    @Column(nullable = false, length = 20)
    private String estado = "ENVIADA";

    @Column(columnDefinition = "TEXT")
    private String cartaPresentacion;

    public Postulacion() {}

    public Long getIdPostulacion() { return idPostulacion; }
    public void setIdPostulacion(Long id) { this.idPostulacion = id; }

    public Long getVacanteId() { return vacanteId; }
    public void setVacanteId(Long id) { this.vacanteId = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long id) { this.usuarioId = id; }

    public LocalDate getFechaPostulacion() { return fechaPostulacion; }
    public void setFechaPostulacion(LocalDate f) { this.fechaPostulacion = f; }

    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }

    public String getCartaPresentacion() { return cartaPresentacion; }
    public void setCartaPresentacion(String c) { this.cartaPresentacion = c; }
}