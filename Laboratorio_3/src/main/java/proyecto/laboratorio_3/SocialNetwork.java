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
public class SocialNetwork {
    String nombreSocialNetwork;
    Fecha fecha;
    ArrayList<Usuario> usuarios = new ArrayList();
    ArrayList<Post> publicaciones = new ArrayList();

    public SocialNetwork(String nombreSocialNetwork, Fecha fecha) {
        this.nombreSocialNetwork = nombreSocialNetwork;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" + "nombreSocialNetwork=" + nombreSocialNetwork + ", fecha=" + fecha + ", usuarios=" + usuarios + ", publicaciones=" + publicaciones + '}';
    }
    
    public boolean estaRegistrado(Usuario user){
        return usuarios.contains(user);
    }
    public boolean estaRegistrado(String nombreUsuario){
        for (int i = 0; i < usuarios.size(); i++) {
            return usuarios.get(i).getNombreUsuario().equals(nombreUsuario);
            
        }
        return false;
    }
    //metodo que valida el login de un usuario dado un nombre y contraseña
    public boolean validaLogin(String user, String password){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(user) && usuarios.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public String errorLogin(String user, String password){
        String mensaje = "";
        if (estaRegistrado(user)) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombreUsuario().equals(user) && !usuarios.get(i).getPassword().equals(password)) {
                    mensaje = mensaje + "El usuario se encuentra registrado, pero la contraseña no es valida";
                }
            }
            
        }else{
            mensaje = mensaje + "El usuario no se encuentra registrado";
        }
        return mensaje;
    }
    
    public void registerUser(Usuario user){
        if (!estaRegistrado(user)){
            usuarios.add(user);
        }
    }
    
    public Usuario getUsuarioConNombre(String user){
        if (estaRegistrado(user)) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getNombreUsuario().equals(user)) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }
    
    public void actualizaUsuario(Usuario usuario){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())) {
                usuarios.set(i, usuario);
            }
        }
    }
    
    
    //CONSULTAR BOTORO sobre el null
    public Usuario getUserOnline(){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).isEstado()) {
                return usuarios.get(i);
            }
        }return null;
    }
    
    
    
}


