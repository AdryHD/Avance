package avance;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;

public class Tramite {
    private String nombre;
    private String cedula;
    private String tipoTramite;
    private boolean clientePreferencial;
    private String hora;

    public Tramite() {
    }

    public Tramite(String nombre, String cedula, String tipoTramite, boolean clientePreferencial, String hora) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoTramite = tipoTramite;
        this.clientePreferencial = clientePreferencial;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.hora = hora.format(formatter);
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
                    "4- Permisos especiales productos" + "\n"));
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
            default:
                JOptionPane.showMessageDialog(null, "Digíte un número correcto entre 1 y 5");
                break;
            }
        LocalDateTime fechaHora = LocalDateTime.now();
        setHora(fechaHora);
        boolean preferencial = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Es cliente preferencial? true/false"));
        } 

    public void mostrarDatos(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() + "\n" +
                "Cédula: " + getCedula() + "\n" +
                "Tipo de trámite: " + getTipoTramite() + "\n" +
                "Cliente preferencial: " + isClientePreferencial() + "\n" +
                "Fecha: " + getHora());
    }
}


