package com.tecsup.dto;

public class PostulacionResponse {

    private Long idPostulacion;
    private String fechaPostulacion;
    private String estado;
    private String cartaPresentacion;
    private VacanteInfo vacante;
    private UsuarioInfo postulante;

    public static class VacanteInfo {
        private String titulo;
        private String area;
        private String modalidad;
        private Double salario;

        public String getTitulo() { return titulo; }
        public void setTitulo(String t) { this.titulo = t; }

        public String getArea() { return area; }
        public void setArea(String a) { this.area = a; }

        public String getModalidad() { return modalidad; }
        public void setModalidad(String m) { this.modalidad = m; }

        public Double getSalario() { return salario; }
        public void setSalario(Double s) { this.salario = s; }
    }

    public static class UsuarioInfo {
        private String nombres;
        private String apellidos;
        private String email;

        public String getNombres() { return nombres; }
        public void setNombres(String n) { this.nombres = n; }

        public String getApellidos() { return apellidos; }
        public void setApellidos(String a) { this.apellidos = a; }

        public String getEmail() { return email; }
        public void setEmail(String e) { this.email = e; }
    }

    public Long getIdPostulacion() { return idPostulacion; }
    public void setIdPostulacion(Long id) { this.idPostulacion = id; }

    public String getFechaPostulacion() { return fechaPostulacion; }
    public void setFechaPostulacion(String f) { this.fechaPostulacion = f; }

    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }

    public String getCartaPresentacion() { return cartaPresentacion; }
    public void setCartaPresentacion(String c) { this.cartaPresentacion = c; }

    public VacanteInfo getVacante() { return vacante; }
    public void setVacante(VacanteInfo v) { this.vacante = v; }

    public UsuarioInfo getPostulante() { return postulante; }
    public void setPostulante(UsuarioInfo u) { this.postulante = u; }
}