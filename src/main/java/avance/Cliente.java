package avance;
import javax.swing.JOptionPane;
public class Cliente {
    
    //ATRIBUTOS
    private String nombre;
    private String identificacion;
    private boolean preferencial;
    private Tramite tipoTramite = new Tramite ();

//fecha
//hora
    
 
  //setter y getter
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

    



}
