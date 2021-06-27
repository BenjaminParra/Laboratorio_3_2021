/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.laboratorio_3;

/**
 *
 * @author Benjamin Parra
 */
public class Validator {
    public ValidationResponse validadorFecha(String[] fecha){
        ValidationResponse validationResponse = new ValidationResponse();
        //Utils utils = new Utils();
        boolean esValido = true;
	String mensajeValidacion = "";
        
        if (!esFecha(fecha)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + "\nAsegurese de ingresar numeros en el campo de la fecha";
        }else{
            Fecha fecha1 = new Fecha(Integer.valueOf(fecha[0]),Integer.valueOf(fecha[1]),Integer.valueOf(fecha[2]));
            if (!fecha1.esValida()) {
                if (fecha1.getDia()>31 || fecha1.getDia()<1) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\n ERROR: El día puede tomar un valor entre 0 y 32 ";
                }else if (fecha1.getMes()>12 || fecha1.getMes()<1) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\n ERROR: El mes puede tomar un valor entre 0 y 13 ";
                }else if (fecha1.getAnnio()<1) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\n ERROR: El año debe ser un valor mayor a 0";
                }else if (fecha1.getDiasDelMes()<fecha1.getDia()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "\n ERROR: De acuerdo al mes "+fecha1.getMesPalabra()+" solo se pueden tener "+fecha1.getDiasDelMes()+" dias";
                }
                
            }else{
                mensajeValidacion = mensajeValidacion + "\nFecha es valida";
            }
            
        }
        
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    
    public ValidationResponse validadorUsuario(String[] usuario){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esUsuario(usuario)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: Asegurese de ingresar los datos con el formato NombreUsuario,Contraseña,DD/MM/AAAA";
            
        }
        if (esUsuario(usuario) && !validadorFecha(usuario[2].split("/")).isEsValido()) {
            esValido = false;
            mensajeValidacion = mensajeValidacion + validadorFecha(usuario[2].split("/")).getMensaje();
        }
        if (esUsuario(usuario) && validadorFecha(usuario[2].split("/")).isEsValido()) {
            String[] datosFecha = usuario[2].split("/");
            Fecha fechaUser = new Fecha(Integer.valueOf(datosFecha[0]),Integer.valueOf(datosFecha[1]),Integer.valueOf(datosFecha[2]));
            Usuario usuario1 = new Usuario(usuario[0],usuario[1],fechaUser);
            if (!usuario1.validaUsuario()&&usuario1.validaPassword()) {
                if (usuario1.getNombreUsuario().equals(usuario1.getPassword())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña es valida, pero:\n"+ "La contraseña y NombreUsuario no pueden ser iguales";
                }else if (usuario1.getNombreUsuario().length()<6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña es valida, pero:\n"+ "El Nombre de usuario debe contener al menos 6 caracteres";
                }
            }else if (usuario1.validaUsuario() && !usuario1.validaPassword()) {
                if (usuario1.getPassword().equals(usuario1.getNombreUsuario())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: El usuario es valido, pero:\n"+ "La contraseña y NombreUsuario no pueden ser iguales";
                }else if (usuario1.getPassword().length() < 6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: El usuario es valido, pero:\n"+ "La contraseña debe contener al menos 6 caracteres";
                }else if (usuario1.getPassword().contains(" ")) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: El usuario es valido, pero:\n"+ "La contraseña no debe contener espacios";
                }else if (!usuario1.contieneNumeros()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: El usuario es valido, pero:\n"+ "La contraseña debe contener al menos 3 numeros";
                }
            }else if (!usuario1.validaUsuario() && !usuario1.validaPassword()) {
                if (usuario1.getNombreUsuario().equals(usuario1.getPassword())) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña y NombreUsuario no pueden ser iguales\n";
                }else if (usuario1.getNombreUsuario().length()<6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: El Nombre de usuario debe contener al menos 6 caracteres\n";
                }else if (usuario1.getPassword().length() < 6) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña debe contener al menos 6 caracteres\n";
                }else if (usuario1.getPassword().contains(" ")) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña no debe contener espacios\n";
                }else if (usuario1.contieneNumeros()) {
                    esValido = false;
                    mensajeValidacion = mensajeValidacion + "ERROR: La contraseña debe contener al menos 2 numeros\n";
                }
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    public ValidationResponse validadorPost(String[] post){
        ValidationResponse validationResponse = new ValidationResponse();
        boolean esValido = true;
	String mensajeValidacion = "";
        if (!esPost(post)){
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: Asegurese de ingresar los datos con el formato NombreUsuario,Contraseña,DD/MM/AAAA";
        }else if (esPost(post)) {
            
            
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    public ValidationResponse validadorLogin(String[] usuario,SocialNetwork socialNetwork){
        ValidationResponse validationResponse = new ValidationResponse();
        String mensajeValidacion = "";
        boolean esValido = true;
        if (!esLogin(usuario)) {
            esValido = false;
            mensajeValidacion = mensajeValidacion +"\nERROR: Asegurese de ingresar los datos con el formato NombreUsuario,Contraseña";
        }else{
            if (!socialNetwork.validaLogin(usuario[0], usuario[1])) {
                esValido = false;
                mensajeValidacion = mensajeValidacion +socialNetwork.errorLogin(usuario[0], usuario[1]);
            }
        }
        validationResponse.setEsValido(esValido);
        validationResponse.setMensaje(mensajeValidacion);
        return validationResponse;
    }
    
    
    public boolean esFecha(String[] strSplit) {
        //String[] strSplit = str.split("/");
        //Double.parseDouble(str);  
        return strSplit.length==3 && esNumero(strSplit[0]) && esNumero(strSplit[1]) && esNumero(strSplit[2]);
    }
    
    
    public boolean esUsuario(String[] strSplit){
        //String[] fecha = strSplit[2].split("/");
        return strSplit.length==3 /*&& esFecha(fecha)*/ && !esNumero(strSplit[0]) && !esNumero(strSplit[1]) && !strSplit[2].isEmpty();
        
    }
    //Metodo que verifica si el elemento es un numero
    public boolean esNumero(String str) {
        try {
            Double.parseDouble(str);  
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    
    public boolean esPost(String[] strSplit){
        return strSplit.length == 5 && esNumero(strSplit[0]) && !strSplit[1].isEmpty() && !strSplit[2].isEmpty() && !esNumero(strSplit[3]) && !esNumero(strSplit[4]);
    }
    
    public boolean esLogin(String[] strSplit){
        return strSplit.length == 2 && !esNumero(strSplit[0]) && !esNumero(strSplit[1]);
    }
    
    
    
    
    
    
    /*
    public ValidationResponse validadorCompleto(String ingreso) {
		ValidationResponse validationResponse = new ValidationResponse();
		
		String[] datosIngresados = ingreso.split(",");
		String nombre = datosIngresados[0];
		String edad = datosIngresados[1];
		boolean esValido = true;
		String mensajeValidacion = "";
		
		if (!validaNombre(nombre)) {
			esValido = false;
			mensajeValidacion = mensajeValidacion + "\nNombre no valido";
		}
		
		if (!validaEdad(edad)) {
			esValido = false;
			mensajeValidacion = mensajeValidacion + "\nEdad no valido";
		}
		
		validationResponse.setEsValido(esValido);
		validationResponse.setMensaje(mensajeValidacion);
		
		return validationResponse;
	}*/
	
        
	/*
	private boolean validaNombre(String algo) {
		
		return (algo.equalsIgnoreCase("Botoro"));
	}
	
	private boolean validaEdad(String algo) {
		
		try {
			Integer.valueOf(algo);
		} catch (Exception e) {
			//System.err.println("No es valido"+e);
			return false;
		}
		return true;
	}*/
    
}
