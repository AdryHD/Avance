package avance;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


public class Tramite {

    private LocalDateTime fechaRecepcion;
    private LocalDateTime fechaDocumentos;
    private LocalDateTime fechaCaja;
    private LocalDateTime fechaFin;
  

    private String tipo;
    private int monto;
    private String nombre;
    private String identificacion;
    private String tipoCliente;

    public Tramite(LocalDateTime fechaRecepcion, LocalDateTime fechaDocumentos, LocalDateTime fechaCaja, LocalDateTime fechaFin, String tipo, int monto, String nombre, String identificacion, String tipoCliente) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaDocumentos = fechaDocumentos;
        this.fechaCaja = fechaCaja;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.monto = monto;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDateTime getFechaDocumentos() {
        return fechaDocumentos;
    }

    public void setFechaDocumentos(LocalDateTime fechaDocumentos) {
        this.fechaDocumentos = fechaDocumentos;
    }

    public LocalDateTime getFechaCaja() {
        return fechaCaja;
    }

    public void setFechaCaja(LocalDateTime fechaCaja) {
        this.fechaCaja = fechaCaja;
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

    public Tramite() {
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
        sb.append("Tipo de Cliente: ").append(tipoCliente).append("\n");
        sb.append("Tipo de Tramite: ").append(tipo).append("\n");
        sb.append("Monto a Pagar: ").append(monto).append("\n");
        sb.append("Fecha de ingreso: ").append(fechaRecepcion).append("\n");
        sb.append("Fecha de movido a Documentos: ").append(fechaDocumentos).append("\n");
        sb.append("Fecha de movido a Cajas: ").append(fechaCaja).append("\n");
        sb.append("Fecha de Finalizacion: ").append(fechaFin).append("\n");
        
        return sb.toString();
    }    


}