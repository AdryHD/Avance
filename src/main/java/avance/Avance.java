
package avance;

import javax.swing.JOptionPane;

public class Avance {

    public static void main(String[] args) {
      int opcionMenu = 0;

        //ciclo para mostrar menu
        
        while (opcionMenu != 5) {

            //mostrar menu
            String textoMenu = "1. Registros \n"
                    + "2. Consultas \n"
                    + "3. Modificacion \n"
                    + "4. Reportes  \n"
                    + "5. Salir";

                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

// evaluar opcion
            switch (opcionMenu) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Eligio la opcion 1");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Eligio la opcion 2");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Eligio la opcion 3");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Eligio la opcion 4");
                    int subMenu = 0;
         //ciclo para mostrar sub
         /*1. Reporte ventas
         2. Reporte gastos 
         3. Salir */

                    String textosubMenu = "1. Reporte ventas \n"
                            + "2. Reporte gastos  \n"
                            + "3. Menu principal  \n";

                    while (subMenu != 3) {
                        //mostrar sub menu y solicitar opcion
                     
                        subMenu = Integer.parseInt(JOptionPane.showInputDialog(textosubMenu));
                        
                        switch (subMenu) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 1");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Sub - opcion 2");
                                break;
                            default:
                                break;
                        }
                    }

                    break;
            case 5:
                break;
                default:
                    JOptionPane.showMessageDialog(null, opcionMenu + " Este número no es una opcion válida.");
                    break;

            }
        }
     }
    
    
    
    
}
