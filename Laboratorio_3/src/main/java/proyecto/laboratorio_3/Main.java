/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.laboratorio_3;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(date);
        String[] fechaClase = fechaFormateada.split("/");
        Fecha fechita = new Fecha(Integer.valueOf(fechaClase[0]),Integer.valueOf(fechaClase[1]),Integer.valueOf(fechaClase[2]));
        SocialNetwork socialNetwork = new SocialNetwork("Facebook",fechita);
        System.out.println(socialNetwork);
        
        Usuario user = new Usuario("BenjaminParra",  "benja123", fechita);
        Post post = new Post(user,fechita,"holaATodos.text",1);
        Usuario user2 = new Usuario("ChiloParra",  "benja123", fechita);
        
        
        
        
        
       /*
        user.agregaAmigo(user2);
        
        System.out.println(user);
        
        user.agregaPost(post);
        
        String opcioString = "";
        System.out.println(user);
        System.out.println("Ingrese las publicacion  y la lista de destinatarios con el siguiente formato: \n");
        System.out.println("texto.tipo/user1,user2,...");
        opcioString = sc.nextLine();
        
        String[] entradaSplit = opcioString.split("/");*/
        
        
        
        //System.out.println(user.getUnfriends(amigosSplit));
        //System.out.println(user.dejaAmigos(amigosSplit));
        
        
