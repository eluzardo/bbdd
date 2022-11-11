package org.eluzardo.java.bbdd.modelo;

public class Carrera {
    private Integer id;
    private String carrera;
    private String codigo;

    public Integer getId() {
        return id;
    }

    public Carrera() {
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", carrera='" + carrera + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public Carrera(Integer id, String carrera, String codigo) {
        this.id = id;
        this.carrera = carrera;
        this.codigo = codigo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
