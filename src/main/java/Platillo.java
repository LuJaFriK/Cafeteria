public class Platillo {
    private String nombre;
    private Platillo sig;
    private Platillo ant;
    private Ingrediente ingrediente_head;

    public Platillo(String nombre) {
        this.nombre = nombre;
        this.sig = null;
        this.ant = null;
        this.ingrediente_head=null;
    }

    public Platillo(String nombre, Platillo sig, Platillo ant) {
        this.nombre = nombre;
        this.sig = null;
        this.ant = null;
        this.ingrediente_head=null;
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

    public Ingrediente getIngrediente_head() {
        return ingrediente_head;
    }

    public void setIngrediente_head(Ingrediente ingrediente_head) {
        this.ingrediente_head = ingrediente_head;
    }
    
    
    public void addIngrediente(Ingrediente ingrediente) {
        ingrediente.setSig(ingrediente_head);
        ingrediente_head = ingrediente;
    }
    
    public void removeIngrediente(String nombre) {
        if(ingrediente_head == null) return;
        if(ingrediente_head.getNombre().equals(nombre)) {
            ingrediente_head = ingrediente_head.getSig();
        }else{
            Ingrediente current = ingrediente_head;
            while(current.getSig() != null){
                if(current.getSig().getNombre().equals(nombre)){
                    current.setSig(current.getSig().getSig());
                    return;
                }
                current = current.getSig();
            }
        }
    }
    
    public String Ingredientes(){
        if(ingrediente_head==null) return "";
        StringBuilder sb = new StringBuilder();
        Ingrediente current = ingrediente_head;
        sb.append("[");
        while(current != null){
            sb.append(current.toString());
            if(current.getSig()!=null) sb.append(", ");
            current = current.getSig();
        }
        sb.append("]");
        return sb.toString();
    }

    boolean tieneIngrediente(String nombre){
        if(ingrediente_head==null) return false;
        Ingrediente ing = ingrediente_head;
        while (ing!=null) {
            if(ing.getNombre().equals(nombre)) return true;
            ing = ing.getSig();
        }
        return false;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nIngredientes:\n"+Ingredientes();
    }
}
