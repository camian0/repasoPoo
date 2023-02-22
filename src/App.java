import java.io.IOException;
import java.util.Scanner;

import model.ProcessFile;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Ingresa la ruta de la carpeta: ");
            String path = scanner.nextLine();

            ProcessFile process = new ProcessFile();
            process.processFile(path, "arar");

            System.out.println(process.getResults());

        } catch (IOException e) {
            System.out.println("Por favor verifica la ruta ingresada: " + e.getMessage());
        }
    }
}
