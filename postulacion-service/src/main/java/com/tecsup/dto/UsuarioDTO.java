package com.tecsup.dto;

public class UsuarioDTO {
    private Long idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String rol;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long id) { this.idUsuario = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String n) { this.nombres = n; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String a) { this.apellidos = a; }

    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }

    public String getRol() { return rol; }
    public void setRol(String r) { this.rol = r; }
}