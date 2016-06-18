/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTapuntas;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author aanaya
 */
public class Tapuntas {
    private Map<String,Usuario> usuarios = new HashMap();

    // Este método mo está bien, está hecho para probar, tenéis que implementar el singleton
    public static Tapuntas getInstance() {
        return new Tapuntas();        
    }

    public void altaRegistro(String nombreUsuario, String contraseña, String direccionCorreo) throws Exception {
        if(usuarios.containsKey(nombreUsuario)) throw new Exception("ya existe un usuario con ese nombre de usuario");
        usuarios.put(nombreUsuario, new Usuario(nombreUsuario,contraseña,direccionCorreo));
    }
    
    public void añadirVehiculo(String nombreUsuario,String matricula, String marca, String modelo, String color, int numeroPlazas, String categoria, String confor) throws Exception{
        Vehiculo vehiculo = null;
        Iterator it = usuarios.entrySet().iterator();
        while (it.hasNext() && vehiculo == null) {
            Map.Entry<String, Usuario> pair = (Map.Entry<String, Usuario>) it.next();
            vehiculo = pair.getValue().buscarVehiculo(matricula);
        }
        if(vehiculo == null) throw new Exception("ya existe otro vehículo en el sistema con esa matrícula");
        Usuario usuario = buscarUsuario(nombreUsuario);
        usuario.nuevoVehiculo(matricula,marca,modelo,color,numeroPlazas,categoria,confor);
    }
    
    public ArrayList<PlanAlquiler> buscarOfertasAlquiler (String ciudadRecogida, GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
       return null; 
    }
    
    public void definirPlanAlquiler(String nombreUsuario, GregorianCalendar fechaInicio, GregorianCalendar FechaFin, String ciudadRecogida){
        
    }
    
    public void eliminarVehiculoPropietario(String nombreUsuario, String matricula){
        
    }
    
    public void introducirPerfil(String nombreUsuario , String nombre, String telefono, String breveDescripcion){
        
    }
    
    public ArrayList<PlanAlquiler> obtenerPlanesAlquiler (String nombreUsuario){
      return null;  
    }
    
    public ArrayList<String> consultarPerfil (String nombreUsuario){
        return null;
    }
    
    public void ofertarPlanAlquiler(String nombreUsuario, GregorianCalendar fechaInicio, String matricula){
        
    }
    
    private boolean existeUsuario (String nombreUsuario){
        return false;
    }
    
    private Usuario buscarUsuario (String nombreUsuario){
       return null; 
    }
    
    private void ordenarOfertas (ArrayList<String> listaOfertas){
        
    }
    
    private boolean existeVehiculo (String matricula){
        return false;
    }
    
}
