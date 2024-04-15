package avance;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


public class Tramite {

    private LocalDateTime fecha;
  

    private String tipo;
    private int monto;
    private String nombre;
    private String identificacion;
    private boolean preferencial;

    public Tramite(LocalDateTime fecha, String tipo, int monto, String nombre, String identificacion, boolean preferencial) {
        this.fecha = fecha;

        this.tipo = tipo;
        this.monto = monto;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.preferencial = preferencial;
    }

 

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

    public Tramite() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registro de Tramite\n");
        sb.append("**************\n");
        sb.append("Nombre del cliente: ").append(nombre).append("\n");
        sb.append("Identificacion del cliente: ").append(identificacion).append("\n");
        if (preferencial){sb.append("Tipo de Cliente: ").append("Preferencial").append("\n");}
        else{sb.append("Tipo de Cliente: ").append("Normal").append("\n");}
        sb.append("Tipo de Tramite: ").append(tipo).append("\n");
        sb.append("Monto a Pagar: ").append(monto).append("\n");
        sb.append("Fecha de ingreso: ").append(fecha).append("\n");
        
        return sb.toString();
    }    


}