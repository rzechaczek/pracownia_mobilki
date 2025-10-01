import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int maxLiczbaCzynnikow = 0;
        int liczbaNajwiecejCzynnikow = 0;

        int maxLiczbaRoznychCzynnikow = 0;
        int liczbaNajwiecejRoznychCzynnikow = 0;

        try {
            Scanner scanner = new Scanner(new File("liczby.txt"));

            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine().trim();
                if (linia.isEmpty()) continue;

                int liczba = Integer.parseInt(linia);

                List<Integer> czynniki = rozkladNaCzynnikiPierwsze(liczba);
                Set<Integer> rozneCzynniki = new HashSet<>(czynniki);

                if (czynniki.size() > maxLiczbaCzynnikow) {
                    maxLiczbaCzynnikow = czynniki.size();
                    liczbaNajwiecejCzynnikow = liczba;
                }

                if (rozneCzynniki.size() > maxLiczbaRoznychCzynnikow) {
                    maxLiczbaRoznychCzynnikow = rozneCzynniki.size();
                    liczbaNajwiecejRoznychCzynnikow = liczba;
                }
            }

            scanner.close();

            // Wyniki
            System.out.println("Liczba z największą liczbą czynników pierwszych: " + liczbaNajwiecejCzynnikow);
            System.out.println("Liczba czynników: " + maxLiczbaCzynnikow);

            System.out.println("Liczba z największą liczbą różnych czynników pierwszych: " + liczbaNajwiecejRoznychCzynnikow);
            System.out.println("Liczba różnych czynników: " + maxLiczbaRoznychCzynnikow);

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + e.getMessage());
        }
    }

    
    public static List<Integer> rozkladNaCzynnikiPierwsze(int n) {
        List<Integer> czynniki = new ArrayList<>();
        int dzielnik = 2;

        while (n > 1) {
            while (n % dzielnik == 0) {
                czynniki.add(dzielnik);
                n /= dzielnik;
            }
            dzielnik++;
            if (dzielnik * dzielnik > n && n > 1) {
                czynniki.add(n);
                break;
            }
        }

        return czynniki;
    }
}
