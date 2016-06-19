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
       this.vehiculo= vehiculo;
       primerDiaAlquiler = fechaInicio;
       ultimoDiaAlquiler = fechaFin;
       this.ciudadRecogida = ciudadRecogida;
       modificarVisibilidad(false);
    }
    
    ArrayList<String> obtenerdatosPA(){
        ArrayList<String> datosPA = new ArrayList<>();
        datosPA.add(costeAlquilerAlDia+"");
        
        ArrayList<String> datosVehiculo = new ArrayList<>();
        datosVehiculo = vehiculo.obtenerDatosVehiculo();
        for (int i=0; i<datosVehiculo.size(); i++){
            datosPA.add(datosVehiculo.get(i));
        }
        
        return datosPA;
    }
    
    void eliminarVehiculo (){
        vehiculo=null;
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
    
    boolean getVisibilidad(){
        return visible;
    }
    
    boolean vigente(){
        boolean vigente= false;
        
        GregorianCalendar hoy = new GregorianCalendar();
        if (hoy.before(ultimoDiaAlquiler)){
            vigente = true;
        }
        
        return vigente;
    }
    
}
