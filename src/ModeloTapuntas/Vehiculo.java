/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTapuntas;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import sun.util.calendar.Gregorian;

/**
 *
 * @author elena
 */
class Vehiculo {
    private String marca;
    private String modelo;
    private String confor;
    private int numeroPlazas;
    private String color;
    private String categoria;
    private String matricula;
    private ArrayList<PlanAlquiler> planesAlquiler;
    
    Vehiculo(String matricula, String marca, String modelo, String color, int numeroPlazas, String categoria, String confor){
        this.matricula=matricula;
        this.marca=marca;
        this.modelo=modelo;
        this.confor=confor;
        this.categoria=categoria;
        this.color=color;
        this.numeroPlazas=numeroPlazas;
        
        planesAlquiler= new ArrayList<PlanAlquiler>();
    }
    
    ArrayList<String> obtenerDatosVehiculo(){
        ArrayList<String> datosVehiculo = new ArrayList<>();
        datosVehiculo.add(marca);
        datosVehiculo.add(modelo);
        datosVehiculo.add(confor);
        datosVehiculo.add(numeroPlazas+"");
        datosVehiculo.add(color);
        datosVehiculo.add(categoria);
        datosVehiculo.add(matricula);
        
        return datosVehiculo;
    }
        
    boolean estasDisponible (GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
        boolean disponible = true;
        PlanAlquiler pa;
        for (int i=0; i<planesAlquiler.size() && disponible; i++){
            pa = planesAlquiler.get(i);
            GregorianCalendar primerDia = pa.primerDiaAlqquiler();
            GregorianCalendar ultimoDia = pa.ultimoDiaAlqquiler();
            
            //Compruebo si coinciden las fechas
            if ((fechaInicio.after(primerDia) && fechaInicio.before(ultimoDia)) ||
                    fechaFin.after(primerDia) && fechaFin.before(ultimoDia))             
               disponible = false;
           
        }
        
        return disponible;
    }
    
    void incluirPlanAlquiler(PlanAlquiler pa){
        planesAlquiler.add(pa);
    }
    
    boolean comprobarEstadoAlquileres(){
        boolean alquilado = false;
        //Compruebo si coinciden las fechas
        PlanAlquiler pa;
        for (int i=0; i<planesAlquiler.size() && !alquilado; i++){
            pa = planesAlquiler.get(i);
            GregorianCalendar primerDia = pa.primerDiaAlqquiler();
            GregorianCalendar ultimoDia = pa.ultimoDiaAlqquiler();
            GregorianCalendar hoy = new GregorianCalendar();
            if (hoy.after(primerDia) && hoy.before(ultimoDia) ||
                    hoy.after(primerDia) && hoy.before(ultimoDia))            
               alquilado = true;
        }
        
        return alquilado;
    }
    
    void eliminarVehiculoAlquileres(){
        
    }
    
    String obtenerMatricula(){
        return matricula;
    }
}
