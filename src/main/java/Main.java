import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        ListaPlatillos plato=new ListaPlatillos();
        int ops;
        
        do {

            ops=InputInt("""
                Menu
            1.- Agregar platillo.
            2.- Agregar ingredientes.
            3.- Mostrar platillo.
            4.- Mostrar que platillos tienen un ingrediente.
            5.- Eliminar un platillo.
            6.- Mostrar todos los platillos.
            0.- Salir.""");

            switch(ops){

                case 1-> plato.addPlatillo(InputString("Ingresa nombre del platillo: "));

                case 2->{

                    String nombre=InputString("Nombre del platillo en el que se va a ingresar los ingrediente:");

                    int cantidad=InputInt("Introduce cantidad de ingredientes:");
                    int contador=1;
                    do {
                        String nombreingrediente=InputString("Nombre del ingrediente "+contador+":");
                        String cantidadingrediente=InputString("Cantidad del ingrediente "+contador+":");
                        plato.addIngrediente(nombre, new Ingrediente(nombreingrediente,cantidadingrediente));

                        contador++; cantidad--;
                        
                    } while (cantidad!=0);
                    
                }
                
                case 3-> System.out.println(plato.getPlatillo(InputString("Nombre de platillo a buscar:")));

                case 4-> System.out.println(plato.tienenIngrediente(InputString("Introduce nombre de ingrediente:")));

                case 5-> plato.removePlatillo(InputString("Nombre de platillo a eliminar:"));

                case 6-> System.out.println(plato);

                case 0-> System.out.println("Saliendo...");
            }
            
            
            
        } while (ops!=0);
    }


    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida.");
        }
    }

    //metodos que optimizan el uso del scanner
    public static String InputString(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String scanned;
        while (true) {
            System.out.println(mensaje);
            scanned = scanner.nextLine();
            if (!scanned.isEmpty()) break;
            System.out.println("Error, no se permite una entrada vacía. Intente nuevamente.");
            wait(1000);
        }

        return scanned;
    }

    public static int InputInt(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int scanned;
        while (true) {
            try {
                System.out.println(mensaje);
                scanned = scanner.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Error. Caracteres introducidos no válidos. Intente nuevamente.");
                scanner.nextLine();
                wait(1000);
            }
        }
        return scanned;
    }


}
