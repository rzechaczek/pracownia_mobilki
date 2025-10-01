import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int licznik = 0;
        String pierwszaPasujaca = null;

        try {
            Scanner scanner = new Scanner(new File("liczby.txt"));

            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine().trim();

                if (linia.isEmpty()) continue;
                String pierwszaCyfra = linia.substring(0, 1);
                String ostatniaCyfra = linia.substring(linia.length() - 1);

                if (pierwszaCyfra.equals(ostatniaCyfra)) {
                    licznik++;

                    if (pierwszaPasujaca == null) {
                        pierwszaPasujaca = linia;
                    }
                }
            }
            System.out.println("Ilość liczb z taką samą pierwszą i ostatnią cyfrą: " + licznik);
            System.out.println("Pierwsza taka liczba: " + pierwszaPasujaca);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
    }
}
