
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class BaseDAO  {
    
    private String cadenaConexion ="jdbc:mysql://localhost:3306/clubnautico?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        private String usuario = "root";
    private String pass = "12345678";
    
     protected Connection getConnection()throws SQLException{
      return DriverManager.getConnection(this.cadenaConexion, this.usuario, this.pass); 
   }
   
}
