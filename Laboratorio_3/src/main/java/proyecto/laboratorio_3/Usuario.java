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
public class Usuario {
    String nombreUsuario;
    String password;
    Fecha fechaDeCreacion; //Definir clase Fecha
    ArrayList<Usuario> amigos = new ArrayList();
    //ArrayList<Post> posts = new ArrayList(); Definir clase post

    public Usuario(String nombreUsuario, String password, Fecha fechaDeCreacion) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaDeCreacion = fechaDeCreacion;
    }
    static Utils util = new Utils();
    static Validator validator = new Validator();
    

    /*
    public Boolean esValida(){
        
        return true;
    }*/
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        
        
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Fecha fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public boolean validaUsuario() {
        return !nombreUsuario.equals(password) && nombreUsuario.length() >= 6; //&& validaPassword() && fechaDeCreacion.esValida();
    }

    //metodo que verifica que la contraseña no tenga espacio
    /*
    public boolean contieneElemento(String Elemento){
        String[] palabra = password.split("");
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].equals(Elemento)) {
                
                return true;
            }
        }
        return false;
    }*/
    //Metodo que verifica que la contraseña tenga al menos 3 numeros
    public boolean contieneNumeros() {
        int contador = 0;
        String[] passwordList = password.split("");
        for (int i = 0; i < passwordList.length; i++) {
            if (validator.esNumero(passwordList[i])) {
                contador = contador + 1;
            }
        }
        return contador > 2;
    }

    public boolean validaPassword() {
        return password.length() >= 6 && !password.contains(" ") && contieneNumeros();
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", fechaDeCreacion=" + fechaDeCreacion + '}';
    }
    
}
