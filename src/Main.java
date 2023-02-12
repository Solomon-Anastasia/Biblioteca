import Librarie.AdvancedLibrary;
import Librarie.Raft.Book;
import Sarcini.Sarcina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Sarcina sarcina = new Sarcina();

        List<Book> books = new ArrayList<>(List.of(
                new Book("Carte1", "Mihai Eminescu", "Romantica", 200),
                new Book("Carte2", "Mihai Eminescu", "Romantica", 300),
                new Book("Carte3", "Mihai Eminescu", "Romantica", 400),
                new Book("Carte4", "Mihai Eminescu", "Romantica", 500)

        ));

        List<AdvancedLibrary> libraries = new ArrayList<>(List.of(
                new AdvancedLibrary("Chisinau", "71564743", books, "Biblioteca1", 2),
                new AdvancedLibrary("Chisinau", "74464743", books, "Biblioteca2", 4),
                new AdvancedLibrary("Chisinau", "76564743", books, "Biblioteca3", 6),
                new AdvancedLibrary("Chisinau", "71564743", books, "Biblioteca4", 1),
                new AdvancedLibrary("Chisinau", "71364743", books, "Biblioteca5", 2)
        ));

        getMeniu();

        System.out.print("\nIntroduceti tasta: ");
        int nrSarcina;
        do {
            nrSarcina = Integer.parseInt(input.readLine());
            System.out.println();
            switch (nrSarcina) {
                case 1 -> {
                    System.out.println("Lista nr. de telefon ce incepe cu 71\n");
                    sarcina.getSarcina1(libraries);
                }
                case 2 -> {
                    System.out.println("Atributele cartii / lor cu nr. pagini max\n");
                    sarcina.getSarcina2(libraries);
                }
                case 3 -> {
                    System.out.println("Nr. si datele bibliotecilor cu nr. de etaje de la tastatura\n");
                    System.out.print("Introduceti nr. etajului dorit: ");
                    sarcina.getSarcina3(libraries, Integer.parseInt(input.readLine()));
                }
                case 4 -> {
                    System.out.println("Importa lista de biblioteci\n");
                    sarcina.getSarcina4(libraries);
                }
                case 5 -> {
                    System.out.println("Exporta lista denumirilor de carti cu nr. max de pagini\n");
                    sarcina.getSarcina5(libraries);
                }
                case 0 -> System.out.println("La revedere!");

                default -> System.out.println("Eroare de introducere!");
            }
        } while(nrSarcina != 0);
    }

    /**
     * getMeniu - metoda ce afiseaza meniul principal al programului
     */
    public static void getMeniu() {
        System.out.println("0 - Iesire");
        System.out.println("1 - Lista nr. de telefon ce incepe cu 71");
        System.out.println("2 - Atributele cartii / lor cu nr. pagini max");
        System.out.println("3 - Nr. si datele bibliotecilor cu nr. de etaje de la tastatura");
        System.out.println("4 - Importa lista de biblioteci");
        System.out.println("5 - Exporta lista denumirilor de carti cu nr. max de pagini");
    }
}