package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.Socio;

//tener una DAO para todas las clases o tabla
public class SociosDAO extends BaseDAO {

    public void guardarSocio(Socio socio) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String insert = String.format("insert into socios(nombre, curp)values('%s','%s');", socio.getNombre(), socio.getCURP());
            comando.executeUpdate(insert);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Socio consultarPorId(Integer id) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String query = String.format("SELECT idsocios,nombre,curp FROM socios WHERE idsocios = %d;", id);
            ResultSet resultado = comando.executeQuery(query);
            if (resultado.next()) {
                Socio socio = new Socio();
                socio.setId(resultado.getInt("idsocios"));
                socio.setNombre(resultado.getString("nombre"));
                socio.setCURP(resultado.getString("curp"));
                return socio;
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

    public List<Socio> obtenerSocios(String textoBusqueda) {
        ArrayList<Socio> socios = new ArrayList<>();
        Connection conn = null;
        try {
            conn = this.getConnection();
            /*para mandar comandos a la BD se utilizan los statments*/
            Statement comando = conn.createStatement();
            ResultSet resultado;
            if (textoBusqueda == null || textoBusqueda.isEmpty()) {
                resultado = comando.executeQuery("SELECT idsocios,nombre,curp FROM socios");
            } else {
                //LIKE % % busca lo que tenga parecido dentro de los %
                resultado = comando.executeQuery("SELECT idsocios,nombre,curp FROM socios "
                        + "WHERE nombre LIKE '%" + textoBusqueda + "%';");
            }

            while (resultado.next()) {
                Socio socio = new Socio();
                socio.setId(resultado.getInt("idsocios"));
                socio.setNombre(resultado.getString("nombre"));
                socio.setCURP(resultado.getString("curp"));
                socios.add(socio);
            }

            return socios;
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

    public void actualizarSocio(Socio socio) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String update = String.format("UPDATE socios SET socios.curp = '%s', socios.nombre='%s' WHERE socios.idsocios ='%s';", socio.getCURP(), socio.getNombre(), socio.getId());
            comando.executeUpdate(update);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public boolean eliminarSocio(Integer idSocio) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String delete = String.format("DELETE from socios WHERE idsocios =%d", idSocio);
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
