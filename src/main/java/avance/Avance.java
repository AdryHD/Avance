package avance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import avance.Tramite;
import avance.Cliente;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class Avance {
    static Cliente[] cliente = new Cliente[10];
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
                    registroTramite ();
                    menu (); 
                    break;}
                case 3:tramiteRecepcion();
                menu (); 
                    break;
                case 4:{pedirDocumentos(listaClientes);
                menu (); 
                    break;}
                case 5:{tramitesCajas();

                case 1:
                    
                 
                    break;
           
                case 2:
                    obtenerDatos(cliente,tramite);
                menu (); 
                    break;
                case 3:recepcion();
                menu (); 
                    break;
                case 4:documentos();

                menu (); 
                    break;}
                case 6: 
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

                case 5:cajas();
                menu (); 
                    break;
                case 6: subMenuReportes();
                break;

                case 7:
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

    // Datos de ingreso de trámites
//    public static void ingreso() {
//        String nombre = JOptionPane.showInputDialog("Ingrese su nombre completo:");
//        String cedula = JOptionPane.showInputDialog("Ingrese su número de cédula:");
//        String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que deseea realizar:",
//                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, //con ayuda de https://recursosformacion.com/2018/05/java-programadores-9-7-cuadros-dialogo/
//                    new String[]{"Registro exportador", "Exoneración impuestos", "Activación de Registro de Importador",
//                            "Permisos especiales productos"}, "Registro exportador");
    }
    public static void recepcion() {
        // Solicitar tipo de cliente
        boolean tipoCliente = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION; //con ayuda de https://recursosformacion.com/2018/05/java-programadores-9-7-cuadros-dialogo/
        

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
    
    public static void pedirDocumentos(Cliente[] cliente) { 
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
    listaClientes[listaClientes.length-1] = (cliente);

        int continua = JOptionPane.showConfirmDialog(null, "Desea agregar otro cliente?","Continuar",YES_NO_OPTION);
            if(continua == JOptionPane.YES_OPTION){
       continuar = true;
            }else {continuar=false;}
    }
    }
    
    public static void tramitesCajas() {
         //Solicitar el tipo de trámite.
            String tipoTramite = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de trámite que desea analizar:",
                    "Tipo de Trámite", JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Cliente Preferencial", "Cliente Normal"}, "");
             //Pago
        boolean opcionPago = JOptionPane.showConfirmDialog(null, "¿El cliente va a pagar el trámite?", 

                "Cliente Preferencial", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        // Buscar el primer trámite en la fila del tipo seleccionado
        boolean tramiteEncontrado = false;
        for (int i = 0; i < cantidadCliente; i++) {
//            if (cliente[i].getTipoTramite().equals(tipoTramite)) {
                tramiteEncontrado = true;

                "Cliente Preferencial", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION; 


                // Verificar si el cliente paga o no el trámite
                int decisionPago = JOptionPane.showOptionDialog(null, "¿El cliente paga el trámite?",
                        "Pago del Trámite", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        new String[]{"Sí", "No"}, "Sí");

                if (decisionPago == JOptionPane.NO_OPTION) {
                    // Retirar al cliente de la agencia y almacenar el registro para trámites desertados
                    JOptionPane.showMessageDialog(null, "Cliente retirado de la agencia. Trámite desertado.");
                } else {
                    // Crear un registro de pago
                    double montoPagado = montoTramite(cliente[i].getTipoTramite());
                    Date fechaPago = new Date();
                    RegistroPago registroPago = new RegistroPago(cliente[i].getTipoTramite(), montoPagado, fechaPago);
                      // Mostrar información del pago
                    JOptionPane.showMessageDialog(null, "Trámite pagado exitosamente. Monto: $" + montoPagado + "\nFecha del Pago: " + fechaPago);

                    // Retirar al cliente de la agencia
                    cliente[i] = null;
                    cantidadCliente--;
                }
                break;
            }
        

        if (!tramiteEncontrado) {
            JOptionPane.showMessageDialog(null, "No hay trámites en cajas para analizar del tipo de cliente seleccionado.");
        }

    }
    
    
    public static void  obtenerDatos(Cliente cliente, Tramite tramite){

        String cedula = JOptionPane.showInputDialog("Digíte la cédula del cliente: ");
        
        int tipoTramite = Integer.parseInt(JOptionPane.showInputDialog("Digíte el tipo de trámite" + "\n" +
                    "1- Registro exportador" + "\n" +
                    "2- Exoneración impuestos" + "\n" +
                    "3- Activación de registro de importador" + "\n" +
                    "4- Permisos especiales productos" + "\n"));
        switch (tipoTramite){
            case 1:
                tramite.setTipoTramite("Registro exportador");
                break;
            case 2:
                tramite.setTipoTramite("Exoneración impuestos");
                break;
            case 3:
                tramite.setTipoTramite("Activación de registro de importador");
                break;
            case 4:
                tramite.setTipoTramite("Permisos especiales productos");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Digíte un número correcto entre 1 y 5");
                break;
            }
        LocalDateTime fechaHora = LocalDateTime.now();
        tramite.setHora(fechaHora);
        boolean preferencial = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Es cliente preferencial? true/false"));

        } 

    public void mostrarDatos(Cliente cliente, Tramite tramite){
        JOptionPane.showMessageDialog(null,"Nombre: " + cliente.getNombre() + "\n" +
                "Cédula: " + cliente.getIdentificacion() + "\n" +
                "Tipo de trámite: " + tramite.getTipoTramite() + "\n" +
                "Cliente preferencial: " + cliente.isPreferencial() + "\n" +
                "Fecha: " + tramite.getHora());
    }



public void crearCliente(Cliente cliente){
    boolean continuar = true;
    while (continuar){
        
    cliente.setNombre(JOptionPane.showInputDialog("Digite el numero de cedula:"));
    cliente.setIdentificacion(JOptionPane.showInputDialog("Digite el numero de cedula:"));
    cliente.setPreferencial(Boolean.parseBoolean(JOptionPane.showInputDialog("El Cliente es preferencial (true/false)")));
    //JOptionPane.showConfirmDialog(parentComponent, cliente, title, YES_NO_OPTION)
    }

    
    //ArrayList<String> cars = new ArrayList<String>();
    //cars.add("Volvo");

  

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
>>>>>>> Stashed changes
    }



//
//    private static double montoTramite(String tipoTramite) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//else {
//        JOptionPane.showMessageDialog(null, "No hay trámites en cajas para analizar.");
//    }
//}



      



