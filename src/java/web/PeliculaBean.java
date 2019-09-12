/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Control.PeliculaControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import model.Pelicula;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DARWIN
 */
@ManagedBean
@SessionScoped
public class PeliculaBean implements Serializable {
    private Pelicula pelicula;
    private List<Pelicula> peliculas;
    private List<Pelicula> series;
    private List<Pelicula> ranking;
    private List<Pelicula> peliculasEliminadas;
  
    
    
    PeliculaControl pc = new PeliculaControl();

    public PeliculaBean() {
    }
    
    @PostConstruct
    public void init(){
        peliculas = pc.listarTodo();
        series = pc.listarSeries();
        ranking = pc.ranking();
        pelicula = new Pelicula();
        peliculasEliminadas = new ArrayList<>();
        
    }
    
   public String eliminar(){
       for (Pelicula p : peliculas) {
           if(p.isSelected()){
               peliculasEliminadas.add(p);
           }
       }
       
       if (!peliculasEliminadas.isEmpty()) {
            for (int i = 0; i < peliculasEliminadas.size(); i++) {
                pc.eliminarPelicula(peliculasEliminadas.get(i));
            }
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha eliminado correctamente") );
       }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necesita seleccionar al menos una pelicula para eliminar") );
       }
       init();
    return null;
   }
    
    public String guardar(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        if(pc.insertarPelicula(pelicula)){
            context.addMessage(null, new FacesMessage("Correcto",  "Guardado exitosamente") );
        }else{
            System.out.println("No se pudo guardar");
            
        }
        init();
        return null;
    }
 
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public void Buscar(Pelicula p){
        
        pelicula = pc.leerid(p.getId()); 
    }
   public void actualizar(RowEditEvent event){
        pelicula = (Pelicula) event.getObject();
        
        
        pc.actualizarPelicula(pelicula);
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha actualizado correctamente") );
    }
    
    public void cancelar(RowEditEvent event){
        pelicula = (Pelicula) event.getObject();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento cancelado!!") );
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Pelicula> getSeries() {
        return series;
    }

    public void setSeries(List<Pelicula> series) {
        this.series = series;
    }

    public List<Pelicula> getRanking() {
        return ranking;
    }

    public void setRanking(List<Pelicula> ranking) {
        this.ranking = ranking;
    }

 
  
}
