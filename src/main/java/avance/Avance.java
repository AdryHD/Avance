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
        while (opcion != 6) {
            String textoMenuPrincipal = "1. Ingreso de Trámite \n" 
                + "2. Análisis de Trámites en Recepción \n"
                + "3. Análisis de Trámites en Documentos \n"
                + "4. Análisis de Trámites en Cajas \n"
                + "5. Menu Reportes \n"
                + "6. Salir \n";
            try 
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenuPrincipal));
                
                switch (opcion) {
                    case 1:
                        registroTramites();
                        break;
                    case 2:
                        tramitesRecepcion();
                        break;
                    case 3:
                        tramitesDocumentos();
                        break;
                    case 4:
                        break;
                    case 5:
                        int opcionReporte = 0;
                        while(opcionReporte != 5) {
                            String textoMenuReportes = "1. Reporte de Trámites Desertados \n"
                                    + "2. Reporte de Trámites por Fila \n"
                                    + "3. Reporte de Trámites Finalizados \n"
                                    + "4. Reporte de Pagos \n"
                                    + "5. Salir";
                            //Pedir opcion 
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
                        }
                    }
               catch (Exception ex) {
                    JOptionPane.showInternalMessageDialog(null, "No digitó un número");
                 }
            }
        }
       
        public static void registroTramites() {
            if (cantidadCliente < 10) {
                Cliente client = new Cliente();
                client.pedirDatos();
                cliente[cantidadCliente] = client;
                cantidadCliente++;
            }
            else {
                JOptionPane.showInternalMessageDialog(null, "Ya no hay espacion disponible en recepcion");
            }
        }
        
        public static void tramitesRecepcion() {
            String textoRecepcion = "";
            if (cantidadCliente > 0){
                //Solicitar el tipo de trámite.
            String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar:",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
                      
            boolean tramiteEncontrado = false;
            for (int i = 0; i < cantidadCliente; i++) {
                String tipoActual = cliente[i].getTipoTramite();
                System.out.println("Tipo actual del trámite en la posición " + i + ": " + tipoActual); // Mensaje de diagnóstico
                if (tipoActual.equals(tipoTramite)) {
                    tramiteEncontrado = true;
                    
                    // Obtener la fecha y hora actual
                    Date fechaHoraActual = new Date();
                    
                    // Actualizar la fecha y hora actual.
                    DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Trámite trasladado el " + formateador.format(fechaHoraActual));
                    
                    // Mover los trámites en "Recepción" a la fila.
                    for (int j = i; j < cantidadCliente - 1; j++) {
                        cliente[j] = cliente[j + 1];
                    }
                    cliente[cantidadCliente - 1] = null;
                    cantidadCliente--;
                    JOptionPane.showMessageDialog(null, "Trámite analizado exitosamente.");
                    break;
                }
            }
            if (!tramiteEncontrado) {
                JOptionPane.showMessageDialog(null, "No hay trámites en recepción para analizar del tipo seleccionado.");
            }
        } 
            else {
            JOptionPane.showMessageDialog(null, "No hay trámites en recepción para analizar.");
        }
    }
        public static void tramitesDocumentos() { 
            String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar:",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
            //FALTA CONTINUAR//
        }
}
        


