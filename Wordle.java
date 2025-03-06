import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Wordle{
    //Constante con número máximo de intentos
    private static final int MAXINTENTOS = 5;
    public static void main(String[] args){
        //Si el nombre del fichero no es recibido a traves de los argumentos, suponemos que es diccionario.txt
        String nombreFichero = args.length == 0 ? "diccionario.txt": args[0];
        List<String> palabras = new ArrayList<>();
        try{
            palabras = lecturaFichero(nombreFichero);

            if(!palabras.isEmpty()){
                Random random;
                Scanner scanner = new Scanner(System.in);
                int longPal;         
                int numIntentos;
                int continuar;
                boolean acierto;
                boolean otraPartida = true;
                String palIntroducida;
                String resuelto;
                //Presentación del juego
                System.out.println("¡Bienvenido a Wordle!");
                System.out.println("En esta humilde imitación del famoso juego, tendrás 5 oportunidades para adivinar la palabra.");
                System.out.println("He aquí un ejemplo práctico del funcionamiento:");
                System.out.println("Si la palabra a resolver es COSA y se introduce POCA, el resultado sería el siguiente: _O*A\n");
                System.out.println("-Si la letra introducida es correcta y se encuentra en su posición, se mostrará tal cual.\n");
                System.out.println("-Si la letra introducida es correcta pero no su posición, se mostrará el símbolo *.\n");
                System.out.println("-Si la letra introducida no se encuentra en la palabra a resolver se mostrará _.\n");
                System.out.println("***¡COMENCEMOS!***");
                while(otraPartida){
                    random = new Random();
                    //Nos aseguramos que el número generado esté dentro del rango de palabras disponibles
                    String palabraAdivinar = palabras.get(random.nextInt(palabras.size()));
                    resuelto = "";
                    longPal = palabraAdivinar.length();
                    numIntentos = MAXINTENTOS;
                    acierto = false;
                    //Al principio obviamente la cadena resuelto estará vacía, es decir, rellena de _
                    for(int i = 0; i<longPal; i++){
                        resuelto += "_";
                    }                
                    while(!acierto && numIntentos!=0){
                        System.out.println("Número de intentos restantes: "+numIntentos);
                        System.out.println("Resolución: " + resuelto);
                        //Nos aseguramos que la palabra introducida sea de la misma longitud que la palabra a adivinar
                        do{
                            System.out.println("Introduzca por favor, una palabra de "+longPal + " caracteres, en caso contrario, se le volverá a solicitar.");
                            palIntroducida = scanner.nextLine();
                        }while(palIntroducida.length() != longPal);
                        //Si la palabra es correcta, salimos del bucle, si no, comprobamos los aciertos y seguimos
                        if(palabraAdivinar.equals(palIntroducida)){
                            acierto = true;
                        }else{
                            numIntentos--;
                            resuelto = comprobarAciertos(palIntroducida, palabraAdivinar, longPal);
                        }
                    }
                    System.out.println(acierto ?"***¡FELICIDADES, HAS GANADO!***" : "***NO LO HAS PODIDO ACERTAR :(*** /n La palabra correcta era: "+palabraAdivinar);
                    System.out.println("¿Deseas realizar otra partida?");
                    System.out.println("**Introduzca 1 para continuar.");
                    System.out.println("*En caso contrario, cualquier otro número.");
                    continuar = scanner.nextInt();
                    if(continuar != 1) otraPartida = false;
                }
                
               
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

    //Función para comprobar los aciertos y errores de la palabra introducida respecto a la que se busca adivinar
    public static String comprobarAciertos(String palIntroducida, String palabraAdivinar, int longPal){
        String aciertos = "";
        for(int i = 0; i<longPal; i++){
            if(palIntroducida.charAt(i) == palabraAdivinar.charAt(i)){
                aciertos += palIntroducida.charAt(i);
            }else if(palabraAdivinar.indexOf(palIntroducida.charAt(i)) != -1){
                aciertos += "*";
            }else{
                aciertos += "_";
            }
        }

        return aciertos;
    }
}
