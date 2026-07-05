package com.tecsup.dto;

import jakarta.validation.constraints.NotNull;

public class PostulacionDTO {

    @NotNull(message = "La vacante es obligatoria")
    private Long vacanteId;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    private String cartaPresentacion;

    public Long getVacanteId() { return vacanteId; }
    public void setVacanteId(Long id) { this.vacanteId = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long id) { this.usuarioId = id; }

    public String getCartaPresentacion() { return cartaPresentacion; }
    public void setCartaPresentacion(String c) { this.cartaPresentacion = c; }
}