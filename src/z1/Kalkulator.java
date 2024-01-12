package z1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kalkulator {

    public void oblicz(String plikWejsciowy, String plikWyjsciowy) {
        try {
            File dane = new File(plikWejsciowy);
            PrintWriter writer = new PrintWriter(plikWyjsciowy);
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
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + plikWejsciowy);
        }
    }
}
