package Sarcini;

import Librarie.AdvancedLibrary;
import Librarie.Raft.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sarcina {
    /**
     * getSarcina1 - metoda ce afiseaza lista nr. de telefon ce incepe cu 71
     * @param libraries - campul care reprezinta lista cu bibliotecile prezente
     */
    public void getSarcina1 (List<AdvancedLibrary> libraries) {
        List<AdvancedLibrary> banksTel = libraries.stream()
                .filter(library -> library.getNumarTelefon().startsWith("71"))
                .toList();

        if (banksTel.isEmpty()) {
            System.err.println("Nu s-au gasit astfel de biblioteci!");
        } else {
            banksTel.forEach(System.out::println);
        }
    }

    /**
     * getSarcina2 - metoda ce afiseaza atributele cartii / lor cu nr. pagini max
     * @param libraries - campul care reprezinta lista cu bibliotecile prezente
     */
    public void getSarcina2 (List<AdvancedLibrary> libraries) {
        for (AdvancedLibrary library : libraries) {
            library.getCarti().stream().max(Comparator.comparing(Book::getNrPagini))
                    .ifPresent(System.out::println);
        }
    }

    /**
     * getSarcina3 - metoda ce afiseaza nr. si datele bibliotecilor cu nr. de etaje de la tastatura
     * @param libraries
     * @param nrEtaj
     */
    public void getSarcina3 (List<AdvancedLibrary> libraries, int nrEtaj) {
        List<AdvancedLibrary> librariesEtaj = libraries.stream()
                .filter(library -> library.getNrEtaje() == nrEtaj)
                .toList();

        if (librariesEtaj.isEmpty()) {
            System.err.println("Nu s-au gasit librarii cu nr. de etaje respective!");
        } else {
            System.out.println("Nr. de librarii: " + librariesEtaj.size());
            librariesEtaj.forEach(System.out::println);
        }
    }

    /**
     * getSarcina4 - metoda ce importa lista de biblioteci
     * @param libraries - campul care reprezinta lista cu bibliotecile prezente
     */
    public void getSarcina4 (List<AdvancedLibrary> libraries) {
        try (BufferedReader br = new BufferedReader(new FileReader("biblioteciImport.txt"))) {
            String currentLine;

            while((currentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(currentLine, ",");
                List<Book> books = new ArrayList<>();

                books.add(new Book(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));

                while (st.hasMoreTokens()) {
                    libraries.add(new AdvancedLibrary(st.nextToken(), st.nextToken(), books, st.nextToken(), Integer.parseInt(st.nextToken())));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Lista tuturor bibliotecilor:");
        libraries.forEach(System.out::println);
    }

    /**
     * getSarcina5 - metoda ce exporta lista denumirilor de carti cu nr. max de pagini
     * @param libraries - campul care reprezinta lista cu bibliotecile prezente
     */
    public void getSarcina5 (List<AdvancedLibrary> libraries) {
        try (FileWriter fw = new FileWriter("cartiExport.txt", false)) {
            for (AdvancedLibrary library : libraries) {
                fw.write(Collections.max(library.getCarti(), Comparator.comparing(Book::getNrPagini)) +"\n");
            }

            System.out.println("Introducerea a fost realizata cu succes!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
