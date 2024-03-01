
package avance;

import javax.swing.JOptionPane;

public class Avance {

    public static void main(String[] args) { 
     JOptionPane.showMessageDialog(null, "Bienvenido a la Agencia Aduanal");
     String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
     String cedula = JOptionPane.showInputDialog("Ingrese su número de cédula:");   
        
menu ();
}

    public static void menu() {
     JOptionPane.showMessageDialog(null, "Elija la opción deseada: ");  
        
      int opcionMenu = 0;
      

        //ciclo para mostrar menu
        
        while (opcionMenu != 6) {

            //mostrar menu
            String textoMenu = "Menu Principal: \n"
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
                    
                case 5:{reportes();
               
                    JOptionPane.showMessageDialog(null, "Sub menú de Reportes");
                    int subMenu = 0;
                    
         //ciclo para mostrar sub
                    String textosubMenu = "1. Reporte de trámites desertados \n"
                            + "2. Reporte de trámites por fila  \n"
                            + "3. Reporte de trámites finalizados  \n"
                            + "4. Reporte de pagos  \n"
                            + "5. Menu principal  \n";

                    while (subMenu != 5) {
                        //mostrar sub menu y solicitar opcion
                     
                        subMenu = Integer.parseInt(JOptionPane.showInputDialog(textosubMenu));
                        
                        switch (subMenu) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 1");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 2");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 3");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 4");
                                break;
                            default:
                                break;
                        }
                    }

                    break;}
            case 6: System.exit(opcionMenu);
               
            
        }
     }
    }
    
    //
    public static void ingreso() {
        String nombre = JOptionPane.showInputDialog("Ingrese A:");
    }
  
    public static void recepcion() {
        String nombre = JOptionPane.showInputDialog("Ingrese B:");
    }
    
   public static void documentos() {
        String nombre = JOptionPane.showInputDialog("Ingrese C:");
    } 
   
   public static void cajas() {
        String nombre = JOptionPane.showInputDialog("Ingrese D:");
    }
   
   public static void reportes() {
        String nombre = JOptionPane.showInputDialog("Ingrese E:");
    }
   
   
  
}
