package org.eluzardo.java.bbdd;

import org.eluzardo.java.bbdd.modelo.Alumno;
import org.eluzardo.java.bbdd.modelo.Carrera;
import org.eluzardo.java.bbdd.modelo.Materia;
import org.eluzardo.java.bbdd.repositorio.AlumnoImpl;
import org.eluzardo.java.bbdd.repositorio.CarreraImpl;
import org.eluzardo.java.bbdd.repositorio.MateriaImpl;
import org.eluzardo.java.bbdd.repositorio.Repositorio;
import org.eluzardo.java.bbdd.util.ConexionBD;

import java.sql.*;
import java.util.Scanner;

public class Ejemplo {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try (Connection conn = ConexionBD.getInstance()){
            Repositorio<Carrera> carreras = new CarreraImpl();
            Repositorio<Alumno> alumnos = new AlumnoImpl();
            Repositorio<Materia> materias = new MateriaImpl();

            carreras.listar().forEach(p -> System.out.println(p.toString()));
            alumnos.listar().forEach(a -> System.out.println(a.toString()));
            materias.listar().forEach(a -> System.out.println(a.toString()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
