package avance;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import avance.Tramite;
import avance.Cliente;
import static javax.swing.JOptionPane.YES_NO_OPTION;*/

public class Avance {
    static Tramite[] recepcion = new Tramite[10];
    static Tramite[] documentos = new Tramite[10];
    static Tramite[] caja = new Tramite[10];
    //static int cantidadCliente = 3;

    public static void main(String[] args) {
        menu();
    }
    
    
      public static void menu() {
      //Tramite tramite = new Tramite();
      //Cliente cliente = new Cliente();
      int opcionMenu = 0;
        //ciclo para mostrar menu
        
        while (opcionMenu != 7) {

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
                    
                    menu ();
                    break;}
                case 2:{
                     
                    menu (); 
                    break;}
                case 3:{
                menu (); 
                    break;}
                case 4:{
                menu (); 
                    break;}
                case 5:{
                menu (); 
                    break;}
                case 6: {
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
                    break;}


                case 7:
                    System.exit(0); 
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválidad");
                    break;
            
                   
            }
        }

      }
    
      
      
  
public static void ingresoTramite() {

// Validar que hay espacio
    int espacioTramites = -1;
    for (int i = 0; i < recepcion.length; i++) {
        if (recepcion[i] == null) {
            espacioTramites = i;
        }
    }
    
    if (espacioTramites != -1) {
        //Agregamos el cliente
        Tramite temp = new Tramite();
        temp.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre del Cliente: ")) ;
        temp.setIdentificacion(JOptionPane.showInputDialog(null, "Digite la identificacion del Cliente: "));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
        temp.setPreferencial(true);
            }else {temp.setPreferencial(false);}  
        
        temp.setFecha(LocalDateTime.now());
        temp.setMonto(0);
        String tipo[] = new String[2];
        tipo[0] = "Registro exportador";
        tipo[1] = "Exoneración impuestos";
        tipo[2] = "Activación de Registro de Importador";
        tipo[3] = "Permisos especiales productos";
        Object resp = JOptionPane.showInputDialog(null,"Selecciona un tipo de tramite", "Elegir",JOptionPane.QUESTION_MESSAGE,null,tipo, "Registro exportador");
        temp.setTipo(resp.toString());
        recepcion[espacioTramites]=temp;
        JOptionPane.showMessageDialog(null,"Se agregó un nuevo Tramite");
}else {JOptionPane.showMessageDialog(null,"No hay espacio");}
}
  
public static void analisisTramiteRecepcion() {

// Validar que hay espacio
    int espacioTramites = -1;
    for (int i = 0; i < documentos.length; i++) {
        if (documentos[i] == null) {
            espacioTramites = i;
        }
    }
    String tipo[] = new String[2];
    tipo[0] = "Normal";
    tipo[1] = "Preferencial";

    if (espacioTramites != -1) {
        //Agregamos el cliente
        //Tramite temp = new Tramite();
        Object respuesta = JOptionPane.showInputDialog(null,"Selecciona un tipo de tramite", "Elegir",JOptionPane.QUESTION_MESSAGE,null,tipo, "Normal");
           //https://www.youtube.com/watch?v=A-R9SrKQmGY
        for(int i=0;i<recepcion.length;i++){
            if (recepcion[i].getTipo()==respuesta){ 
                for(int j=0;j<documentos.length;j++){
                    if (documentos[j]==null){
                        //if (JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Tramite "+recepcion[i].getTipo()+"?", "Aprobar tramite", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){}
                        documentos[j]=recepcion[i];
                        documentos[j].setFecha(LocalDateTime.now());
                        recepcion[i]=null;
                        for (int k=1;k<recepcion.length; k++){
                            if((recepcion[i+k]!=null)&&((i+k)<recepcion.length))recepcion[i+(k-1)]=recepcion[i+k];
                            recepcion[i+k]=null;
                        }
                        i=recepcion.length;
                        j=recepcion.length;

                        }
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Se agregó  un tramite a Documentos");
    }else {JOptionPane.showMessageDialog(null,"No hay espacio");}
}
  
}

      



