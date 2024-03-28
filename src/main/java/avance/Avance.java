package avance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Avance {

    
    static int cantidadCliente = 3;

    public static void main(String[] args) {
        menu();
    }
    
    
      public static void menu() {
      Cliente[] listaClientes = new Cliente[10];

      Tramite tramite = new Tramite();
      Cliente cliente = new Cliente();
      int opcionMenu = 0;
      
     
        //ciclo para mostrar menu
        
        while (opcionMenu != 6) {

            //mostrar menu
            String textoMenu = "*** Menú Principal *** \n Elija la opción deseada: \n"
                    + "1. Ingreso del Cliente  \n"
                    + "2. Ingreso de trámite \n"
                    + "3. Análisis de trámites en “Recepción” \n"
                    + "4. Análisis de trámites en “Documentos” \n"
                    + "5. Análisis de trámites en “Cajas”  \n"
                    + "6. Reportes  \n"
                    + "7. Salir";

                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

// evaluar opcion
            switch (opcionMenu) {
                case 1:{
                    crearCliente(listaClientes, cliente);
                    menu ();
                    break;}
           
                case 2:{
                    obtenerDatos(cliente,tramite);
                    menu (); 
                    break;}
                case 3:recepcion();
                menu (); 
                    break;
                case 4:{documentos();
                menu (); 
                    break;}
                case 5:{cajas();
                menu (); 
                    break;}
                case 6: subMenuReportes();
                break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
      }
    public static void registroTramite() {
        if (cantidadCliente < 10) {
            Cliente rece = new Cliente();
            rece.pedirDatos();
            cliente[cantidadCliente] = rece;
            cantidadCliente++;
        }
        else { 
            JOptionPane.showInternalConfirmDialog(null, "Ya no hay espacion disponible en recepción");
        }
    }
    public static void recepcion() {
        String textoCliente = "";
        if (cantidadCliente > 0) {
            
            //solicitar el tipo de trámite.
            String tipoCliente = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar: ",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
            boolean tramiteEncontrado = false;
            for (int i = 0; i < cantidadCliente; i++) {
                if (cliente[i] != null) {
                String tipoActual = cliente[i].getTipoTramite();
                System.out.println("Tipo actual del trámite en la posición " + i + ": " + tipoActual); 
                if (tipoActual.equals(tipoCliente)) {
                    tramiteEncontrado = true;
                }   

                    //Mostrar el trámite encontrado.
                    JOptionPane.showMessageDialog(null, "Trámite encontrado: \n" + cliente[i].toString());
                    
                    //Obtener la fecha y la hora actual.
                    Date fechaHora = new Date();
                    
                    //Actualizar la fecha y la hora actual.
                    DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy, hh:mm:ss");
                    System.out.println("Trámite trasladado el " + formateador.format(fechaHora));
                    
                    //Mover los trámites que están en recepción a la fila.
                    for (int j = i; j < cantidadCliente -1; j++) {
                        cliente[j] = cliente[j + 1];
                    }
                    cliente[cantidadCliente - 1] = null;
                    cantidadCliente--;
                    JOptionPane.showMessageDialog(null, "Trámite analizado existosamente.");
                    break;
                }
            }
            if (!tramiteEncontrado) {
                JOptionPane.showMessageDialog(null, "No hay trámites en recepción para ser analizados del tipo seleccionado");
            }
            else { 
                JOptionPane.showMessageDialog(null, "No hay trámites en recepción para analizar.");
            }
        }         
    }
    
    public static void documentos() { 
            if (cantidadCliente > 0) {
            String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar:",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
            boolean tramiteEncontrado = false;
            int i = 0;
            for (; i < cantidadCliente; i++) {
                String tipoActual = cliente[i].getTipoTramite();
                if (tipoActual.equals(tipoTramite)) {
                    tramiteEncontrado = true;

                    //Obtener la fecha y hora actual.
                    Date fechaHoraActual = new Date();

                    //Actualizar la fecha y hora actual.
                    DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy, hh:mm:ss a\"");
                    System.out.println("Trámite trasladado el " + formateador.format(fechaHoraActual));

                    // Mover el trámite a la fila de cajas.
                    Cliente tramite = cliente[i];
                    for (int j = i; j < cantidadCliente - 1; j++) {
                        cliente[j] = cliente[j + 1];
                    }
                    cliente[cantidadCliente - 1] = null;
                    cantidadCliente--;

                    // Monto de cada trámite diferente.
                   
                    double montoTramite = 0;
                    switch (tipoTramite) {
                        case "Registro Exportador":
                            montoTramite = 100;
                            break;
                        case "Exoneracion de Impuestos":
                            montoTramite = 10;
                            break;
                        case "Activacion de Registro":
                            montoTramite = 50;
                            break;
                        case "Permisos especiales productos":
                            montoTramite = 25;
                            break;
                    }

                    // Se acepta o se rechazan los documentos.
                    int decision = JOptionPane.showOptionDialog(null, "Desea aceptar o rechazar los documentos?", "Aceptar o Rechazar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Aceptar", "Rechazar"}, "Aceptar");
                    if (decision == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Trámite aceptado. El monto del trámite es de: $" + montoTramite);
                    } else {
                        JOptionPane.showMessageDialog(null, "Trámite rechazado. Se moverá a la última posición de la fila para la corrección");
                        cliente[cantidadCliente] = tramite;
                        cantidadCliente++;
                    }
                    break; // Salir del bucle una vez encontrado el trámite
                }
            }
            if (!tramiteEncontrado) {
                JOptionPane.showMessageDialog(null, "No hay trámites en documentos para analizar del tipo seleccionado");
            }
        } 
            else {
            JOptionPane.showMessageDialog(null, "No hay trámites en documentos para analizar");
            }
        }
    
    public static void crearCliente(Cliente[] listaClientes, Cliente cliente){
    boolean continuar = true;
    while (continuar){
        
    cliente.setNombre(JOptionPane.showInputDialog("Digite el nombre:"));
    cliente.setIdentificacion(JOptionPane.showInputDialog("Digite el numero de cedula:"));
    int respuesta = JOptionPane.showConfirmDialog(null, "El cliente es Preferencial?","preferencial",YES_NO_OPTION);
    //cliente.setPreferencial(Boolean.parseBoolean(JOptionPane.showInputDialog("El Cliente es preferencial (true/false)")));
    //JOptionPane.showConfirmDialog(parentComponent, cliente, title, YES_NO_OPTION)
    if(respuesta == JOptionPane.YES_OPTION){
        cliente.setPreferencial(true);
    }else {cliente.setPreferencial(false);}
    listaClientes.add(cliente);

    int continua = JOptionPane.showConfirmDialog(null, "Desea agregar otro cliente?","Continuar",YES_NO_OPTION);
      if(continua == JOptionPane.YES_OPTION){
       continuar = true;
    }else {continuar=false;}
    }
    
//    public static void tramitesCajas() {
//         //Solicitar el tipo de trámite.
//            String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar:",
//                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
//             //Pago
//        boolean opcionPago = JOptionPane.showConfirmDialog(null, "¿El cliente va a pagar el trámite?", 
//                "Cliente Preferencial", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
//        // Buscar el primer trámite en la fila del tipo seleccionado
//        boolean tramiteEncontrado = false;
//        for (int i = 0; i < cantidadCliente; i++) {
//            if (cliente[i].getTipoTramite().equals(tipoTramite)) {
//                tramiteEncontrado = true;
//
//                // Verificar si el cliente paga o no el trámite
//                int decisionPago = JOptionPane.showOptionDialog(null, "¿El cliente paga el trámite?",
//                        "Pago del Trámite", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
//                        new String[]{"Sí", "No"}, "Sí");
//
//                if (decisionPago == JOptionPane.NO_OPTION) {
//                    // Retirar al cliente de la agencia y almacenar el registro para trámites desertados
//                    JOptionPane.showMessageDialog(null, "Cliente retirado de la agencia. Trámite desertado.");
//                } else {
//                    // Crear un registro de pago
//                    double montoPagado = montoTramite(cliente[i].getTipoTramite());
//                    Date fechaPago = new Date();
//                    RegistroPago registroPago = new RegistroPago(cliente[i].getTipoTramite(), montoPagado, fechaPago);
//                      // Mostrar información del pago
//                    JOptionPane.showMessageDialog(null, "Trámite pagado exitosamente. Monto: $" + montoPagado + "\nFecha del Pago: " + fechaPago);
//
//                    // Retirar al cliente de la agencia
//                    cliente[i] = null;
//                    cantidadCliente--;
//                }
//                break;
//            }
//        }
//        if (!tramiteEncontrado) {
//            JOptionPane.showMessageDialog(null, "No hay trámites en cajas para analizar del tipo de cliente seleccionado.");
//        }
//    }
//
//    private static double montoTramite(String tipoTramite) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//else {
//        JOptionPane.showMessageDialog(null, "No hay trámites en cajas para analizar.");
//    }
//}



        }
    
  
        
        //Reportes
            
        
    



