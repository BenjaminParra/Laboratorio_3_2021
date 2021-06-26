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
    
    static Utils util = new Utils();
    static Validator validator = new Validator();
    static ValidationResponse validationResponse = new ValidationResponse();
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        /*
        System.out.println("Ingrese datos de fecha DD/MM/AAAA");
        String[] datos = sc.nextLine().split("/");
        //System.out.println(datos[0]);
        validationResponse = validator.validadorFecha(datos);
        System.out.println(validationResponse.isEsValido());
        //validationResponse = validator.validadorFecha(datos);*/
        /*
        Fecha fechita = new Fecha(12, 4, 2021);
        Usuario user = new Usuario("BenjaminParra","BenjamiParra",fechita);
        
        System.out.println(user.contieneNumeros());*/
        
        int opcion = 0;
        do{
            System.out.println("1. Crea Fecha");//registrar
            System.out.println("2. Crea Usuario");
            System.out.println("3. Crea Post");
            System.out.println("4. Opcion");
            
            System.out.println("Ingrese una opción: ");
            opcion = sc.nextInt();
            
            
            switch(opcion){
                case 1 -> {
                    int bandera;
                    do{
                        bandera = 0;
                        sc.nextLine();
                        System.out.println("Ingrese datos de fecha DD/MM/AAAA");
                        String[] datos = sc.nextLine().split("/");
                        validationResponse = validator.validadorFecha(datos);
                        if (validationResponse.isEsValido()) {
                            Fecha fecha = new Fecha(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]));
                            //System.out.println(fecha);
                            
                        }else{
                            System.out.println(validationResponse.getMensaje());
                            
                            bandera=1;
                        }
                        /*
                        try{
                            bandera = 0;
                            sc.nextLine();
                            System.out.println("Ingrese datos de fecha DD/MM/AAAA");
                            String[] datos = sc.nextLine().split("/");
                            Fecha fecha = new Fecha(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]));
                            System.out.println(fecha.esValida());
                            System.out.println(fecha);
                        }catch(NumberFormatException e){
                            System.out.println("Caracteres no validos");
                            bandera=1;
                            //sc.nextLine();
                        }*/
                    }while(bandera != 0);
                    
                }
                case 2 -> {
                    int bandera;
                    do{
                        bandera = 0;
                        sc.nextLine();
                        System.out.println("Ingrese del usuario NombreUsuario,Password,FechaDeCreacion con formato DD/MM/AAAA");
                        String[] datosUsuario = sc.nextLine().split(",");
                       validationResponse = validator.validadorUsuario(datosUsuario);
                        if (validationResponse.isEsValido()) {
                            String[] datosFecha = datosUsuario[2].split("/");
                            Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
                            Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
                            System.out.println(usuario);

                        }else{
                            System.out.println(validationResponse.getMensaje());
                            bandera = 1;
                        }
                    }while(bandera != 0);
                    
                    /*
                    Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
                    Usuario usuario = new Usuario(datosUsuario[0],datosUsuario[1],fechaUser);
                    System.out.println(usuario);*/
                    
                    
                   
                    
                }
                case 3 -> {
                }
                case 4 -> System.exit(0);
                
                default -> System.out.println("La opción no está disponible.");
               
                   
            
            }
            
        }while(opcion != 4);
    }
    
    
}
