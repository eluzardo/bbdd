package org.eluzardo.java.bbdd.repositorio;

import org.eluzardo.java.bbdd.modelo.Alumno;
import org.eluzardo.java.bbdd.modelo.Materia;
import org.eluzardo.java.bbdd.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaImpl implements  Repositorio<Materia>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Materia> listar() {
        List<Materia> materias = new ArrayList<>();
        try(Statement stmt=getConnection().createStatement();
            ResultSet rs= stmt.executeQuery("select * from materias")){
            while(rs.next()){
                Materia materia = crearMateria(rs);
                materias.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

    @Override
    public Materia porId(Integer id) {
        return null;
    }

    @Override
    public void guardar(Materia materia) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void insertar(Materia materia) {
        try(PreparedStatement stmt= getConnection().
                prepareStatement("insert into materias (nombre,codigo,carreraId) values (?,?,?)")){
            stmt.setString(1,materia.getNombre());
            stmt.setString(2,materia.getCodigo());
            stmt.setInt(3, materia.getCarreraId());
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Materia crearMateria(ResultSet rs) throws SQLException {
        Materia materia = new Materia();
        materia.setId(rs.getInt("id"));
        materia.setNombre(rs.getString("nombre"));
        materia.setCodigo(rs.getString("codigo"));
        materia.setCarreraId(rs.getInt("carreraId"));
        return materia;
    }
}
