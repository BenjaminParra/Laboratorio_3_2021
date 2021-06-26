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
public class Fecha {
    Integer dia;
    Integer mes;
    Integer annio;
    //String fecha = DD/MM/AAAA
    
    
    public Fecha(Integer dia, Integer mes, Integer annio) {
        this.dia = dia;
        this.mes = mes;
        this.annio = annio;
    }
    

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }

    @Override
    public String toString() {
        if ((dia < 10) && (mes < 10)) {
            return "0" + dia + "/" + "0" + mes + "/" + annio;
        }
        return dia + "/" + mes + "/" + annio;
    }

    public Boolean esValida() {
        return dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && annio > 0 && dia <= getDiasDelMes();
    }

    public Boolean esBisiesto(Integer annio) {
        return (0 == annio % 400) || ((0 == annio % 4) && (annio % 100 != 0));
    }

    public Integer getDiasDelMes() {
        if ((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) {
            return 31;
        } else if ((mes == 2) && (esBisiesto(annio))) {
            return 29;

        } else if ((mes == 2) && (esBisiesto(annio) == false)) {
            return 28;
        }
        return 30;

    }
    public String getMesPalabra(){
        Integer opcion = mes;
        switch(opcion){
            case 1 -> {
                return "Enero";
            }
            case 2 -> {
                return "Febrero";
            }
            case 3 -> {
                return "Marzo";
            }
            case 4 -> {
                return "Abril";
            }
            case 5 -> {
                return "Mayo";
            }
            case 6 -> {
                return "Junio";
            }
            case 7 -> {
                return "Julio";
            }
            case 8 -> {
                return "Agosto";
            }
            case 9 -> {
                return "Septiembre";
            }
            case 10 -> {
                return "Octubre";
            }
            case 11 -> {
                return "Noviembre";
            }
            case 12 -> {
                return "Diciembre";
            }
        }
        return "";
        
    }
    
}
