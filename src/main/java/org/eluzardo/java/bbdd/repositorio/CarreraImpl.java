package org.eluzardo.java.bbdd.repositorio;

import org.eluzardo.java.bbdd.modelo.Carrera;
import org.eluzardo.java.bbdd.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraImpl implements Repositorio<Carrera>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }

    @Override
    public List<Carrera> listar() {
        List<Carrera> carreras = new ArrayList<>();
        try(Statement stmt= getConnection().createStatement();
            ResultSet rs= stmt.executeQuery("select * from carreras")){
            while(rs.next()){
                Carrera carr = crearCarrera(rs);
                carreras.add(carr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }

    @Override
    public Carrera porId(Integer id) {
        Carrera carrera=null;
        try(PreparedStatement stmt = getConnection().
                prepareStatement("select * from carreras where id=?")){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                carrera=crearCarrera(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrera;
    }

    @Override
    public void guardar(Carrera carrera) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void insertar(Carrera carrera) {
        try(PreparedStatement stmt=getConnection().
                prepareStatement("insert into carreras (nombre,codigo) values (?,?)")){
            stmt.setString(1, carrera.getCarrera());
            stmt.setString(2, carrera.getCodigo());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private Carrera crearCarrera(ResultSet rs) throws SQLException {
        Carrera carr = new Carrera();
        carr.setId(rs.getInt("id"));
        carr.setCarrera(rs.getString("nombre"));
        carr.setCodigo(rs.getString("codigo"));
        return carr;
    }
}
