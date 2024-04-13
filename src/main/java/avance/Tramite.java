package avance;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;


public class Tramite {
   // private String nombre;
   // private String cedula;
    private String tipoTramite;
   // private boolean clientePreferencial;
    private String hora;
    private boolean aceptado;
    private boolean pago;

    public Tramite(String tipoTramite, String hora, boolean aceptado, boolean pago) {
        this.tipoTramite = tipoTramite;
        this.hora = hora;
        this.aceptado = aceptado;
        this.pago = pago;
    }

    public Tramite() {
        setTipoTramite("");
        setHora("");
        setAceptado(false);
        setPago(false);
    }
    
    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    void setHora(LocalDateTime fechaHora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
<<<<<<< Updated upstream


    


=======




>>>>>>> Stashed changes
}