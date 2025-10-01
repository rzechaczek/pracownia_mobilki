import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> liczby = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("liczby.txt"))) {
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine().trim();
                if (!linia.isEmpty()) {
                    liczby.add(Integer.parseInt(linia));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku liczby.txt: " + e.getMessage());
            return;
        }

        int dobreTrojki = 0;
        try (PrintWriter writer = new PrintWriter("trojki.txt")) {
            for (int i = 0; i < liczby.size(); i++) {
                int x = liczby.get(i);
                for (int j = 0; j < liczby.size(); j++) {
                    int y = liczby.get(j);
                    if (x == y) continue;
                    if (y % x != 0) continue;

                    for (int k = 0; k < liczby.size(); k++) {
                        int z = liczby.get(k);
                        if (z == x || z == y) continue;
                        if (z % y == 0) {
                            writer.println(x + " " + y + " " + z);
                            dobreTrojki++;
                        }
                    }
                }
            }

            System.out.println("Liczba dobrych trójek: " + dobreTrojki);

        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu do pliku trojki.txt: " + e.getMessage());
        }
    }
}
