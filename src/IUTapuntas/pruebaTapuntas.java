/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IUTapuntas;

import ModeloTapuntas.Tapuntas;
import ModeloTapuntas.TipoTransaccion;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author aanaya
 */
public class pruebaTapuntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables usuario
        String nombreUsuario, claveUsuario, correoUsuario, nombre, telefono, breveDescripcion;
        int preferencia;
        ArrayList<TipoTransaccion> preferenciasCobro;
        //Variables vehiculo
        String matricula, marca, modelo, color, categoria, confor;
        int numeroPlazas;
        //Variables plan alquiler
        String ciudadRecogida;
        int dia, mes, año;
        GregorianCalendar fechaInicio, fechaFin;
        
     
        // Obtener la única instancia de la clase BuenProvecho (patrón sigleton)
        Tapuntas aViajar = Tapuntas.getInstance(); 
        
        // Definir la variable que nos permite leer String desde teclado
        final Scanner in = new Scanner(System.in);
        int opcion = 0; 
        do{
            try{ // tratamiento de las excepciones. Bloque try en el que se puede producir una excepción y la capturamos
		 
                 //Terminar de diseñar el menú (usando System.out.println(...)) con las opciones que faltan
		 // Podéis hacer vuestros propios diseños de interfaz, esta es la interfaz mínima que tenéis que entregar
                System.out.println("\n\n*********************************** MENU ***********************************\n" +
                                       "GESTIÓN DE USUARIOS   \n" +
                                     "\t10. Nuevo Usuario \n" +
                                     "\t11. Consultar usuarios del sistema \n" +
                                     "\t12. Incluir Perfil de Usuario \n" +
                                     "\t13. Consultar Perfil de un Usuario \n");	
                                 
                System.out.println("GESTIÓN DE VEHICULOS  \n" +                             
                                    "\t20. Nuevo vehículo \n" +
                                    "\t21. Consultar vehículos de un usuario \n" +
                                    "\t22. Eliminar vehículo\n");
                
                System.out.println("GESTIÓN DE PLANES DE ALQUILER  \n" +
                                    "\t30. Definir nuevo plan de alquiler \n" +
                                    "\t31. Consultar mis planes de alquiler\n" +
                                    "\t32. Ofertar un plan de alquiler \n" +
                                    "\t33. Buscar ofertas de planes de alquiler \n");
                
                System.out.println("\n**********************************************************************");
                		         
                System.out.println("\t0. TERMINAR");
		System.out.println("\n**********************************************************************");
                 
                // Lectura de un int, para darle valor a opcion.
                opcion =Integer.parseInt(in.nextLine()); 
                
                // Estructura switch con todas las opciones de menú. Algunos de ellos ya lo tenéis hecho
                // Tenéis que terminar las opciones que están incompletas y las que no están hechas
                switch(opcion){
                    case 10: //incluir un nuevo usuario en el sistema 
                                            
                        System.out.print("Nombre de Usuario:");
                        nombreUsuario =in.nextLine();
                                       
                        System.out.print("Clave:");
                        claveUsuario= in.nextLine();
                        
                        System.out.print("Dirección de correo:");
                        correoUsuario= in.nextLine();
                        
                        aViajar.altaRegistro(nombreUsuario, claveUsuario, correoUsuario);                                             
                        System.out.print("++++++  Operación realizada con éxito ++++++");
                    break;  
                    
                    case 11:/*Ver usuarios del sistema */
                                                                     
                    break;
                    
                    case 12:/*Incluir Perfil */
                        preferenciasCobro = new ArrayList<>();
                        System.out.print("Nombre de Usuario:");
                        nombreUsuario =in.nextLine();
                                       
                        System.out.print("Nombre:");
                        nombre= in.nextLine();
                        
                        System.out.print("Teléfono:");
                        telefono= in.nextLine();
                        
                        System.out.print("Breve descripción:");
                        breveDescripcion= in.nextLine();
                        
                        System.out.println("Preferencias de Cobro:");
                        System.out.println("Indique de mayor a menor preferencia de uno en uno:");
                        System.out.println("1 - TARJETA");
                        System.out.println("2 - PAYPAL");
                        System.out.println("3 - EFECTIVO");
                        System.out.println("4 - TRANSFERENCIA");   
                        System.out.print("Introduce número (1-4):");
                        preferencia = Integer.parseInt(in.nextLine());
                        switch (preferencia) {
                            case 1:
                                preferenciasCobro.add(TipoTransaccion.TARJETA);
                                break;
                            case 2:
                                preferenciasCobro.add(TipoTransaccion.PAYPAL);
                                break;
                            case 3:
                                preferenciasCobro.add(TipoTransaccion.EFECTIVO);
                                break;
                            default:
                                preferenciasCobro.add(TipoTransaccion.TRANSFERENCIA);
                                break;
                        }
                        System.out.print("Introduce número (1-4):");
                        preferencia = Integer.parseInt(in.nextLine());
                        switch (preferencia) {
                            case 1:
                                preferenciasCobro.add(TipoTransaccion.TARJETA);
                                break;
                            case 2:
                                preferenciasCobro.add(TipoTransaccion.PAYPAL);
                                break;
                            case 3:
                                preferenciasCobro.add(TipoTransaccion.EFECTIVO);
                                break;
                            default:
                                preferenciasCobro.add(TipoTransaccion.TRANSFERENCIA);
                                break;
                        }
                        System.out.print("Introduce número (1-4):");
                        preferencia = Integer.parseInt(in.nextLine());
                        switch (preferencia) {
                            case 1:
                                preferenciasCobro.add(TipoTransaccion.TARJETA);
                                break;
                            case 2:
                                preferenciasCobro.add(TipoTransaccion.PAYPAL);
                                break;
                            case 3:
                                preferenciasCobro.add(TipoTransaccion.EFECTIVO);
                                break;
                            default:
                                preferenciasCobro.add(TipoTransaccion.TRANSFERENCIA);
                                break;
                        }
                        System.out.print("Introduce número (1-4):");
                        preferencia = Integer.parseInt(in.nextLine());
                        switch (preferencia) {
                            case 1:
                                preferenciasCobro.add(TipoTransaccion.TARJETA);
                                break;
                            case 2:
                                preferenciasCobro.add(TipoTransaccion.PAYPAL);
                                break;
                            case 3:
                                preferenciasCobro.add(TipoTransaccion.EFECTIVO);
                                break;
                            default:
                                preferenciasCobro.add(TipoTransaccion.TRANSFERENCIA);
                                break;
                        }
                        
                        aViajar.introducirPerfil(nombreUsuario, nombre, telefono, breveDescripcion, preferenciasCobro);                                             
                        System.out.print("++++++  Operación realizada con éxito ++++++");
                                                                
                    break;
                    case 13:/*Consultar perfil */
                                                                   
                    break;
                
                    case 20: /*Nuevo vehículo */ 
                        //String nombreUsuario,String matricula, String marca, 
                        //String modelo, String color, int numeroPlazas, String categoria, 
                        //String confor

                        System.out.print("Nombre de Usuario:");
                        nombreUsuario =in.nextLine();
                                       
                        System.out.print("Matricula:");
                        matricula= in.nextLine();
                        
                        System.out.print("Marca:");
                        marca = in.nextLine();
                        
                        System.out.print("Modelo:");
                        modelo = in.nextLine();
                        
                        System.out.print("Color:");
                        color = in.nextLine();
                        
                        System.out.print("Numero de Plazas:");
                        numeroPlazas = Integer.valueOf(in.nextLine());
                        
                        System.out.print("Categoría:");
                        categoria = in.nextLine();
                        
                        System.out.print("Confor:");
                        confor = in.nextLine();
                        
                        aViajar.añadirVehiculo(nombreUsuario, matricula, marca, modelo, color, numeroPlazas, categoria, confor);                                             
                        System.out.print("++++++  Operación realizada con éxito ++++++");
                                                     
                    break;
                  
                    case 21: /* Consultar vehículos de un usuario  */
                                                   
                    break;             
                  
                    case 22: /* Eliminar vehículo  */
                                                    
                    break;
  
    
                    case 30: /* Nuevo plan de alquiler */
                                        
                    break;

                    case 31: /* Consultar planes de alquiler de un usuario */
                                                
                    break;

                    case 32: /* Ofertar un plan de alquiler */
                                  
                    break;

                    case 33: /* Buscar ofertas de planes de alquiler  */
                        ArrayList<ArrayList<String>> ofertasAlquiler = new ArrayList<ArrayList<String>>();
                        ArrayList<String> pa = new ArrayList<String>();
                        System.out.print("Ciudad de Recogida:");
                        ciudadRecogida = in.nextLine();
                        
                        System.out.print("Fecha de Inicio:");                        
                        System.out.println("dia : ");
                        dia= Integer.parseInt(in.nextLine());
                        System.out.print("mes : ");
                        mes=Integer.parseInt(in.nextLine());
                        System.out.print("año : ");
                        año = Integer.parseInt(in.nextLine());
                        fechaInicio = new GregorianCalendar(año,mes-1,dia);
                        
                        System.out.print("Fecha Fin:");                       
                        System.out.println("dia : ");
                        dia= Integer.parseInt(in.nextLine());
                        System.out.print("mes : ");
                        mes=Integer.parseInt(in.nextLine());
                        System.out.print("año : ");
                        año = Integer.parseInt(in.nextLine());
                        fechaFin = new GregorianCalendar(año,mes-1,dia);
                        
                        ofertasAlquiler = aViajar.buscarOfertasAlquiler(ciudadRecogida, fechaInicio, fechaFin);
                        System.out.print("++++++  Operación realizada con éxito ++++++");
                        for (int i=0; i<ofertasAlquiler.size() ; i++){
                            pa = ofertasAlquiler.get(i);
                            for (int j=0; j<pa.size(); j++){
                                System.out.println(pa.toString());
                            }
                        }

                    break;                 

                    case 0: /* terminar */
                    break;                        
                                    
                    default:
                        System.out.println("opcion no válida");
                    break;
                }
//               
            }catch(Exception ex){ // captura de la excepción
                System.err.println("se ha producido la siguiente excepcion: "+ ex);
            } 
        }while(opcion !=0); 
        System.exit(0);
    }  

}

    
    

