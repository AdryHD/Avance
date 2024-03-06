
package avance;

import javax.swing.JOptionPane;

public class Avance {

    public static void main(String[] args) { 
     JOptionPane.showMessageDialog(null, "Bienvenido a la Agencia Aduanal"); 
     menu ();
}

    public static void menu() {
        
      int opcionMenu = 0;
      

        //ciclo para mostrar menu
        
        while (opcionMenu != 6) {

            //mostrar menu
            String textoMenu = "Menu Principal: \n Elja la opción deseada \n"
                    + "1. Ingreso de trámite \n"
                    + "2. Análisis de trámites en “Recepción” \n"
                    + "3. Análisis de trámites en “Documentos” \n"
                    + "4. Análisis de trámites en “Cajas”  \n"
                    + "5. Reportes  \n"
                    + "6. Salir";

                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

// evaluar opcion
            switch (opcionMenu) {
                case 1:{ingreso();
                menu (); 
                    break;}
                case 2:{recepcion();
                menu (); 
                    break;}
                case 3:{documentos();
                menu (); 
                    break;}
                    
                case 4:{cajas();
                menu (); 
                    break;}
                    case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
    // Datos de ingreso de trámites
    public static void ingreso() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre completo:");
        String cedula = JOptionPane.showInputDialog("Ingrese su número de cédula:");
        String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que deseea realizar:",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, //con ayuda de https://recursosformacion.com/2018/05/java-programadores-9-7-cuadros-dialogo/
                    new String[]{"Registro exportador", "Exoneración impuestos", "Activación de Registro de Importador",
                            "Permisos especiales productos"}, "Registro exportador");
    }

    public static void recepcion() {
        // Solicitar tipo de cliente
        boolean tipoCliente = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION; //con ayuda de https://recursosformacion.com/2018/05/java-programadores-9-7-cuadros-dialogo/
    }

    public static void documentos() {
         // Tipo de cliente
        String tipoCliente = (String) JOptionPane.showInputDialog(null, "¿Qué tipo de cliente desea analizar?",
                "Tipo de Cliente", JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Preferencial", "Normal"}, "Preferencial");
        
        // Atender primer trámite en la fila de Documentos
        String[]tramitesDocumentos = {"Registro exportador", "Exoneración impuestos", "Activación de Registro de Importador",
                            "Permisos especiales productos"};
        String primerTramite = tramitesDocumentos[0];
        JOptionPane.showMessageDialog(null, "Atendiendo trámite: " + primerTramite);
        
        // Decisión sobre los documentos
        String decision = JOptionPane.showInputDialog(null, "¿Desea aceptar o rechazar los documentos?");
        int aceptar;
        if ("aceptar" == decision || "Aceptar" == decision){
            aceptar = 1;
        } else {
            aceptar = 0;
        }

         // Mover trámite a la fila de Cajas si se acepta
        if (aceptar == 1) {
            JOptionPane.showMessageDialog(null, "Los documentos han sido aceptados, trámite movido a la fila de cajas");
        } else {
            JOptionPane.showMessageDialog(null, "Los documentos han sido rechazados, trámite en espera de corrección");
        }
        //Asignación de montos
        String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea realizar:",
        "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null,
        new String[]{"Registro exportador", "Exoneración impuestos", "Activación de Registro de Importador", "Permisos especiales productos"},
        "Registro exportador");
        int monto = 0;
        switch (tipoTramite){
            case "Registro exportador":
                monto = 100;
                break; 
            case "Exoneración impuestos":
                monto = 10;
                break;
            case "Activación de registro":
                monto = 50;
                break;
            case "Permisos especiales":
                monto = 25;
                break;
        }
        JOptionPane.showMessageDialog(null, "Su trámite ha sido aceptado. Se ha trasladado a la fila de cajas. \nMonto del trámite: $"
                + monto);
    }

      // Método para simular el análisis de trámites en Cajas
    public static void cajas() {
         // Tipo de cliente
        String tipoCliente = (String) JOptionPane.showInputDialog(null, "¿Qué tipo de cliente desea analizar?",
                "Tipo de Cliente", JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Preferencial", "Normal"}, "Preferencial");
        //Pago
        boolean opcionPago = JOptionPane.showConfirmDialog(null, "¿El cliente va a pagar el trámite?", 
                "Cliente Preferencial", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION; //con ayuda de https://recursosformacion.com/2018/05/java-programadores-9-7-cuadros-dialogo/

 }
    // Módulo de reportes
    public static void reportes() {
        JOptionPane.showMessageDialog(null, "Falta.");
    }

    // Método para mostrar el submenú de reportes
    public static void subMenuReportes() {
        // ciclo para mostrar submenú
        while (true) {
                    String textosubMenu = "1. Reporte de trámites desertados \n"
                            + "2. Reporte de trámites por fila  \n"
                            + "3. Reporte de trámites finalizados  \n"
                            + "4. Reporte de pagos  \n"
                            + "5. Menu principal  \n";
        // evaluar opción del submenú
            switch (opcionSubMenu) {
                  case 1:
                    JOptionPane.showMessageDialog(null, "Falta");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Falta");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Falta");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Falta");
                    break;
                case 5:
                    return; // Salir del submenú
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
}
    
    /*STATIC VOID MENU PRINCIPAL
    public static void ingreso() {
     String nombre = JOptionPane.showInputDialog("Digite A:");
    }
  
    public static void recepcion() {
        String nombre = JOptionPane.showInputDialog("Digite B:");
    }
    
   public static void documentos() {
        String nombre = JOptionPane.showInputDialog("Digite C:");
    } 
   
   public static void cajas() {
        String nombre = JOptionPane.showInputDialog("Digite D:");
    }
   
   public static void reportes() {
        String nombre = JOptionPane.showInputDialog("Digite la opcion del Sub Menu:");
    }

    private static void subMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    //STATIC VOID SUBMENU 
  
   public static void desertados() {
        String nombre = JOptionPane.showInputDialog("Digite W:");
    }
    
   public static void porFila() {
        String nombre = JOptionPane.showInputDialog("Digite Z:");
    } 
   
   public static void finalizados() {
        String nombre = JOptionPane.showInputDialog("Digite Y:");
    }
   
   public static void pagos() {
        String nombre = JOptionPane.showInputDialog("Digite Z:");
    }  
}*/ 
