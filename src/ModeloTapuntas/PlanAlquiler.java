/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTapuntas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    
    //Contructor
    PlanAlquiler(Vehiculo unVehiculo, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, String ciudadRecogida){
       this.vehiculo= vehiculo;
       primerDiaAlquiler = fechaInicio;
       ultimoDiaAlquiler = fechaFin;
       this.ciudadRecogida = ciudadRecogida;
       modificarVisibilidad(false);
    }
    
    //Obtiene los datos del plan de alquiler
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
    
    //Elimina el vehiculo
    void eliminarVehiculo (){
        vehiculo=null;
    }
    
    //Obtiene los datos del plan de alquiler
    ArrayList<String> obtenerdatosPlanAlquiler(){
        ArrayList<String> datosPlanAlquiler = new ArrayList<>();
        datosPlanAlquiler.add(vehiculo.obtenerMatricula());
        
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); //Da formato al día
        String fechaString = formatoFecha.format(primerDiaAlquiler.getTime());
        datosPlanAlquiler.add(fechaString);
        
        fechaString = formatoFecha.format(ultimoDiaAlquiler.getTime());
        datosPlanAlquiler.add(fechaString);
        
        datosPlanAlquiler.add(costeAlquilerAlDia+"");
        datosPlanAlquiler.add(ciudadRecogida);
        
        return datosPlanAlquiler;
    }
    
    //Modifica la visibilidad
    void modificarVisibilidad (boolean visible){
        this.visible=visible;
    }
    
    //Devuelve la ciudad de recogida
    String ciudadRecogida(){
        return ciudadRecogida;
    }
    
    //Devuelve el primer dia de alquiler
    GregorianCalendar primerDiaAlqquiler(){
        return primerDiaAlquiler;
    }
    
    //Devuelve el ultimo dia de alquiler
    GregorianCalendar ultimoDiaAlqquiler(){
        return ultimoDiaAlquiler;
    }
    
    //Devuelve la visibilidad del plan de alquiler
    boolean getVisibilidad(){
        return visible;
    }
    
    //Devuelve si el plan de alquiler está vigente
    boolean vigente(){
        boolean vigente= false;
        
        GregorianCalendar hoy = new GregorianCalendar();
        if (hoy.before(ultimoDiaAlquiler)){
            vigente = true;
        }
        
        return vigente;
    }
    
    //Devuelve la matricula del vehiculo
    String getMatricula(){
        return vehiculo.obtenerMatricula();
    }
}
