package Librarie.Raft;

public class Book {
    private String denumire;
    private String autor;
    private String gen;
    private int nrPagini;

    public Book(String denumire, String autor, String gen, int nrPagini) {
        this.denumire = denumire;
        this.autor = autor;
        this.gen = gen;
        this.nrPagini = nrPagini;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getAutor() {
        return autor;
    }

    public String getGen() {
        return gen;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nDate despre carte:\n");

        sb.append(getDenumire()).append(" ")
                .append(getAutor()).append(" ")
                .append(getGen()).append(" ")
                .append(getNrPagini()).append("\n");

        return sb.toString();
    }
}
