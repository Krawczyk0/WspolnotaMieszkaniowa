package krawczyk;

class Mieszkaniec extends Osoba {
    private double oplataMiesieczna;

    public Mieszkaniec(String imie, String nazwisko, String login, String haslo, double oplataMiesieczna) {
        super(imie, nazwisko, login, haslo);
        this.oplataMiesieczna = oplataMiesieczna;
    }

    public double getOplataMiesieczna() {
        return oplataMiesieczna;
    }

    public void wyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Opłata miesięczna: " + oplataMiesieczna);
    }
}
