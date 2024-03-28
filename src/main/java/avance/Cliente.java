package avance;

import javax.swing.JOptionPane;

public class Cliente {
    
    private String nombre;
    private String identificacion;
    private boolean preferencial;
    private boolean tipoCliente;
    private String tipoTramite;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public Cliente(String nombre, String identificacion, boolean preferencial) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.preferencial = preferencial;
    }

      public Cliente() {
        setNombre("");
        setIdentificacion("");
        setPreferencial(false);
    }


     

public void pedirDatos() {
       /* this.nombre = JOptionPane.showInputDialog("Digite su nombre completo");
        this.identificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite su número de cédula"));
        this.tipoTramite = JOptionPane.showInputDialog("Tipo de Trámite \n *****\n"
                + "1. Registro Exportador \n" 
                + "2. Exoneración Impuestos \n" 
                + "3. Activación de Registro Importador \n" 
                + "4. Permisos Especiales Productos");
        this.tipoCliente = JOptionPane.showConfirmDialog(null, "¿Es cliente preferencial?", "Cliente Preferencial",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        this.fechaHoraIngreso = new Date();*/
    }
}