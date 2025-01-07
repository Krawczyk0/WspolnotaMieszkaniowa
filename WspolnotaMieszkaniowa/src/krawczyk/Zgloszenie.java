package krawczyk;

class Zgloszenie {
    private String opis;
    private String status;

    public Zgloszenie(String opis) {
        this.opis = opis;
        this.status = "Nowe";
    }

    public void zmienStatus(String status) {
        this.status = status;
    }

    public void wyswietlZgloszenie() {
        System.out.println("Opis: " + opis + ", Status: " + status);
    }
}