package org.eluzardo.java.bbdd.repositorio;

import org.eluzardo.java.bbdd.modelo.Alumno;
import org.eluzardo.java.bbdd.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoImpl implements Repositorio<Alumno>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }


    @Override
    public List<Alumno> listar() {
        List<Alumno> alumnos = new ArrayList<>();
        try(Statement stmt=getConnection().createStatement();
            ResultSet rs= stmt.executeQuery("select * from alumnos")){
            while(rs.next()){
                Alumno alumno = crearAlumno(rs);
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public Alumno porId(Integer id) {
        return null;
    }

    @Override
    public void guardar(Alumno alumno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void insertar(Alumno alumno) {
        try(PreparedStatement stmt= getConnection().
                prepareStatement("insert into alumnos (nombre,apellido,dni) values (?,?,?)")){
            stmt.setString(2,alumno.getNombre());
            stmt.setString(3,alumno.getApellido());
            stmt.setString(4,alumno.getDni());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Alumno crearAlumno(ResultSet rs) throws SQLException {
        Alumno alumno = new Alumno();
        alumno.setId(rs.getInt("id"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido(rs.getString("apellido"));
        alumno.setDni(rs.getString("dni"));
        return alumno;
    }
}
