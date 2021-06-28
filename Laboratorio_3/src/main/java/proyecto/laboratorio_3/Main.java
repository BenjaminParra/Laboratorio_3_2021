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
        String opcionString = "";
        do{
            System.out.println("1. Crea Fecha");//registrar
            System.out.println("2. Crea Usuario");
            System.out.println("3. Crea Post");
            System.out.println("4. Iniciar sesion");
            System.out.println("5. Salir");
            
            System.out.println("Ingrese una opción: ");
            
            opcionString = sc.nextLine();
            validationResponse = validator.validadorOpciones(opcionString);
            if (!validationResponse.isEsValido()) {
                System.out.println(validationResponse.getMensaje());
                opcion = 6;
                
            }else{
            opcion = Integer.valueOf(opcionString);
            switch(opcion){
                case 1 -> {
                    
                    int bandera;
                    do{
                        bandera = 0;
                        //sc.nextLine();
                        System.out.println("Ingrese datos de fecha DD/MM/AAAA");
                        String entrada = sc.nextLine();
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido de la opcion 1.\n");
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
                        //sc.nextLine();
                        System.out.println("Ingrese los datos del usuario a registar con el formato >>nombreUsuario,password,fecha<< con formato DD/MM/AAAA\n");
                        String entrada = sc.nextLine();
                        String[] datosUsuario = entrada.split(",");
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido de la opcion 2. Registrar usuario\n");
                            bandera = 0;
                        }else{
                            validationResponse = validator.validadorUsuario(datosUsuario,socialNetwork);
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
                    Integer opcion1 = 0;
                    String opcioString1 = "";
                    do{
                        System.out.println("1. Publicar en Propio Perfil");
                        System.out.println("2. Publicar en el perfil de un/unos amigo/os");
                        System.out.println("3. Salir");
                        System.out.println("Ingrese una opción: ");
                        opcioString1 = sc.nextLine();
                        validationResponse = validator.validadorOpciones(opcioString1);
                        if (!validationResponse.isEsValido()) {
                            System.out.println(validationResponse.getMensaje());
                            opcion = 4;
                        }else{
                            opcion1 = Integer.valueOf(opcioString1);
                        


                        switch(opcion1){
                            case 1 -> {
                                
                                System.out.println("publicaste en tu perfil");
                                opcion1 = 3;
                            }
                            case 2 -> {
                                System.out.println("publicaste en otro perfil");
                                opcion1 = 3;
                            }
                            case 3 ->{
                                
                            }
                            
                            default -> System.out.println("La opción no está disponible.");
                        }
                        }
                    }while(opcion1 != 3);
                    
                    
                }
                case 4 ->{
                    int bandera;
                    do{
                        bandera = 0;
                        System.out.println("Ingrese los datos para iniciar sesion con el siguiente formato nombreUsuario,password");
                        String entrada = sc.nextLine();
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Has salido de la opcion 4. Iniciar sesión\n");
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
            }
            
            
        }while(opcion != 5);
        
        
        /*
        Integer opcion = 0;
        System.out.println("Ingrese una opción: ");
        String entrada = sc.nextLine();
        if (validator.esNumero(entrada)) {
            opcion = Integer.valueOf(entrada);
            System.out.println(opcion);
            
        }else{
        System.out.println("Te fuiste a la verga");
        }*/
        
//        int banderaExterna;
//        
//        do {
//            System.out.println("1. Crea Fecha");//registrar
//            System.out.println("2. Crea Usuario");
//            System.out.println("3. Crea Post");
//            System.out.println("4. Iniciar sesion");
//            System.out.println("5. Salir");
//            System.out.println("Ingrese una opción: ");
//            String entradaString = sc.nextLine();
//            //opcion = sc.nextInt();
//            banderaExterna = 0;
//            validationResponse = validator.validadorOpciones(entradaString);
//            if (!validationResponse.isEsValido()) {
//                System.out.println(validationResponse.getMensaje());
//                banderaExterna = 1;
//            }else{
//                int opcion = Integer.valueOf(entradaString);
//                do{
//                    switch(opcion){
//                        case 1 -> {
//                            int bandera;
//                            do{
//                                bandera = 0;
//                                sc.nextLine();
//                                System.out.println("Ingrese datos de fecha DD/MM/AAAA");
//                                String entrada = sc.nextLine();
//                                if (entrada.equalsIgnoreCase("salir")) {
//                                    System.out.println("Has salido\n");
//                                    bandera = 0;
//                                }else{
//                                    String[] datos = entrada.split("/");
//                                    validationResponse = validator.validadorFecha(datos);
//                                    if (validationResponse.isEsValido()) {
//                                        Fecha fecha = new Fecha(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]));
//                                    }else{
//                                        System.out.println(validationResponse.getMensaje());
//                                        bandera=1;
//                                    }
//                                }
//                            }while(bandera != 0);
//                        }
//                        case 2 -> {
//                            int bandera;
//                            do{
//                                bandera = 0;
//                                sc.nextLine();
//                                System.out.println("Ingrese los datos del usuario a registar con el formato >>nombreUsuario,password,fecha<< con formato DD/MM/AAAA\n");
//                                String entrada = sc.nextLine();
//                                String[] datosUsuario = entrada.split(",");
//                                if (entrada.equalsIgnoreCase("salir")) {
//                                    System.out.println("Has salido\n");
//                                    bandera = 0;
//                                }else{
//                                    validationResponse = validator.validadorUsuario(datosUsuario);
//                                    if (validationResponse.isEsValido()) {
//                                        String[] datosFecha = datosUsuario[2].split("/");
//                                        Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
//                                        Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
//                                        if (!socialNetwork.estaRegistrado(usuario.getNombreUsuario())) {
//                                            socialNetwork.registerUser(usuario);
//                                            System.out.println(socialNetwork);
//                                        }else{
//                                            validationResponse.setMensaje("el usuario se encuentra registrado");
//                                            System.out.println(validationResponse.getMensaje());
//                                        }
//                                    }else{
//                                        System.out.println(validationResponse.getMensaje());
//                                        bandera = 1;
//                                    }
//                                }
//                            }while(bandera != 0);
//                            /*
//                            Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
//                            Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
//                            System.out.println(usuario);*/
//                        }
//                        case 3 -> {
//                            int opcion1 = 0;
//                            do{
//                                System.out.println("1. Publicar en Propio Perfil");
//                                System.out.println("2. Publicar en el perfil de un/unos amigo/os");
//                                System.out.println("3. Salir");
//                                System.out.println("Ingrese una opción: ");
//                                opcion1 = sc.nextInt();
//                                switch(opcion1){
//                                    case 1 -> {
//                                        System.out.println("publicaste en tu perfil");}
//                                    case 2 -> {
//                                        System.out.println("publicaste en otro perfil");
//                                    }
//                                    case 3 ->{
//                                    }
//                                    default -> System.out.println("La opción no está disponible.");
//                                }
//                            }while(opcion1 != 3);
//                        }
//                        case 4 ->{
//                            int bandera;
//                            do{
//                                bandera = 0;
//                                sc.nextLine();
//                                System.out.println("Ingrese los datos para iniciar sesion con el siguiente formato nombreUsuario,password");
//                                String entrada = sc.nextLine();
//                                if (entrada.equalsIgnoreCase("salir")) {
//                                    System.out.println("Has salido\n");
//                                    bandera = 0;
//                                }else{
//                                    String[] datos = entrada.split(",");
//                                    validationResponse = validator.validadorLogin(datos,socialNetwork);
//                                    if (validationResponse.isEsValido()) {
//                                        Usuario user = socialNetwork.getUsuarioConNombre(datos[0]);
//                                        user.setEstado(true);
//                                        socialNetwork.actualizaUsuario(user);
//                                        System.out.println(socialNetwork);
//                                    }else{
//                                        System.out.println(validationResponse.getMensaje());
//                                        bandera=1;
//                                    }
//                                }
//                            }while(bandera != 0);
//                        }
//                        case 5 -> System.exit(0);
//                        default -> System.out.println("La opción no está disponible.");
//                    }
//                }while(opcion != 5);
//            }
//        } while (banderaExterna !=0);
    }
}
