package avance;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Avance {

    static Tramite[] recepcion = new Tramite[10];
    static Tramite[] documentos = new Tramite[10];
    static Tramite[] caja = new Tramite[10];
    static Tramite[] finalizados = new Tramite[10];

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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

                case 1: {
                    ingresoTramite();
                    menu();
                    break;
                }
                case 2: {
                    analisisTramiteRecepcion();
                    menu();
                    break;
                }
                case 3: {
                    analisisTramiteDocumentos();
                    menu();
                    break;
                }
                case 4: {
                    analisisTramiteCajas();
                    menu();
                    break;
                }
                case 5: {
                    int opcionReporte = 0;
                    while (opcionReporte != 6) {
                        String textoMenuReportes = "1. Reporte Visual de la Agencia \n"
                                + "2. Reporte de Trámites Desertados \n"
                                + "3. Reporte de Trámites por Fila \n"
                                + "4. Reporte de Trámites Finalizados \n"
                                + "5. Reporte de Pagos \n"
                                + "6. Salir \n";
                        opcionReporte = Integer.parseInt(JOptionPane.showInputDialog(textoMenuReportes));
                        switch (opcionReporte) {
                            case 1:
                                generarReporte();
                                break;
                            case 2:
                                tramitesDesertados();
                                break;
                            case 3:
                                tramitesFilas();
                                break;
                            case 4:
                                tramitesFinalizados();
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                    }
                    break;
                }

                case 6: {
                    System.exit(0);
                    break;
                }
                case 7: {
                    imprimirArreglo(recepcion, "Recepcion");
                    break;
                }
                case 8: {
                    imprimirArreglo(documentos, "Documentos");
                    break;
                }
                case 9: {
                    imprimirArreglo(caja, "Cajas");
                    break;
                }
                case 10: {
                    imprimirArreglo(finalizados, "Finalizados");
                    break;
                }
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
                i = recepcion.length;
            }
        }

        if (espacioTramites != -1) {
            //Agregamos el cliente
            Tramite temp = new Tramite();
            temp.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre del Cliente: "));
            temp.setIdentificacion(JOptionPane.showInputDialog(null, "Digite la identificacion del Cliente: "));
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                temp.setTipoCliente("Preferencial");
            } else {
                temp.setTipoCliente("Normal");
            }
            temp.setFechaRecepcion(LocalDateTime.now());
            temp.setMonto(0);
            String tipo[] = new String[4];
            tipo[0] = "Registro exportador";
            tipo[1] = "Exoneración impuestos";
            tipo[2] = "Activación de Registro de Importador";
            tipo[3] = "Permisos especiales productos";
            Object resp = JOptionPane.showInputDialog(null, "Selecciona un tipo de tramite", "Elegir", JOptionPane.QUESTION_MESSAGE, null, tipo, "Registro exportador");
            temp.setTipo(resp.toString());
            recepcion[espacioTramites] = temp;
            JOptionPane.showMessageDialog(null, "Se agregó un nuevo Tramite");
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio");
        }
    }

    public static void analisisTramiteRecepcion() {
// Validar que hay espacio
        boolean encontrado = false;
        int espacioTramites = -1;
        for (int i = 0; i < documentos.length; i++) {
            if (documentos[i] == null) {
                espacioTramites = i;
                i = documentos.length;
                System.out.println("Espacio tramites" + espacioTramites);
            }
        }
        String tipo[] = new String[2];
        tipo[0] = "Normal";
        tipo[1] = "Preferencial";

        if (espacioTramites != -1) {
            //Agregamos el cliente
            Object respuesta = JOptionPane.showInputDialog(null, "Selecciona un tipo de tramite", "Elegir", JOptionPane.QUESTION_MESSAGE, null, tipo, "Normal");
            //https://www.youtube.com/watch?v=A-R9SrKQmGY
            for (int j = 0; j < recepcion.length; j++) {
                if (recepcion[j] != null) {
                    if (recepcion[j].getTipoCliente().equals(respuesta.toString())) {
                        documentos[espacioTramites] = recepcion[j];
                        documentos[espacioTramites].setFechaDocumentos(LocalDateTime.now());
                        recepcion[j] = null;
                        recepcion = limpiarArreglo(recepcion);
                        j = recepcion.length;
                        encontrado = true;
                    }
                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, "Se agregó  un tramite a Documentos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun tramite de tipo " + respuesta.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio");
        }
    }

    public static void analisisTramiteDocumentos() {
        boolean encontrado = false;
// Validar que hay espacio
        int espacioTramites = -1;
        for (int i = 0; i < caja.length; i++) {
            if (caja[i] == null) {
                espacioTramites = i;
                i = caja.length;
            }
        }
        String tipo[] = new String[2];
        tipo[0] = "Normal";
        tipo[1] = "Preferencial";

        if (espacioTramites != -1) {
            //Agregamos el cliente
            Object respuesta = JOptionPane.showInputDialog(null, "Selecciona un tipo de tramite", "Elegir", JOptionPane.QUESTION_MESSAGE, null, tipo, "Normal");
            //https://www.youtube.com/watch?v=A-R9SrKQmGY
            for (int j = 0; j < documentos.length; j++) {
                if (documentos[j] != null) {
                    if (documentos[j].getTipoCliente().equals(respuesta.toString())) {
                        if (JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Tramite? \n" + documentos[j].toString(), "Aprobar tramite", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                            caja[espacioTramites] = documentos[j];
                            caja[espacioTramites].setFechaCaja(LocalDateTime.now());
                            switch (caja[espacioTramites].getTipo()) {
                                case "Registro exportador": {
                                    caja[espacioTramites].setMonto(100);
                                    break;
                                }
                                case "Exoneración impuestos": {
                                    caja[espacioTramites].setMonto(10);
                                    break;
                                }
                                case "Activación de Registro de Importador": {
                                    caja[espacioTramites].setMonto(50);
                                    break;
                                }
                                case "Permisos especiales productos": {
                                    caja[espacioTramites].setMonto(25);
                                    break;
                                }
                            }

                            documentos[j] = null;
                            documentos = limpiarArreglo(documentos);
                            j = documentos.length;
                            encontrado = true;
                        } else {
                            Tramite temp = new Tramite();
                            temp = documentos[j];
                            documentos[j] = null;
                            documentos = limpiarArreglo(documentos);
                            j = documentos.length;
                            //System.out.println(temp.toString());
                            for (int a = 0; a < documentos.length; a++) {
                                if (documentos[a] == null) {
                                    documentos[a] = temp;
                                    a = documentos.length;
                                }
                            }
                        }

                    }
                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, "Se agregó  un tramite a Cajas");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun tramite de tipo " + respuesta.toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio");
        }

    }

    public static void analisisTramiteCajas() {
        boolean encontrado = false;
// Validar que hay espacio
        int espacioTramites = -1;
        for (int i = 0; i < finalizados.length; i++) {
            if (finalizados[i] == null) {
                espacioTramites = i;
                i = finalizados.length;
            }
        }
        String tipo[] = new String[2];
        tipo[0] = "Normal";
        tipo[1] = "Preferencial";

        if (espacioTramites != -1) {
            Object respuesta = JOptionPane.showInputDialog(null, "Selecciona un tipo de tramite", "Elegir", JOptionPane.QUESTION_MESSAGE, null, tipo, "Normal");
            //https://www.youtube.com/watch?v=A-R9SrKQmGY
            for (int j = 0; j < caja.length; j++) {
                if (caja[j] != null) {
                    if (caja[j].getTipoCliente().equals(respuesta.toString())) {
                        finalizados[espacioTramites] = caja[j];
                        finalizados[espacioTramites].setFechaFin(LocalDateTime.now());
                        if (JOptionPane.showConfirmDialog(null, "¿Desea Pagar el Tramite? " + caja[j].toString(), "Pagar tramite", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            finalizados[espacioTramites].setPagado("Pagado");
                        } else {
                            finalizados[espacioTramites].setPagado("Retirado");
                        }
                        caja[j] = null;
                        caja = limpiarArreglo(caja);
                        j = caja.length;
                        encontrado = true;
                    }

                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, "Se finalizó  un tramite");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun tramite de tipo " + respuesta.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio");
        }
    }

    private static Tramite[] limpiarArreglo(Tramite[] a) {
        Tramite[] temp = new Tramite[10];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                temp[j] = a[i];
                j++;
            }

        }
        return temp;
    }

    private static void imprimirArreglo(Tramite[] a, String texto) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                texto = "Arreglo " + texto + "\n\n\n" + a[i].toString() + "\n";
            } else {
                texto = texto + "\n\n\n" + "Posicion " + i + " del arreglo está vacia \n\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }
 
    // PEPORTES
    private static void generarReporte(){
        StringBuilder reporte = new StringBuilder();
        reporte.append("Recepción: \n");
        for (Tramite tramite : recepcion){
            if (tramite != null){
                reporte.append(tramite.getTipoCliente().charAt(0)).append(" ");
            }
            else{
                reporte.append("- ");
            }
        }
        reporte.append("\n");
        reporte.append("Documentos: \n");
        for (Tramite tramite : documentos){
            if (tramite != null){
                reporte.append(tramite.getTipoCliente().charAt(0)).append(" ");
        } else {
            reporte.append("- ");
        }
            }
        reporte.append("\n");
        reporte.append("Cajas: \n");
        for (Tramite tramite : caja){
            if (tramite != null){
                reporte.append(tramite.getTipoCliente().charAt(0)).append(" ");
            }
            else{
                reporte.append("- ");
            }
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
    
    private static void tramitesDesertados(){
        StringBuilder reporte = new StringBuilder();
        reporte.append("Lista de Trámites Desertados: \n");
        boolean desertado = false;
        for (Tramite tramite : finalizados){
            if(tramite != null && tramite.getPagado() != null && tramite.getPagado().equals("Retirado")){
                reporte.append("Nombre: ").append(tramite.getNombre()).append("\n");
                reporte.append("Identificación: ").append(tramite.getIdentificacion()).append("\n");
                reporte.append("Tipo de Cliente: ").append(tramite.getTipoCliente()).append("\n");
                reporte.append("Tipo de Trámite: ").append(tramite.getTipo()).append("\n");
                reporte.append("Fecha de Asignación: ").append(tramite.getFechaRecepcion()).append("\n");
                reporte.append("Fecha de Finalización: ").append(tramite.getFechaFin()).append("\n");
                reporte.append("Estado: ").append(tramite.getPagado()).append("\n\n");
                desertado = true;
            }
        }
        if (!desertado){
            reporte.append("Sin Trámites Desertados");
        }
        JOptionPane.showMessageDialog(null, reporte.toString());

}
    private static void tramitesFilas(){
        StringBuilder reporte = new StringBuilder();
        int fila = Integer.parseInt(JOptionPane.showInputDialog("1- Recepción \n"
                +"2- Documentos \n"
                +"3- Cajas \n"
                +"4- Salir"));
        switch (fila){
            case 1:
                reporte.append("Recepción:\n");
                for (Tramite tramite : recepcion){
                    if (tramite != null){
                        reporte.append(tramite).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, reporte.toString());
                break;
            case 2:
                reporte.append("Documentos:\n");
                for (Tramite tramite : documentos){
                    if (tramite != null){
                        reporte.append(tramite).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, reporte.toString());
                break;
            case 3:
                reporte.append("Cajas:\n");
                for (Tramite tramite : caja){
                    if (tramite != null){
                        reporte.append(tramite).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, reporte.toString());
                break;
            case 4:
                break;
        }
    }
    
    private static void tramitesFinalizados(){
        StringBuilder reporte = new StringBuilder();
        reporte.append("Trámites Finalizados: \n");
        boolean tramites = false;
        for (Tramite tramite : finalizados){
             if(tramite != null && "Pagado".equals(tramite.getPagado())){
                reporte.append("Nombre: ").append(tramite.getNombre()).append("\n");
                reporte.append("Identificación: ").append(tramite.getIdentificacion()).append("\n");
                reporte.append("Tipo de Cliente: ").append(tramite.getTipoCliente()).append("\n");
                reporte.append("Tipo de Trámite: ").append(tramite.getTipo()).append("\n");
                reporte.append("Fecha de Asignación: ").append(tramite.getFechaRecepcion()).append("\n");
                reporte.append("Fecha de Finalización: ").append(tramite.getFechaFin()).append("\n");
                reporte.append("Estado: ").append(tramite.getPagado()).append("\n\n");
                tramites = true;
             }
        }
        if (!tramites){
            reporte.append("No hay Trámites Finalizados");
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}