//        int opcionInicio = 0;
//        String opcionInicioString = "";
//        
//        do {    
//            System.out.println("### RED SOCIAL: "+socialNetwork.getNombreSocialNetwork() +" ###\n");
//            System.out.println("1. Iniciar Sesión");//registrar
//            System.out.println("2. Registrar Usuario");
//            System.out.println("3. Salir");
//            System.out.println("Escoja una opción mediante los números");
//            
//            opcionInicioString = sc.nextLine();
//            validationResponse = validator.validadorOpciones(opcionInicioString);
//            if (!validationResponse.isEsValido()) {
//                System.out.println(validationResponse.getMensaje());
//                
//            }else{
//                opcionInicio = Integer.valueOf(opcionInicioString);
//                switch(opcionInicio){
//                    case 1 ->{
//                        int bandera;
//                        do{
//                            bandera = 0;
//                            System.out.println("Ingrese los datos para iniciar sesion con el siguiente formato nombreUsuario,password");
//                            String entrada = sc.nextLine();
//                            if (entrada.equalsIgnoreCase("salir")) {
//                                System.out.println("Has salido de la opcion 1. Iniciar sesión\n");
//                                bandera = 0;
//                            }else{
//                                String[] datos = entrada.split(",");
//                                validationResponse = validator.validadorLogin(datos,socialNetwork);
//                                if (validationResponse.isEsValido()) {
//                                    Usuario user = socialNetwork.getUsuarioConNombre(datos[0]);
//                                    user.setEstado(true);
//                                    socialNetwork.actualizaUsuario(user);
//                                    //aqui va otro menú
//                                    
//                                    int opcion = 0;
//                                    String opcionString = "";
//                                    int bandera1;
//                                    do {
//                                        System.out.println("### RED SOCIAL: "+socialNetwork.getNombreSocialNetwork() +" ###\n");
//                                        //System.out.println(socialNetwork);
//                                        //System.out.println(socialNetwork.getUserOnline());
//                                        System.out.println("### Registrado como: "+user.nombreUsuario+" ###");
//                                        System.out.println("1. Realizar publicación");
//                                        System.out.println("2. Seguir a un usuario");
//                                        System.out.println("3. Compartir publicación");
//                                        System.out.println("4. Visualizar red social");
//                                        System.out.println("5. Cerrar sesión");//debo volver al menú principal
//                                        System.out.println("6. Salir del programa");
//                                        System.out.println("Escoja una opción mediante los números");
//                                        
//                                        opcionString = sc.nextLine();
//                                        validationResponse = validator.validadorOpciones(opcionString);
//                                        if (!validationResponse.isEsValido()) {
//                                            System.out.println(validationResponse.getMensaje());
//                                            opcion = 7;
//                                        }else{
//                                            opcion = Integer.valueOf(opcionString);
//                                            switch(opcion){
//                                                case 1 ->{
//                                                    Integer opcion1 = 0;
//                                                    String opcioString1 = "";
//                                                    do{
//                                                        System.out.println("1. Publicar en Propio Perfil");
//                                                        System.out.println("2. Publicar en el perfil de un/unos amigo/os");
//                                                        System.out.println("3. Salir");
//                                                        System.out.println("Ingrese una opción: ");
//                                                        opcioString1 = sc.nextLine();
//                                                        validationResponse = validator.validadorOpciones(opcioString1);
//                                                        if (!validationResponse.isEsValido()) {
//                                                            System.out.println(validationResponse.getMensaje());
//                                                            opcion1 = 4;
//                                                        }else{
//                                                            opcion1 = Integer.valueOf(opcioString1);
//                                                            switch(opcion1){
//                                                                case 1 -> {
//                                                                    int banderaPostSolo;
//                                                                    do{
//                                                                        banderaPostSolo = 0;
//                                                                        //Integer opcion1 = 0;
//                                                                        String opcioString = "";
//                                                                        System.out.println("Ingrese la publicacion con el siguiente formato >>texto.tipo<<");
//                                                                        opcioString = sc.nextLine();
//                                                                        String auxPost = opcioString;
//                                                                        if (opcioString.equalsIgnoreCase("salir")) {
//                                                                            System.out.println("Has salido de la opcion 1. Publicar en Propio Perfil\n");
//                                                                            banderaPostSolo = 1;
//                                                                        }else{
//                                                                            //validar postSolo
//                                                                            String[] postSoloSplit = opcioString.split("\\.");
//                                                                            validationResponse = validator.validadorPostSolo(postSoloSplit,socialNetwork,fechita);
//                                                                            if (!validationResponse.isEsValido()) {
//                                                                                System.out.println(validationResponse.getMensaje());
//                                                                                banderaPostSolo = 1;
//                                                                                }else{
//                                                                                Post postSolitoSN = new Post(socialNetwork.getUserOnline(),fechita,auxPost,socialNetwork.getIDNewPost());
//                                                                                Post postSolitoUser = new Post(socialNetwork.getUserOnline(),fechita,auxPost,socialNetwork.getUserOnline().getIDNewPost());
//                                                                                user.getPosts().add(postSolitoUser);
//                                                                                socialNetwork.getPublicaciones().add(postSolitoSN);//esta bueno
//                                                                                System.out.println(socialNetwork);
//                                                                                System.out.println("El usuario "+socialNetwork.getUserOnline().getNombreUsuario()+" realizo la publicacion en su muro");
//                                                                                //socialNetwork.turnOffUser();
//
//                                                                                }
//                                                                            }
//                                                                    }while(banderaPostSolo != 0);
//                                                                    opcion1 = 3;
//                                                                }
//                                                                case 2 -> {//post en otros perfiles
//                                                                    int banderaPostAmigos;
//                                                                    do {  
//                                                                        banderaPostAmigos = 0;
//                                                                        String opcioString = "";
//                                                                        System.out.println("Ingrese las publicacion  y la lista de destinatarios con el siguiente formato: \n");
//                                                                        System.out.println("texto.tipo/user1,user2,...");
//                                                                        opcioString = sc.nextLine();
//                                                                        if (opcioString.equalsIgnoreCase("salir")) {
//                                                                            System.out.println("Has salido de la opcion 2. Publicar en el perfil de otros\n");
//                                                                            banderaPostAmigos = 1;
//                                                                        }else{
//                                                                            String[] postAmigosSplit = opcioString.split("/");
//                                                                            String[] receptores = postAmigosSplit[1].split(",");
//                                                                            socialNetwork.getUserOnline().getUnfriends(receptores);
//                                                                        
//                                                                        
//                                                                        
//                                                                        }
//                                                                    } while (banderaPostAmigos !=0);
//                                                                    
//                                                                    
//                                                                    
//                                                                    //System.out.println("publicaste en otro perfil");
//                                                                    
//                                                                    opcion1 = 3;
//                                                                }
//                                                                case 3 ->{
//                                                                }
//                                                                default -> System.out.println("La opción no está disponible.");
//                                                            }
//                                                        }
//                                                    }while(opcion1 != 3);
//                                                }
//                                                case 2 ->{//seguir usuario
//                                                    int banderaSeguir;
//                                                    do{
//                                                        banderaSeguir = 0;
//                                                        //Integer opcion1 = 0;
//                                                        String opcioString1 = "";
//                                                        System.out.println("Ingrese el nombre del usuario seguir.\n");
//                                                        opcioString1 = sc.nextLine();
//                                                        if (opcioString1.equalsIgnoreCase("salir")) {
//                                                            System.out.println("Has salido de la opcion 2. Seguir Usuario\n");
//                                                            banderaSeguir = 0;
//                                                        }else{
//                                                        validationResponse = validator.validadorSeguir(opcioString1,socialNetwork);
//                                                            if (!validationResponse.isEsValido()) {
//                                                                System.out.println(validationResponse.getMensaje());
//                                                                banderaSeguir = 1;
//                                                                }else{
//                                                                    socialNetwork.getUserOnline().getAmigos().add(socialNetwork.getUsuarioConNombre(opcioString1));
//                                                                    System.out.println(socialNetwork.getUserOnline());
//                                                                    System.out.println("El usuario "+opcioString1+" se encuentra en tu lista de amigos");
//                                                                    //socialNetwork.turnOffUser();
//                                                                    System.out.println(socialNetwork);
//                                                                    
//                                                                }
//                                                            }
//                                                    }while(banderaSeguir != 0);
//                                                }
//                                                case 3 ->{//compartir publicacion
//                                                }
//                                                case 4 ->{//visualizar redSocial
//                                                    System.out.println(socialNetwork);
//                                                }
//                                                case 5 ->{//cerrar sesion
//                                                        socialNetwork.turnOffUser();
//                                                        System.out.println("Has cerrado sesión");
//                                                        opcion = 6;
//                                                }
//                                                case 6 ->{//salir programa
//                                                }
//                                                default -> System.out.println("\nLa opción no está disponible.\n");
//                                            }
//                                            
//                                        }
//                                    } while (opcion !=6);
//                                    /*System.out.println(socialNetwork);
//                                }else{
//                                    System.out.println(validationResponse.getMensaje());
//                                    bandera=1;*/
//                                }else{
//                                    System.out.println(validationResponse.getMensaje());
//                                    bandera=1;
//                                    
//                                }
//                            }
//                        }while(bandera != 0);
//                    }
//                    case 2 ->{
//                        int bandera;
//                        do{
//                            bandera = 0;
//                            //sc.nextLine();
//                            System.out.println("Ingrese los datos del usuario a registar con el formato >>nombreUsuario,password,fecha<< con formato DD/MM/AAAA\n");
//                            String entrada = sc.nextLine();
//                            String[] datosUsuario = entrada.split(",");
//                            if (entrada.equalsIgnoreCase("salir")) {
//                                System.out.println("Has salido de la opcion 2. Registrar usuario\n");
//                                bandera = 0;
//                            }else{
//                                validationResponse = validator.validadorUsuario(datosUsuario,socialNetwork);
//                                if (validationResponse.isEsValido()) {
//                                    String[] datosFecha = datosUsuario[2].split("/");
//                                    Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
//                                    Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
//                                    if (!socialNetwork.estaRegistrado(usuario)) {
//                                        socialNetwork.registerUser(usuario);
//                                        System.out.println(socialNetwork);
//
//                                    }
//                                }else{
//                                    System.out.println(validationResponse.getMensaje());
//                                    bandera = 1;
//                                }
//                            }
//                        }while(bandera != 0);
//                    }
//                    case 3 ->{
//                    }
//                    default -> System.out.println("Ingrese una opción válida\n");
//                }
//            }
//            
//        } while (opcionInicio != 3);
        
        
//        
        
        
        
    }
}
