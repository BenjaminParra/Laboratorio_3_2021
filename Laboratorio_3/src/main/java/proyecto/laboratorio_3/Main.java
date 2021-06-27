/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.laboratorio_3;

import java.util.Scanner;

/**
 *
 * @author Benjamin Parra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    
    //static Utils util = new Utils();
    static Validator validator = new Validator();
    static ValidationResponse validationResponse = new ValidationResponse();
    
    public static void main(String[] args) {
        Fecha fechita = new Fecha(12,2,2021);
        SocialNetwork socialNetwork = new SocialNetwork("Facebook",fechita);
        int opcion = 0;
        do{
            System.out.println("1. Crea Fecha");//registrar
            System.out.println("2. Crea Usuario");
            System.out.println("3. Crea Post");
            System.out.println("4. Iniciar sesion");
            System.out.println("5. Salir");
            
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            
            
            switch(opcion){
                case 1 -> {
                    
                    int bandera;
                    do{
                        bandera = 0;
                        sc.nextLine();
                        System.out.println("Ingrese datos de fecha DD/MM/AAAA");
                        String entrada = sc.nextLine();
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido\n");
                            bandera = 0;
                        }else{
                            String[] datos = entrada.split("/");
                            validationResponse = validator.validadorFecha(datos);
                            if (validationResponse.isEsValido()) {
                                Fecha fecha = new Fecha(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]));
                                System.out.println(fecha);
                            }else{
                                System.out.println(validationResponse.getMensaje());
                                bandera=1;
                            }
                        }
                    }while(bandera != 0);
                }
                case 2 -> {
                    int bandera;
                    do{
                        bandera = 0;
                        sc.nextLine();
                        System.out.println("Ingrese los datos del usuario a registar con el formato >>nombreUsuario,password,fecha<< con formato DD/MM/AAAA\n");
                        String entrada = sc.nextLine();
                        String[] datosUsuario = entrada.split(",");
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido\n");
                            bandera = 0;
                        }else{
                            validationResponse = validator.validadorUsuario(datosUsuario);
                            if (validationResponse.isEsValido()) {
                                String[] datosFecha = datosUsuario[2].split("/");
                                Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
                                Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
                                if (!socialNetwork.estaRegistrado(usuario)) {
                                    socialNetwork.registerUser(usuario);
                                    System.out.println(socialNetwork);
                                    
                                }
                            }else{
                                System.out.println(validationResponse.getMensaje());
                                bandera = 1;
                            }
                        }
                    }while(bandera != 0);
                    
                    /*
                    Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
                    Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
                    System.out.println(usuario);*/
                    
                    
                   
                    
                }
                case 3 -> {
                    int opcion1 = 0;
                    do{
                        System.out.println("1. Publicar en Propio Perfil");
                        System.out.println("2. Publicar en el perfil de un/unos amigo/os");
                        System.out.println("3. Salir");
                        System.out.println("Ingrese una opción: ");
                        opcion1 = sc.nextInt();


                        switch(opcion1){
                            case 1 -> {
                                System.out.println("publicaste en tu perfil");}
                            case 2 -> {
                                System.out.println("publicaste en otro perfil");
                            }
                            case 3 ->{
                                
                            }
                            
                            default -> System.out.println("La opción no está disponible.");
                        }
                    }while(opcion1 != 3);
                    
                }
                case 4 ->{
                    int bandera;
                    do{
                        bandera = 0;
                        sc.nextLine();
                        System.out.println("Ingrese los datos para iniciar sesion con el siguiente formato nombreUsuario,password");
                        String entrada = sc.nextLine();
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido\n");
                            bandera = 0;
                        }else{
                            String[] datos = entrada.split(",");
                            validationResponse = validator.validadorLogin(datos,socialNetwork);
                            if (validationResponse.isEsValido()) {
                                Usuario user = socialNetwork.getUsuarioConNombre(datos[0]);
                                user.setEstado(true);
                                socialNetwork.actualizaUsuario(user);
                                System.out.println(socialNetwork);
                            }else{
                                System.out.println(validationResponse.getMensaje());
                                bandera=1;
                            }
                        }
                    }while(bandera != 0);
                    
                }
                
                case 5 -> System.exit(0);
                
                
                default -> System.out.println("La opción no está disponible.");
               
                   
            
            }
            
        }while(opcion != 5);
    }
    
    
}
