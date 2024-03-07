package avance;

import javax.swing.JOptionPane;

public class Tramite {
    private String nombre;
    private String cedula;
    private String tipoTramite;
    private boolean clientePreferencial;

    public Tramite() {
    }

    public Tramite(String nombre, String cedula, String tipoTramite, boolean clientePreferencial) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoTramite = tipoTramite;
        this.clientePreferencial = clientePreferencial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isClientePreferencial() {
        return clientePreferencial;
    }

    public void setClientePreferencial(boolean clientePreferencial) {
        this.clientePreferencial = clientePreferencial;
    }
    
    public void obtenerDatos(){
        String nombre = JOptionPane.showInputDialog("Digíte el nombre del cliente: ");
        setNombre(nombre);
        String cedula = JOptionPane.showInputDialog("Digíte la cédula del cliente: ");
        setCedula(cedula);
        int tipoTramite = Integer.parseInt(JOptionPane.showInputDialog("Digíte el tipo de trámite" + "\n" +
                    "1- Registro exportador" + "\n" +
                    "2- Exoneración impuestos" + "\n" +
                    "3- Activación de registro de importador" + "\n" +
                    "4- Permisos especiales productos" + "\n" +
                    "5- Salir"));
        switch (tipoTramite){
            case 1:
                setTipoTramite("Registro exportador");
                break;
            case 2:
                setTipoTramite("Exoneración impuestos");
                break;
            case 3:
                setTipoTramite("Activación de registro de importador");
                break;
            case 4:
                setTipoTramite("Permisos especiales productos");
                break;
            case 5:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Digíte un número correcto entre 1 y 5");
                break;
            }
        }         
}


