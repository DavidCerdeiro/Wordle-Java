import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Wordle{
    public static void main(String[] args){
        //Si el nombre del fichero no es recibido a traves de los argumentos, suponemos que es diccionario.txt
        String nombreFichero = args.length == 0 ? "diccionario.txt": args[0];
        List<String> palabras = new ArrayList<>();
        try{
            palabras = lecturaFichero(nombreFichero);

            if(!palabras.isEmpty()){
                Random random = new Random();
                //Nos aseguramos que el número generado esté dentro del rango de palabras disponibles
                String palabraAleatoria = palabras.get(random.nextInt(palabras.size()));                
                
                
                System.out.println("Palabra aleatoria: " + palabraAleatoria);
            }else{
                System.out.println("El archivo no contiene palabras.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (Exception e) {
            // Captura cualquier otro tipo de excepción y muestra un mensaje genérico
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }

    //Función para leer el fichero y obtener todas las palabras de este
    public static List<String> lecturaFichero(String nombreFichero) throws FileNotFoundException{
        List<String> palabras = new ArrayList<>();

        Scanner scanFile = new Scanner(new File(nombreFichero));
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine().trim();//Por si hay espacios extra en el archivo
            String[] lineaDividida = line.split(" ");

            for (String palabra : lineaDividida) {
                palabras.add(palabra);
            }
        }
        scanFile.close();

        return palabras;
    }
}
