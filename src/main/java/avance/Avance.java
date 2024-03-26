package avance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Avance {

    static Cliente[] cliente = new Cliente[10];
    static int cantidadCliente = 3;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido a la Agencia Aduanal");

        int opcion = 0;
        
        while (opcion != 6){ 
            String textoMenuPrincipal = "1. Ingreso de Trámite \n"
                    + "2. Análisis de Trámites en Recepción \n"
                    + "3. Análisis de Trámites en Documentos \n"
                    + "4. Análisis de Trámites en Cajas \n"
                    + "5. Menú de Reportes \n"
                    + "6. Salir \n";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenuPrincipal));
            
            switch (opcion) { 
                case 1:
                    registroTramite();
                    break;
                case 2:
                    tramiteRecepcion();
                    break;
                case 3:
                    tramitesDocumentos();
                    break;
                case 4:
                    break;
                case 5:
                    int opcionReporte = 0;
                    while (opcionReporte !=5) {
                        String textoMenuReportes = "1. Reporte de Trámites Desertados \n"
                                + "2. Reporte de Trámites por Fila \n"
                                + "3. Reporte de Trámites Finalizados \n"
                                + "4. Reporte de Pagos \n"
                                + "5. Salir \n";
                        opcionReporte = Integer.parseInt(JOptionPane.showInputDialog(textoMenuReportes));
                        switch (opcionReporte) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválidad");
                    break;
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
    public static void tramiteRecepcion() {
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
    
    public static void tramitesDocumentos() { 
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
            
        
    



