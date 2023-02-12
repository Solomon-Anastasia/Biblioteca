package Librarie;

import Librarie.Raft.Book;

import java.util.List;

public class Library {
    private String adresa;
    private String numarTelefon;
    private List<Book> carti;

    public Library(String adresa, String numarTelefon, List<Book> carti) {
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.carti = carti;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public List<Book> getCarti() {
        return carti;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getAdresa()).append(" ")
                .append(getNumarTelefon()).append(" ");

        for (Book book : carti) {
            sb.append(book.toString());
        }

        return sb.toString();
    }
}
