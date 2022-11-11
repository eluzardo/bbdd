package org.eluzardo.java.bbdd.modelo;

public class Materia {
    private Integer id;
    private  String nombre;
    private  String codigo;
    private Integer carreraId;

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", carreraId=" + carreraId +
                '}';
    }

    public Materia() {
    }

    public Materia(Integer id, String nombre, String codigo, Integer carreraId) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.carreraId = carreraId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }
}
