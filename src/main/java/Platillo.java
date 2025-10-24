public class Platillo {
    private String nombre;
    private Platillo sig;
    private Platillo ant;

    public Platillo(String nombre) {
        this.nombre = nombre;
        this.sig = null;
        this.ant = null;
    }

    public Platillo(String nombre, Platillo sig, Platillo ant) {
        this.nombre = nombre;
        this.sig = null;
        this.ant = null;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Platillo getSig() {
        return sig;
    }

    public void setSig(Platillo sig) {
        this.sig = sig;
    }

    public Platillo getAnt() {
        return ant;
    }

    public void setAnt(Platillo ant) {
        this.ant = ant;
    }

    @Override
    public String toString(){
        return nombre;
    }






}
