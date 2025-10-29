public class Ingrediente {
    private String nombre;
    private String cantidad;
    private Ingrediente sig;

    public Ingrediente(String nombre,String cantidad) {
        this.nombre = nombre;
        this.cantidad=cantidad;
        this.sig = null;
    }

    public Ingrediente(String nombre, String cantidad, Ingrediente sig) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.sig = sig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Ingrediente getSig() {
        return sig;
    }

    public void setSig(Ingrediente sig) {
        this.sig = sig;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+" Cantidad: "+cantidad;
    }
}
