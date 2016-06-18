/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTapuntas;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author elena
 */
public class PlanAlquiler {
    private boolean visible;
    private GregorianCalendar primerDiaAlquiler;
    private GregorianCalendar ultimoDiaAlquiler;
    private double costeAlquilerAlDia;
    private String ciudadRecogida;
    private Vehiculo vehiculo;
    
    PlanAlquiler(Vehiculo unVehiculo, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, String ciudadRecogida){
       
    }
    
    ArrayList<String> obtenerdatosPA(){
        ArrayList<String> datosPA = new ArrayList<String>();
        datosPA.add(costeAlquilerAlDia+"");
        
        ArrayList<String> datosVehiculo = new ArrayList<String>();
        datosVehiculo = vehiculo.obtenerDatosVehiculo();
        for (int i=0; i<datosVehiculo.size(); i++){
            datosPA.add(datosVehiculo.get(i));
        }
        
        return datosPA;
    }
    
    void eliminarVehiculo (){
        
    }
    
    ArrayList<String> obtenerdatosPlanAlquiler(){
        return null;
    }
    
    void modificarVisibilidad (boolean visible){
        this.visible=visible;
    }
    
    String ciudadRecogida(){
        return ciudadRecogida;
    }
    
    GregorianCalendar primerDiaAlqquiler(){
        return primerDiaAlquiler;
    }
    
    GregorianCalendar ultimoDiaAlqquiler(){
        return ultimoDiaAlquiler;
    }
    
}
