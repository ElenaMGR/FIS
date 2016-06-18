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
 * @author aanaya
 */
class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String direccionCorreo;
    private boolean visibilidad = false;
    private boolean pendienteBaja = false;
    // incluir los demás atributos
    private String nombre;
    private String telefono;
    private String breveDescripcionPersonal;
    private ArrayList<TipoTransaccion> preferenciaCobro;
    private ArrayList<PlanAlquiler> planesAlquiler;
    private ArrayList<Vehiculo> vehiculos;

    Usuario(String nombreUsuario, String contraseña, String direccionCorreo) {
      this.nombreUsuario= nombreUsuario;
      this.contraseña = contraseña;
      this.direccionCorreo = direccionCorreo;
      
      modificarVisibilidad(false);
    }
    
    void modificarVisibilidad(boolean visibilidad){
        this.visibilidad=visibilidad;
    }
    
    void nuevoVehiculo (String matricula, String marca, String modelo, String color, int numeroPlazas, String categoria, String confor){
        
    }
    
    ArrayList<PlanAlquiler> obtenerPlanesQueCumplanRequisitos (String ciudadRecogida, GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
        return null;
    }
    
    void definirPlanAlquiler (String matricula, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, String ciudadRecogida){
        
    }
    
    void eliminarVehiculo (String matricula){
        
    }
    
    void introducirPerfil (String nombre, String telefono, String breceDescripcion, ArrayList<TipoTransaccion> preferenciaCobro){
        
    }
    
    ArrayList<PlanAlquiler> obtenerPlanesAlquiler (){
        return null;
    }
    
    ArrayList<String> consultarPerfil(){
        return null;
    }
    
    void ofertarPlanAlquiler (GregorianCalendar fechaInicio, String matricula){
        
    }
    
    Vehiculo buscarVehiculo (String matricula){
        return null;
    }
    
    PlanAlquiler buscarPlanAlquiler (GregorianCalendar fechaInicio, String matricula){
        return null;
    }
}
