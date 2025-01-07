package krawczyk;

import java.util.ArrayList;
import java.util.List;

class Mieszkaniec extends Osoba {
    private double oplataMiesieczna;
    private List<Platnosc> historiaPlatnosci;
    private List<Zgloszenie> zgloszenia;

    public Mieszkaniec(String imie, String nazwisko, String login, String haslo, double oplataMiesieczna) {
        super(imie, nazwisko, login, haslo);
        this.oplataMiesieczna = oplataMiesieczna;
        this.historiaPlatnosci = new ArrayList<>();
        this.zgloszenia = new ArrayList<>();
    }

    public double getOplataMiesieczna() {
        return oplataMiesieczna;
    }

    public void dodajPlatnosc(Platnosc platnosc) {
        historiaPlatnosci.add(platnosc);
    }

    public void wyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Opłata miesięczna: " + oplataMiesieczna);
    }

    public void wyswietlPlatnosci() {
        System.out.println("Historia płatności:");
        for (Platnosc platnosc : historiaPlatnosci) {
            platnosc.wyswietlPlatnosc();
        }
    }

    public void zglosUsterke(String opis) {
        zgloszenia.add(new Zgloszenie(opis));
        System.out.println("Zgłoszono usterkę: " + opis);
    }

    @Override
    public void wyswietlMenu() {
        System.out.println("Menu mieszkańca:");
        System.out.println("1. Wyświetl informacje");
        System.out.println("2. Wyświetl historię płatności");
        System.out.println("3. Zgłoś usterkę");
        System.out.println("4. Wyloguj");
    }
}
