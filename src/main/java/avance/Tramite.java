package avance;
import javax.swing.JOptionPane;

/**
 *
 * @author adryhd
 */
public class Tramite {
    private int TipoTramite;
    private int registroExportador;
    private int Exoneracion;
    private int activacionImportador;
    private int permisosEspeciales;
    //private Cliente cliente = new Cliente ();
    
    
       //tipo tramite: 
    //1. Registro exportador
    //2. Exoneracion Impuestos
    //3. Activacion de Registro de Importador
    //4. Permisos Especiales Productos
   
    
     
   public void tipoTramite () {
    //Tramite tramite = new Tramite();
    //tramite = new Tramite();
    //tramite.setTipoTramite(Integer.parseInt(JOptionPane.showInputDialog("Digite: \n" + " 1 - Para Registro exportador: + " + "\n" + "2 - Para Exoneracion Impuestos \n" + " 3 - Para Activacion de Registro de Importador \n" + "4 - Para Permisos Especiales Productos")));

   } 

    public int getTipoTramite() {
        return TipoTramite;
    }

    public void setTipoTramite(int tipoTramite) {
        this.TipoTramite = tipoTramite;
    }

    public int getRegistroExportador() {
        return registroExportador;
    }

    public void setRegistroExportador(int registroExportador) {
        this.registroExportador = registroExportador;
    }

    public int getExoneracion() {
        return Exoneracion;
    }

    public void setExoneracion(int Exoneracion) {
        this.Exoneracion = Exoneracion;
    }

    public int getActivacionImportador() {
        return activacionImportador;
    }

    public void setActivacionImportador(int activacionImportador) {
        this.activacionImportador = activacionImportador;
    }

    public int getPermisosEspeciales() {
        return permisosEspeciales;
    }

    public void setPermisosEspeciales(int permisosEspeciales) {
        this.permisosEspeciales = permisosEspeciales;
    }
   
    
       
     
   public void datosCliente () {
    
   // this.cliente.setNombre(JOptionPane.showInputDialog("Nombre del Cliente: "));
   // this.cliente.setIdentificacion(JOptionPane.showInputDialog("Digite la Identificacion: "));
   // this.cliente.setPreferencial(Boolean.parseBoolean(JOptionPane.showInputDialog("Indique si es cliente preferncial (true/false)")));

   } 
   
            
}
   

