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
public class ValidationResponse {
    private boolean esValido;
	private String mensaje;
	
	public ValidationResponse() {
		super();
	}
	
	public ValidationResponse(boolean esValido, String mensaje) {
		super();
		this.esValido = esValido;
		this.mensaje = mensaje;
	}
	
	
	public boolean isEsValido() {
		return esValido;
	}
	public void setEsValido(boolean esValido) {
		this.esValido = esValido;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
        
	@Override
	public String toString() {
		return "ValidationResponse [esValido=" + esValido + ", mensaje=" + mensaje + "]";
	}
    
}
