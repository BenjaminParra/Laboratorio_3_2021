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
// Fecha, Contenido, [NombreUsuario,NombreUsuario2 ]
    
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
    
    public boolean validaTipo(){
        return (contenido.contains(".text"))|| (contenido.contains(".video"))||(contenido.contains(".audio"))||(contenido.contains(".url"))||(contenido.contains(".video"));
    }
    
    public boolean ValidaContenido(){
        return !contenido.isEmpty() && validaTipo(); /*&& !contenido.split("\\.")[1].contains(" ");*/
    }

    @Override
    public String toString() {
        if (receptor.isEmpty()) {
            return "El usuario "+user.nombreUsuario +" ha realizado la publicación >>"+contenido+"<< con el ID-"+ID +"el día "+fechaDePublicacion;
        }else{
            return "Post{" + "ID=" + ID + ", user=" + user.nombreUsuario + ", fechaDePublicacion=" + fechaDePublicacion + ", contenido=" + contenido + ", receptor=" + receptor + '}';
        }
        
    }
    
    
    
    
    
    
}
