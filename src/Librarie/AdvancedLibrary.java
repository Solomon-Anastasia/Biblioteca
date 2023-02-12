package Librarie;

import Librarie.Raft.Book;

import java.util.List;

public class AdvancedLibrary extends Library {
    private String denumire;
    private int nrEtaje;

    public AdvancedLibrary(String adresa, String numarTelefon, List<Book> carti, String denumire, int nrEtaje) {
        super(adresa, numarTelefon, carti);
        this.denumire = denumire;
        this.nrEtaje = nrEtaje;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNrEtaje() {
        return nrEtaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Date despre biblioteca:\n");

        sb.append(super.toString())
                .append(getDenumire()).append(" ")
                .append(getNrEtaje()).append("\n");

        return sb.toString();
    }
}
