
package avance;

import javax.swing.JOptionPane;

public class Avance {

    public static void main(String[] args) { 
     JOptionPane.showMessageDialog(null, "Bienvenido a la Agencia Aduanal"); 
        
menu ();
subMenu ();
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
                            case 1:{desertados();
                            subMenu (); 
                            break;}
                            case 2: {porFila();
                            subMenu (); 
                            break;}
                            case 3:{finalizados();
                            subMenu (); 
                            break;}
                            case 4:{pagos();
                            subMenu (); 
                            break;}
                            case 5 :
                                break;
                        }
                    }

                    break;}
            case 6: System.exit(opcionMenu);
               
            
        }
     }
    }
    
    //STATIC VOID MENU PRINCIPAL
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
}
