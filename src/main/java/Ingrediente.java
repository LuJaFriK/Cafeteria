public class Ingrediente {
    private String nombre;
    private Ingrediente sig;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
        this.sig = null;
    }

    public Ingrediente(String dato, Ingrediente sig) {
        this.nombre = dato;
        this.sig = sig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ingrediente getSig() {
        return sig;
    }

    public void setSig(Ingrediente sig) {
        this.sig = sig;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
