/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Pelicula;
import persistencia.Crud;

/**
 *
 * @author DARWIN
 */
public class PeliculaControl {
    Crud crud = new Crud();
    
    public boolean insertarPelicula(Pelicula p){
        boolean ejecuto = false;
        String sql = "INSERT INTO pelicula (nombre,descripcion,genero,tipo,director,lenguaje,duracion,puntuacion)"
                + " values('"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getGenero()+"','"+p.getTipo()+"','"+p.getDirector()+"','"+p.getLenguaje()+"','"+p.getDuracion()+"','"+p.getPuntuacion()+"');";
        System.out.println("sql: "+sql);
        if( crud.operacion(sql)){
            ejecuto = true;
        }
        return ejecuto;
    }
    
    public boolean actualizarPelicula(Pelicula p){
        boolean ejecuto = false;
        String sql = "UPDATE pelicula SET nombre = '"+p.getNombre()+"',descripcion= '"+p.getDescripcion()+"',genero= '"+p.getGenero()+"',tipo= '"+p.getTipo()+"',director= '"+p.getDirector()+"',"
                + "lenguaje= '"+p.getLenguaje()+"',duracion= "+p.getDuracion()+", puntuacion= "+p.getPuntuacion()+""
                + " WHERE id = "+p.getId()+";";
        System.out.println("sql: "+sql);
        if( crud.operacion(sql)){
            ejecuto = true;
        }
        return ejecuto;
    }
    
    
    public boolean eliminarPelicula(Pelicula p){
        boolean ejecuto = false;
        String sql = "DELETE FROM pelicula"
                + " WHERE id = "+p.getId()+";";
        System.out.println("sql: "+sql);
        if( crud.operacion(sql)){
            ejecuto = true;
        }
        return ejecuto;
    }
    
    public ArrayList<Pelicula> listarTodo(){
    
        ArrayList<Pelicula> lista = new ArrayList<>();
        try{
        ResultSet rs = crud.listar("SELECT * FROM pelicula WHERE tipo='pelicula';");
        
        while ( rs.next() ) {
            
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  descripcion  = rs.getString("descripcion");
            String  genero = rs.getString("genero");
            String  director = rs.getString("director");
            String  tipo = rs.getString("tipo");
            String  lenguaje = rs.getString("lenguaje");
            int duracion = rs.getInt("duracion");
            int puntuacion = rs.getInt("puntuacion");
            
            Pelicula p = new Pelicula(id,nombre,descripcion,genero,director,tipo,lenguaje,duracion,puntuacion);
            lista.add(p);
            
            
         }
        
        }catch(Exception e){
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        
        return  lista;
    }
    
     public ArrayList<Pelicula> listarSeries(){
    
        ArrayList<Pelicula> lista = new ArrayList<>();
        try{
        ResultSet rs = crud.listar("SELECT * FROM pelicula WHERE tipo='serie';");
        
        while ( rs.next() ) {
            
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  descripcion  = rs.getString("descripcion");
            String  genero = rs.getString("genero");
            String  director = rs.getString("director");
            String  tipo = rs.getString("tipo");
            String  lenguaje = rs.getString("lenguaje");
            int duracion = rs.getInt("duracion");
            int puntuacion = rs.getInt("puntuacion");
            
            Pelicula p = new Pelicula(id,nombre,descripcion,genero,director,tipo,lenguaje,duracion,puntuacion);
            lista.add(p);
            
            
         }
        
        }catch(Exception e){
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        
        return  lista;
    }
    
    public ArrayList<Pelicula> ranking(){
    
        ArrayList<Pelicula> lista = new ArrayList<>();
        try{
        ResultSet rs = crud.listar("SELECT * FROM pelicula WHERE puntuacion > 80 ORDER BY puntuacion DESC;");
        
        while ( rs.next() ) {
            
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  descripcion  = rs.getString("descripcion");
            String  genero = rs.getString("genero");
            String  director = rs.getString("director");
            String  tipo = rs.getString("tipo");
            String  lenguaje = rs.getString("lenguaje");
            int duracion = rs.getInt("duracion");
            int puntuacion = rs.getInt("puntuacion");
            
            Pelicula p = new Pelicula(id,nombre,descripcion,genero,director,tipo,lenguaje,duracion,puntuacion);
            lista.add(p);
            
            
         }
        
        }catch(Exception e){
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        
        return  lista;
    }
    
    
    public Pelicula leerid(int id){
        Pelicula peli = null;
        
        try{
        ResultSet rs = crud.listar("SELECT * FROM pelicula WHERE id ="+id+";");
        
        while ( rs.next() ) {
            peli = new Pelicula();
            
            peli.setId(rs.getInt("id"));
            peli.setNombre(rs.getString("nombre"));
            peli.setDescripcion(rs.getString("descripcion"));
            peli.setGenero(rs.getString("genero"));
            peli.setDirector(rs.getString("director"));
            peli.setTipo(rs.getString("tipo"));
            peli.setLenguaje(rs.getString("lenguaje"));
            peli.setDuracion(rs.getInt("duracion"));
            peli.setPuntuacion(rs.getInt("puntuacion"));
        
        }
        
        }catch(Exception e){
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return peli;
        
    }
  /*
    public static void main(String[] args) {
        Pelicula p = new Pelicula("aaa","bbb","pelicula","ddd","ee","ff",1,3);
        PeliculaControl pc = new PeliculaControl();
        
        pc.insertarPelicula(p);
    }
*/
}
