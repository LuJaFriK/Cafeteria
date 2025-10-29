public class ListaPlatillos {
    private Platillo cabecera;

    public ListaPlatillos() {
        this.cabecera = null;
    }
    
    public boolean ListaVacia(){
    return cabecera == null;
    }
    
    public void IngresarPlatillo(String nombre){
        Platillo nuevo = new Platillo(nombre);
        if (ListaVacia()) {
            cabecera = nuevo;
        }
        else{
        cabecera.setSig(nuevo);
        nuevo.setAnt(cabecera);
        cabecera = nuevo;
        }
    }
    public void ingresarIngrediente(){
        do {
            Ingrediente ingr = new Ingrediente("","");
            if (cabecera.getIngrediente_head()==null) {
                cabecera.setIngrediente_head(ingr);
            }
            else{
                ingr.setSig(cabecera.getIngrediente_head());
                cabecera.setIngrediente_head(ingr);
            }
        } while (true);
        
        
        
    }
    
    
    
    
    
}
