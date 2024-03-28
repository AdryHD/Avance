package avance;
public class Cliente {
    
    private String nombre;
    private String identificacion;
    private boolean preferencial;

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

   
}
