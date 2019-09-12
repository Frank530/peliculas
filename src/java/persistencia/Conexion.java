/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author DARWIN
 */
public class Conexion {
    private String bd = "peliculas";
    private String pass = "root";
    private String user = "postgres";
        
    
    public Connection conectar(){
    Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/"+bd+"",
            ""+user+"", ""+pass+"");
         
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return c;
    }
}
