package avance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente {
    
    //Atributos
    private String nombre;
    private int identificacion;
    private String tipoTramite;
    private boolean tipoCliente;
    private Date fechaHoraIngreso;
    
    public Cliente() {
        
    }
    public Cliente(String nombre, int identificacion, String tipoTramite, boolean tipoCliente, String fechaHoraIngreso) throws ParseException {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoTramite = tipoTramite;
        this.tipoCliente = tipoCliente;
        DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaHoraIngreso = formateador.parse(fechaHoraIngreso);
    }
    public void pedirDatos() {
        this.nombre = JOptionPane.showInputDialog("Digite su nombre completo");
        this.identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite su número de cédula"));
        this.tipoTramite = JOptionPane.showInputDialog("Tipo de Trámite \n *************\n"
                + "1. Registro Exportador \n" 
                + "2. Exoneración Impuestos \n" 
                + "3. Activación de Registro Importador \n" 
                + "4. Permisos Especiales Productos");
        this.tipoCliente = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        this.fechaHoraIngreso = new Date();
    }
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Date getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(Date fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    @Override
    public String toString() {
        return "Recepcion \n" 
                + "Nombre: " + nombre + "\n"
                + "Identificacion: " + identificacion + "\n"
                + "Tipo de Trámite: " + tipoTramite + "\n"
                + "Tipo de Cliente: " + tipoCliente + "\n"
                + "Fecha y Hora de Ingreso: " + fechaHoraIngreso + "\n";
    }
}
