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
      
      vehiculos = new ArrayList<>();
      planesAlquiler = new ArrayList<>();
      preferenciaCobro = new ArrayList<>();
      modificarVisibilidad(false);
    }
    
    void modificarVisibilidad(boolean visibilidad){
        this.visibilidad=visibilidad;
    }
    
    void nuevoVehiculo (String matricula, String marca, String modelo, String color, int numeroPlazas, String categoria, String confor){
        Vehiculo vehiculo = new Vehiculo (matricula,marca,modelo,color,numeroPlazas,categoria,confor);
        vehiculos.add(vehiculo);
    }
    
    ArrayList<String> obtenerPlanesQueCumplanRequisitos (String ciudadRecogida, GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
        ArrayList<String> datosPAUsuario = new ArrayList<>();
        datosPAUsuario.add(nombre);
        datosPAUsuario.add(preferenciaCobro.toString());
        ArrayList<String> datosPA = new ArrayList<>();
        
        PlanAlquiler pa;
        for (int i=0; i<planesAlquiler.size(); i++){
            pa = planesAlquiler.get(i);
            if (ciudadRecogida.equals(pa.ciudadRecogida()) && !(fechaInicio.before(pa.primerDiaAlqquiler())) && !(fechaFin.after(pa.ultimoDiaAlqquiler()))){
                datosPA = pa.obtenerdatosPA();
            }
        }
        
        for (int i=0; i<datosPA.size(); i++){
            datosPAUsuario.add(datosPA.get(i));
        }
        
        return datosPAUsuario;
    }
    
    void definirPlanAlquiler (String matricula, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, String ciudadRecogida) throws Exception{
        Vehiculo vehiculo = buscarVehiculo(matricula);
        
        if (vehiculo == null){
            throw new Exception("el vehículo no existe");
        }
        
        boolean disponible = vehiculo.estasDisponible(fechaInicio, fechaFin);
        
        if(!disponible )
            throw new Exception("el vehículo ya pertenece plan alquiler en esa fechas");
        
        PlanAlquiler miPlanAlquiler = new PlanAlquiler(vehiculo, fechaInicio, fechaFin, ciudadRecogida);
        vehiculo.incluirPlanAlquiler(miPlanAlquiler);
                        
        planesAlquiler.add(miPlanAlquiler);      
 
    }
    
    void eliminarVehiculo (String matricula) throws Exception{
        Vehiculo vehiculo = buscarVehiculo(matricula);
        boolean alquilado = vehiculo.comprobarEstadoAlquileres();
        
        if (!alquilado){
            vehiculo.eliminarVehiculoAlquileres();
        }else{
           throw new Exception("el vehículo no se puede eliminar, tiene vigentes alquileres o viajes"); 
        }
        
        vehiculos.remove(vehiculo);
        
    }
    
    void introducirPerfil (String nombre, String telefono, String breceDescripcion, ArrayList<TipoTransaccion> preferenciaCobro){
        this.nombre=nombre;
        this.telefono=telefono;
        this.breveDescripcionPersonal=breceDescripcion;
        this.preferenciaCobro=preferenciaCobro;
        modificarVisibilidad(true);
    }
    
    ArrayList<ArrayList<String>> obtenerPlanesAlquiler (){
        ArrayList<ArrayList<String>> datosPlanAlquiler = new ArrayList<>();
        PlanAlquiler pa;
        for (int i=0; i<planesAlquiler.size(); i++){
            pa = planesAlquiler.get(i);
            if (!pa.getVisibilidad() && pa.vigente()){
                datosPlanAlquiler.add(pa.obtenerdatosPlanAlquiler());
            }
        }
        
        return datosPlanAlquiler;
    }
    
    ArrayList<String> consultarPerfil(){
        ArrayList<String> infoPerfil = new ArrayList<>();
        infoPerfil.add(nombre);
        infoPerfil.add(telefono);
        infoPerfil.add(breveDescripcionPersonal);
        if (visibilidad)
            infoPerfil.add("Visible: sí");
        else
            infoPerfil.add("Visible: no");
        return infoPerfil;
    }
    
    void ofertarPlanAlquiler (GregorianCalendar fechaInicio, String matricula){
        PlanAlquiler pa = buscarPlanAlquiler(fechaInicio, matricula);
        pa.modificarVisibilidad(true);
    }
    
    Vehiculo buscarVehiculo (String matricula){
        Vehiculo vehiculo = null;
        boolean encontrado = false;
        for (int i=0; i<vehiculos.size() && !encontrado; i++){
            vehiculo = vehiculos.get(i);
            if (vehiculo.obtenerMatricula().equals(matricula))
                encontrado = true;
        }
        return vehiculo;
    }
    
    PlanAlquiler buscarPlanAlquiler (GregorianCalendar fechaInicio, String matricula){
        PlanAlquiler pa = null;
        boolean encontrado = false;
        for (int i=0; i<planesAlquiler.size() && !encontrado; i++){
            pa = planesAlquiler.get(i);
            if (fechaInicio.equals(pa.primerDiaAlqquiler()) && matricula.equals(pa.getMatricula())){
                encontrado = true;
            }
        }
        
        if (!encontrado)
            pa = null;
        return pa;
    }
    
    boolean getVisibilidad (){
        return visibilidad;
    }
}
