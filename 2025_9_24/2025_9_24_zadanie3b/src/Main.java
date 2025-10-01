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
        int dobrePiatki = 0;
        int n = liczby.size();
        for (int i = 0; i < n; i++) {
            int x = liczby.get(i);
            for (int j = 0; j < n; j++) {
                int y = liczby.get(j);
                if (y == x || y % x != 0) continue;

                for (int k = 0; k < n; k++) {
                    int z = liczby.get(k);
                    if (z == x || z == y || z % y != 0) continue;

                    for (int l = 0; l < n; l++) {
                        int w = liczby.get(l);
                        if (w == x || w == y || w == z || w % z != 0) continue;

                        for (int m = 0; m < n; m++) {
                            int v = liczby.get(m);
                            if (v == x || v == y || v == z || v == w || v % w != 0) continue;
                            dobrePiatki++;
                        }
                    }
                }
            }
        }

        System.out.println("Liczba dobrych piątek: " + dobrePiatki);
    }
}
