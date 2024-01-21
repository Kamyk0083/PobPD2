package z1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kalkulator {

    public void oblicz(String plikWejsciowy, String plikWyjsciowy) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(plikWyjsciowy);
            File dane = new File(plikWejsciowy);
            Scanner scanner = new Scanner(dane);

            while (scanner.hasNextLine()) {
                String[] elementy = scanner.nextLine().split(" ");
                int liczba1 = Integer.parseInt(elementy[0]);
                String operacja = elementy[1];
                int liczba2 = Integer.parseInt(elementy[2]);
                int wynik;

                try {
                    switch (operacja) {
                        case "+":
                            wynik = liczba1 + liczba2;
                            break;
                        case "-":
                            wynik = liczba1 - liczba2;
                            break;
                        case "*":
                            wynik = liczba1 * liczba2;
                            break;
                        case "/":
                            if (liczba2 == 0) throw new ArithmeticException("Dzielenie przez zero");
                            wynik = liczba1 / liczba2;
                            break;
                        default:
                            throw new IllegalArgumentException("Nieznana operacja: " + operacja);
                    }
                    writer.println(wynik);
                } catch (ArithmeticException e) {
                    writer.println(e.getMessage());
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            if (writer != null) {
                writer.println("Nie znaleziono pliku: " + plikWejsciowy);
            } else {
                System.out.println("Nie można utworzyć pliku wyjściowego: " + plikWyjsciowy);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
