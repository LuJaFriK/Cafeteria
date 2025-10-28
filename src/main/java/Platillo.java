public class Platillo {
    private String nombre;
    private Platillo sig;
    private Platillo ant;
    private Ingrediente ingrediente_head;

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
    
    public void addIngrediente(Ingrediente ingrediente) {
        ingrediente_head = new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad(), ingrediente_head);
    }
    
    public void removeIngrediente(String nombre) {
        if(ingrediente_head.getNombre().equals(nombre)) {
            ingrediente_head = ingrediente_head.getSiguiente();
        }else{
            Ingrediente current = ingrediente_head;
            while(current.getSiguiente() != null){
                if(current.getSiguiente().getNombre().equals(nombre)){
                    current.setSiguiente(current.getSiguiente().getSiguiente());
                    return;
                }
                current = current.getSiguiente();
            }
        }
        System.out.println("Ingrediente no encontrado");
    }
    
    public String Ingredientes(){
        StringBuilder sb = new StringBuilder();
        Ingrediente current = ingrediente_head;
        while(current != null){
            sb.append(current.toString()).append("\n");
            current = current.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nIngredientes:\n"+Ingredientes();
    }
}
