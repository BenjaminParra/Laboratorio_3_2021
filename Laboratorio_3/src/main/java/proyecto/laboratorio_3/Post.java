/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.laboratorio_3;

import java.util.ArrayList;

/**
 *
 * @author Benjamin Parra
 */
public class Post {
    Integer ID;
    Usuario user;
    Fecha fechaDePublicacion;
    String contenido;
    ArrayList<Usuario> receptor = new ArrayList();

    public Post(Usuario user, Fecha fechaDePublicacion, String contenido) {
        this.ID = 0;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
    }
    
    public Post(Usuario user, Fecha fechaDePublicacion, String contenido,Usuario Receptor){
        this.ID = 0;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
        receptor.add(Receptor);
        
    }
    
    public Post(Usuario user, Fecha fechaDePublicacion, String contenido,Integer ID){
        this.ID = ID;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
        
    }
    
    public Post(Usuario user, Fecha fechaDePublicacion, String contenido,Usuario Receptor,Integer ID){
        this.ID = ID;
        this.user = user;
        this.fechaDePublicacion = fechaDePublicacion;
        this.contenido = contenido;
        receptor.add(Receptor);
        
    }
    
    
    
    

    public Usuario getUser() {
        return user;
    }

    public Fecha getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(Fecha fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<Usuario> getReceptor() {
        return receptor;
    }

    public void setReceptor(ArrayList<Usuario> receptor) {
        this.receptor = receptor;
    }
    
}
