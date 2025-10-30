public class ListaPlatillos {
    private Platillo cabecera;

    public ListaPlatillos() {
        this.cabecera = null;
    }

    public boolean ListaVacia(){
        return cabecera == null;
    }

    private static void link(Platillo anterior,Platillo siguiente){
        if(anterior!=null) anterior.setSig(siguiente);
        if(siguiente!=null) siguiente.setAnt(anterior);
    }
    
    public void addPlatillo(String nombre) {
    Platillo nuevo = new Platillo(nombre);

    if (ListaVacia()) {
        cabecera = nuevo;
        return;
    }
    //Si va antes o en la cabecera
    int comparacion = cabecera.getNombre().compareTo(nombre);
    if (comparacion > 0) {
        link(nuevo, cabecera);
        cabecera = nuevo; 
        return;
    }else if (comparacion == 0) {
        return;
    }
    //Buscamos en medio de la lista
    Platillo current = cabecera;
    //El ciclo acaba antes de llegar a nulo
    while (current.getSig() != null) {
        
        comparacion = current.getSig().getNombre().compareTo(nombre);
        
        //Si current va despues que el nodo nuevo
        if (comparacion > 0) {
            link(nuevo, current.getSig());
            link(current, nuevo);
            return;
        //Si se reemplaza el nodo
        } else if (comparacion == 0) {
            return;
        }
        //Si todavia no lo encuentra
        current = current.getSig();
    }
    //Si va hasta el final
    link(current, nuevo);
}

    public void removePlatillo(String nombre){
        if(cabecera == null) return;

        if(cabecera.getNombre().equals(nombre)) {
            cabecera = cabecera.getSig();
            return;
        }
        
        Platillo current = cabecera;
        while(current.getSig()!=null){
            if(current.getNombre().equals(nombre)){
                //Hacer doble enlace
                link(current.getAnt(),current.getSig());
            }
            current = current.getSig();
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
        while(current!=null){
            if(current.getNombre().equals(nombrePlatillo)) {
                current.addIngrediente(ingrediente);
                return;
            }
            
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
        if(ListaVacia()) return "No hay platillos.";
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
        if(ListaVacia()) return "No hay platillos.";
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
