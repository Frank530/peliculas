/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DARWIN
 */
public class Crud {
    Conexion c = new Conexion();
    
    public boolean operacion(String sql){
        boolean ejecutar = false; 
        try {
             Statement stmt = null;

             stmt = c.conectar().createStatement();


             if(stmt.executeUpdate(sql)==1){
                 return ejecutar = true;
             }

             stmt.close();
             c.conectar().commit();
             c.conectar().close();

          } catch (Exception e) {
             System.err.println( e.getClass().getName()+": "+ e.getMessage() );
             System.exit(0);

          }
      
        return ejecutar;
   
    }
    
    public ResultSet listar(String sql){
        ResultSet rs = null;
        Statement stmt = null;
        try{
         stmt = c.conectar().createStatement();
         
        rs = stmt.executeQuery( sql );
         
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      return rs;
    }
    
    public ResultSet Leerid(String sql){
        ResultSet rs = null;
        Statement stmt = null;
        try{
         stmt = c.conectar().createStatement();
         
        rs = stmt.executeQuery( "SELECT id,nombre FROM pelicula WHERE id = ?;" );
         
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      return rs;
    }
    
}
