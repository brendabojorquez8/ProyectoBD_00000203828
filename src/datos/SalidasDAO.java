package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.Salida;

public class SalidasDAO extends BaseDAO {

    public List<Salida> obtenerSalidas(String textoBusqueda) {
        BarcosDAO barcosDAO = new BarcosDAO();
        ArrayList<Salida> salidas = new ArrayList<>();
        Connection conn = null;
        try {
            conn = this.getConnection();
            /*para mandar comandos a la BD se utilizan los statments*/
            Statement comando = conn.createStatement();
            ResultSet resultado;
            if (textoBusqueda == null || textoBusqueda.isEmpty()) {
                resultado = comando.executeQuery("SELECT idsalidas,fechahora,destino,idbarcos FROM salidas");
            } else {
                //LIKE % % busca lo que tenga parecido dentro de los %
              resultado = comando.executeQuery("SELECT idsalidas,fechahora,destino, idbarcos FROM salidas "
                        + "WHERE destino LIKE '%" + textoBusqueda + "%';");;
            }

            while (resultado.next()) {
                Salida salida = new Salida();
                salida.setId(resultado.getInt("idsalidas"));
                salida.setFechaHora(resultado.getDate("fechahora"));
                salida.setDestino(resultado.getString("destino"));
                salida.setBarco(barcosDAO.consultarPorId(resultado.getInt("idbarcos")));
                salidas.add(salida);

            }

            return salidas;
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

    public void guardarSalida(Salida salida) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String insert = String.format("insert into salidas(fechahora, destino, idbarcos)values('%s','%s','%d');", salida.getFechaHora(), salida.getDestino(), salida.getBarco().getId());
            comando.executeUpdate(insert);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void actualizarSalida(Salida salida) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String update = String.format("UPDATE salidas SET salidas.fechahora = '%s', salidas.destino='%s', salidas.idbarcos='%s' WHERE salidas.idsalidas ='%s';",
                    salida.getFechaHora(), salida.getDestino(), salida.getBarco().getId(), salida.getId());
            comando.executeUpdate(update);
            //buena practica cerrar conexiones
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Salida consultarPorId(Integer id) {
        BarcosDAO barco = new BarcosDAO();
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            String query = String.format("SELECT idsalidas,fechahora,destino,idbarcos FROM salidas WHERE salidas.idsalidas = %d;", id);
            ResultSet resultado = comando.executeQuery(query);
            if (resultado.next()) {
                Salida salida = new Salida();
                salida.setId(resultado.getInt("idsalidas"));
                //objeto date o gregorian calendar
                salida.setFechaHora(resultado.getDate("fechahora"));//qué pedo
                salida.setDestino(resultado.getString("destino"));
                salida.setBarco(barco.consultarPorId(resultado.getInt("idbarcos")));
                return salida;
            }
            conn.close();
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean eliminarSalida(Integer idsalida) {
        try {
            Connection conn = this.getConnection();
            Statement comando = conn.createStatement();
            //ahorrar concatenaciones con format
            String delete = String.format("DELETE from salidas WHERE salidas.idsalidas =%d", idsalida);
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
