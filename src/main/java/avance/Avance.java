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
                    + "1. Ingreso de trámite \n"
                    + "2. Análisis de trámites en “Recepción” \n"
                    + "3. Análisis de trámites en “Documentos” \n"
                    + "4. Análisis de trámites en “Cajas”  \n"
                    + "5. Reportes  \n"
                    + "6. Salir";

                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

// evaluar opcion
            switch (opcionMenu) {
                  
                case 1:{
                    ingresoTramite();
                    menu (); 
                    break;}
                case 2:{
                    analisisTramiteRecepcion();
                    menu (); 
                    break;}
                case 3:{
                    analisisTramiteDocumentos();
                    menu (); 
                    break;}
                case 4:{
                menu (); 
                    break;}
                case 5: {
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


                case 6:
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
            i=recepcion.length;
        }
    }
    
    if (espacioTramites != -1) {
        //Agregamos el cliente
        Tramite temp = new Tramite();
        temp.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre del Cliente: ")) ;
        temp.setIdentificacion(JOptionPane.showInputDialog(null, "Digite la identificacion del Cliente: "));
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
        temp.setTipoCliente("Preferencial");}else{temp.setTipoCliente("Normal");}
        temp.setFechaRecepcion(LocalDateTime.now());
        temp.setMonto(0);
        String tipo[] = new String[4];
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
    //System.out.println(recepcion[espacioTramites].toString());
    //System.out.println(espacioTramites);

  
public static void analisisTramiteRecepcion() {
//boolean r;
// Validar que hay espacio
    int espacioTramites = -1;
    for (int i = 0; i < documentos.length; i++) {
        if (documentos[i] == null) {
            espacioTramites = i;
            i=documentos.length;
        }
    }
    String tipo[] = new String[2];
    tipo[0] = "Normal";
    tipo[1] = "Preferencial";

    if (espacioTramites != -1) {
        //Agregamos el cliente
        //Tramite temp = new Tramite();
        Object respuesta = JOptionPane.showInputDialog(null,"Selecciona un tipo de tramite", "Elegir",JOptionPane.QUESTION_MESSAGE,null,tipo, "Normal");
        //System.out.println(respuesta);
           //https://www.youtube.com/watch?v=A-R9SrKQmGY
        //if (respuesta.toString().equals("Preferencial")){r=true;}else{r=false;}
        for(int j=0;j<recepcion.length;j++){
            if (recepcion[j].getTipoCliente().equals(respuesta.toString())){ 
                
                    
                        //if (JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Tramite "+recepcion[i].getTipo()+"?", "Aprobar tramite", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){}
                        documentos[espacioTramites]=recepcion[j];
                        documentos[espacioTramites].setFechaDocumentos(LocalDateTime.now());
                        recepcion[j]=null;
                        for (int k=1;k<recepcion.length; k++){
                            if((recepcion[j+k]!=null)&&((j+k)<recepcion.length))recepcion[j+(k-1)]=recepcion[j+k];
                            recepcion[j+k]=null;
                        }
                        //i=recepcion.length;
                        j=recepcion.length;

                        }
                
            
        }
        JOptionPane.showMessageDialog(null,"Se agregó  un tramite a Documentos");
    }else {JOptionPane.showMessageDialog(null,"No hay espacio");}
    System.out.println(documentos[espacioTramites].toString());
    System.out.println(espacioTramites);
}
  
public static void analisisTramiteDocumentos() {

// Validar que hay espacio
    int espacioTramites = -1;
    for (int i = 0; i < caja.length; i++) {
        if (caja[i] == null) {
            espacioTramites = i;
             i=caja.length;
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
        for(int j=0;j<documentos.length;j++){
             if (documentos[j].getTipoCliente().equals(respuesta.toString())){ 
                        if (JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Tramite? "+documentos[espacioTramites].toString(), "Aprobar tramite", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        
                        caja[espacioTramites]=documentos[j];
                        caja[espacioTramites].setFechaCaja(LocalDateTime.now());
                        switch (caja[espacioTramites].getTipo()) {
                                case "Registro exportador":{
                                caja[espacioTramites].setMonto(100);
                                break;}
                                case "Exoneración impuestos":{
                                caja[espacioTramites].setMonto(10);
                                break;}
                                case "Activación de registro":{
                                caja[espacioTramites].setMonto(50);
                                break;}
                                case "Permisos especiales productos":{
                                caja[espacioTramites].setMonto(25);
                                break;}}
                      
                        documentos[j]=null;
                        for (int k=1;k<documentos.length; k++){
                            if((documentos[j+k]!=null)&&((j+k)<documentos.length))documentos[j+(k-1)]=documentos[j+k];
                            documentos[j+k]=null;
                        }
                        //i=documentos.length;
                        j=documentos.length;

                        }
             
        }
        JOptionPane.showMessageDialog(null,"Se agregó  un tramite a Cajas");}
    System.out.println(caja[espacioTramites].toString());
    System.out.println(espacioTramites);
    }else {JOptionPane.showMessageDialog(null,"No hay espacio");}
}
  
}

      



