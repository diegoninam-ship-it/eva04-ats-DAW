package com.tecsup.dto;

public class VacanteDTO {
    private Long idVacante;
    private String titulo;
    private String area;
    private String modalidad;
    private Double salario;
    private String estado;

    public Long getIdVacante() { return idVacante; }
    public void setIdVacante(Long id) { this.idVacante = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String t) { this.titulo = t; }

    public String getArea() { return area; }
    public void setArea(String a) { this.area = a; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String m) { this.modalidad = m; }

    public Double getSalario() { return salario; }
    public void setSalario(Double s) { this.salario = s; }

    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
}