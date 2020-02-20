package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.Barco;

public class BarcosDAO extends BaseDAO {

    public List<Barco> obtenerBarcos(String textoBusqueda) {
        SociosDAO socio = new SociosDAO();
        ArrayList<Barco> barcos = new ArrayList<>();
        Connection conn = null;
        try {
            conn = this.getConnection();
            /*para mandar comandos a la BD se utilizan los statments*/
            Statement comando = conn.createStatement();
            ResultSet resultado;
            if (textoBusqueda == null || textoBusqueda.isEmpty()) {
                resultado = comando.executeQuery("SELECT idbarcos,matricula,nombre,numamarre,cuota,idsocios FROM barcos");
            } else {
                //LIKE % % busca lo que tenga parecido dentro de los %
                resultado = comando.executeQuery("SELECT idbarcos,matricula,nombre,numamarre,cuota,idsocios FROM barcos "
                        + "WHERE nombre LIKE '%" + textoBusqueda + "%';");
            }

            while (resultado.next()) {
                Barco barco = new Barco();
                barco.setId(resultado.getInt("idbarcos"));
                barco.setNombre(resultado.getString("nombre"));
                barco.setMatricula(resultado.getString("matricula"));
                barco.setNumAmarre(resultado.getInt("numamarre"));
                barco.setCuota(resultado.getFloat("cuota"));
                barco.setSocio(socio.consultarPorId(resultado.getInt("idsocios")));
                barcos.add(barco);
            }

            return barcos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void guardarBarco(Barco barco) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String insert = String.format("insert into barcos(nombre, matricula, numamarre, cuota,idsocios)values('%s','%s','%d','%f','%d');", barco.getNombre(), barco.getMatricula(), barco.getNumAmarre(), barco.getCuota(), barco.getSocio().getId());
            comando.executeUpdate(insert);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void actualizarBarco(Barco barco) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String update = String.format("UPDATE barcos SET barcos.nombre = '%s', barcos.numamarre='%s', barcos.cuota='%s', barcos.idsocios='%s', barcos.matricula='%s' WHERE barcos.idbarcos ='%s';",
                    barco.getNombre(), barco.getNumAmarre(), barco.getCuota(), barco.getSocio().getId(), barco.getMatricula(), barco.getId());
            comando.executeUpdate(update);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Barco consultarPorId(Integer id) {
        SociosDAO socio = new SociosDAO();
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String query = String.format("SELECT idbarcos,matricula,nombre,numamarre,cuota,idsocios FROM barcos WHERE idbarcos = %d;", id);
            ResultSet resultado = comando.executeQuery(query);
            if (resultado.next()) {
                Barco barco = new Barco();
                barco.setId(resultado.getInt("idbarcos"));
                barco.setNombre(resultado.getString("nombre"));
                barco.setMatricula(resultado.getString("matricula"));
                barco.setNumAmarre(resultado.getInt("numamarre"));
                barco.setCuota(resultado.getFloat("cuota"));
                barco.setSocio(socio.consultarPorId(resultado.getInt("idsocios")));
                return barco;
            }
            conn.close();
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
//        }finally{
//            return null;
//        }
    }

    public boolean eliminarBarco(Integer idbarco) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String delete = String.format("DELETE from barcos WHERE barcos.idbarcos =%d", idbarco);
            comando.executeUpdate(delete);
            //buena practica cerrar conexiones
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
