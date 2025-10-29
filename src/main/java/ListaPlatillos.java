public class ListaPlatillos {
    private Platillo cabecera;

    public ListaPlatillos() {
        this.cabecera = null;
    }

    public boolean ListaVacia(){
        return cabecera == null;
    }
    
    public void addPlatillo(String nombre){
        Platillo nuevo = new Platillo(nombre);
        if (ListaVacia()) {
            cabecera = nuevo;
            return;
        }
        
        nuevo.setSig(cabecera);
        if(cabecera != null) cabecera.setAnt(nuevo);
        cabecera = nuevo;
    }

    public void removePlatillo(String nombre){
        if(cabecera == null) return;
        
        Platillo current = cabecera;
        while(current.getSig()!=null){
            if(current.getNombre().equals(nombre)){
                //Hacer doble enlace
                if(current.getAnt()!=null) current.getAnt().setSig(current.getSig());
                if(current.getSig()!=null) current.getSig().setAnt(current.getAnt());
            }
        } 
    }
    

    public String getPlatillo(String nombre){
        if(cabecera==null) return "No hay platillos.";
        Platillo current = cabecera;
        while(current!=null){
            if(current.getNombre().equals(nombre)) return current.toString();

            current = current.getSig();
        }
        return "No se ha encontrado el platillo";
    }

    public void addIngrediente(String nombrePlatillo,Ingrediente ingrediente){
        Platillo current = cabecera;
        while(true){
            if(current.getNombre().equals(nombrePlatillo)) current.addIngrediente(ingrediente);
            
            current = current.getSig();
        }
    }

    public void removeIngrediente(String nombrePlatillo,String nombreIngrediente){  
        if(cabecera==null) return;

        Platillo current = cabecera;
        while(current!=null){
            if(current.getNombre().equals(nombrePlatillo)) {
                current.removeIngrediente(nombreIngrediente);
                return;
            }

            current = current.getSig();
        }
    }

    public String tienenIngrediente(String ingrediente){
        if(ListaVacia()) return "[]";
        StringBuilder sb = new StringBuilder();
        Platillo current = cabecera;
        sb.append('[');
        while(current!=null){
            if(current.tieneIngrediente(ingrediente)){
                sb.append(current.getNombre());
                if(current.getSig()!=null) sb.append(", ");
            }
            current = current.getSig();
        }
        sb.append(']');
        return sb.toString();
    }

    

    @Override
    public String toString(){
        if(ListaVacia()) return "[]";
        StringBuilder sb = new StringBuilder();
        Platillo current = cabecera;
        while(current!=null){
            sb.append(current.toString());
            if(current.getSig()!=null) sb.append("\n");
            current = current.getSig();
        }
        return sb.toString();
    }
    
    
    
    
    
}
