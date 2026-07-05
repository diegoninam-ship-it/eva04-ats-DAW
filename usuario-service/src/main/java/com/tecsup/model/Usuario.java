package com.tecsup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 20)
    private String rol; // ADMIN, RECLUTADOR, POSTULANTE

    @Column(nullable = false, length = 20)
    private String estado = "ACTIVO";

    public Usuario() {}

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long id) { this.idUsuario = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String n) { this.nombres = n; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String a) { this.apellidos = a; }

    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }

    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }

    public String getRol() { return rol; }
    public void setRol(String r) { this.rol = r; }

    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
}