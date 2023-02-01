/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.animal;

/**
 *
 * @author Kenia
 */
import modelo.animal.BeanAnimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilerias.ConexionSqlSimple;

public class DaoAnimal {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    boolean resultado;

    private static final String INSERT_ANIMAL = "INSERT INTO animales" + "  (nombre,nombreCientifico,habitad,especie,peso,dieta,peligroExtincion) VALUES "
            + " (?, ?, ?,?, ?, ?, ?);";

    private static final String SELECT_ANIMAL_BY_ID = "select id,nombre,nombreCientifico,habitad,especie,peso,dieta,peligroExtincion from animales where id =?";
    private static final String SELECT_ALL_ANIMAL = "select * from animales";
    private static final String DELETE_ANIMAL = "delete from animales where id = ?;";
    private static final String UPDATE_ANIMAL = "update animales set nombre = ?,nombreCientifico= ?, habitad =?,especie =?,peso =?,dieta =?,peligroExtincion =? where id = ?;";

    public List<BeanAnimal> consultarAnimales() {
        List<BeanAnimal> misAnimales = new ArrayList<BeanAnimal>();
        try {
            con = ConexionSqlSimple.getConnection();
            pstm = con.prepareStatement(SELECT_ALL_ANIMAL);
            rs = pstm.executeQuery();
            BeanAnimal animal = null;

            while (rs.next()) {

                animal = new BeanAnimal();
                animal.setId(rs.getInt("id"));
                animal.setNombre(rs.getString("nombre"));
                animal.setNombreCientifico(rs.getString("nombreCientifico"));
                animal.setHabitad(rs.getString("habitad"));
                animal.setEspecie(rs.getString("especie"));
                animal.setPeso(rs.getDouble("peso"));
                animal.setDieta(rs.getString("dieta"));
                animal.setPeligroExtincion(rs.getByte("peligroExtincion"));
                misAnimales.add(animal);

            }
        } catch (SQLException ex) {
            System.out.println("Error DaoAnimal- consultarAnimales()" + ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();

            } catch (SQLException ex) {
                System.out.println("Error DaoAnimal- consultarAnimales() - cerrar" + ex);

            }
        }
        return misAnimales;

    }

    public boolean registrarAnimal(BeanAnimal unAnimal) {
        try {
            con = ConexionSqlSimple.getConnection();
            pstm = con.prepareStatement(INSERT_ANIMAL);
            pstm.setString(1, unAnimal.getNombre());
            pstm.setString(2, unAnimal.getNombreCientifico());
            pstm.setString(3, unAnimal.getHabitad());
            pstm.setString(4, unAnimal.getEspecie());
            pstm.setDouble(5, unAnimal.getPeso());
            pstm.setString(6, unAnimal.getDieta());
            pstm.setByte(7, unAnimal.getPeligroExtincion());

            resultado = pstm.executeUpdate() == 1;

        } catch (SQLException ex) {
            System.out.println("Error DaoAnimal- registrarAnimal()" + ex);
        } finally {
            try {
                con.close();
                pstm.close();

            } catch (SQLException ex) {
                System.out.println("Error DaoAnimal- registrarAnimal() - cerrar" + ex);
            }
        }
        return resultado;
    }

    public BeanAnimal consultarAnimal(int id) {
        BeanAnimal animalConsultada = new BeanAnimal();
        try {
            con = ConexionSqlSimple.getConnection();
            pstm = con.prepareStatement(SELECT_ANIMAL_BY_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                animalConsultada.setId(rs.getInt("id"));
                animalConsultada.setNombre(rs.getString("nombre"));
                animalConsultada.setNombreCientifico(rs.getString("nombreCientifico"));
                animalConsultada.setHabitad(rs.getString("habitad"));
                animalConsultada.setEspecie(rs.getString("especie"));
                animalConsultada.setPeso(rs.getDouble("peso"));
                animalConsultada.setDieta(rs.getString("dieta"));
                animalConsultada.setPeligroExtincion(rs.getByte("peligroExtincion"));

            }

        } catch (SQLException ex) {
            System.out.println("Error DaoPersona - ConsultarPersona()" + ex);
        } finally {
            try {
                con.close();
                pstm.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error DaoPersona - ConsultarPersona() - cerrar " + ex);
            }
        }
        return animalConsultada;
    }

   public boolean eliminarAnimal(int id) {

        try {
            con = ConexionSqlSimple.getConnection();
            pstm = con.prepareStatement(DELETE_ANIMAL);
            pstm.setInt(1, id);
            resultado = pstm.executeUpdate() > 0;
           

        } catch (SQLException ex) {
            System.out.println("Error DaoAnimal- EliminarAnimal()" + ex);
        } finally {
            try {
                con.close();
                pstm.close();

            } catch (SQLException ex) {
                System.out.println("Error DaoAnimal - EliminarAnimal() - cerrarConexion " + ex);
            }
        }
        return resultado;

    }

    public boolean modificarAnimal(BeanAnimal animal) throws SQLException {
        try {
            con = ConexionSqlSimple.getConnection();
            pstm = con.prepareStatement(UPDATE_ANIMAL);

            pstm.setString(1, animal.getNombre());
            pstm.setString(2, animal.getNombreCientifico());
            pstm.setString(3, animal.getHabitad());
            pstm.setString(4, animal.getEspecie());
            pstm.setDouble(5, animal.getPeso());
            pstm.setString(6, animal.getDieta());
            pstm.setByte(7, animal.getPeligroExtincion());
            pstm.setInt(8, animal.getId());
            resultado = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error DaoAnimal- modificarAnimal()" + ex);
        } finally {
            try {
                con.close();
                pstm.close();
                

            } catch (SQLException ex) {
                System.out.println("Error DaoAnimal - modificarAnimal() - cerrarConexion " + ex);
            }
        }
        return resultado;

    }

}
