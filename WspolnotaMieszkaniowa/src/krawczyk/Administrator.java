package krawczyk;

import java.util.ArrayList;
import java.util.List;

class Administrator extends Osoba {
    List<Mieszkaniec> mieszkancy;
    private BudzetWspolnoty budzet;

    public Administrator(String imie, String nazwisko, String login, String haslo) {
        super(imie, nazwisko, login, haslo);
        this.mieszkancy = new ArrayList<>();
        this.budzet = new BudzetWspolnoty();
    }

    public void dodajMieszkanca(Mieszkaniec mieszkaniec) {
        mieszkancy.add(mieszkaniec);
    }

    public void wyswietlListeMieszkancow() {
        System.out.println("Lista mieszkańców:");
        for (Mieszkaniec mieszkaniec : mieszkancy) {
            System.out.println(mieszkaniec.imie + " " + mieszkaniec.nazwisko + ", Opłata: " + mieszkaniec.getOplataMiesieczna());
        }
    }

    public void usunMieszkanca(String login) throws Exception {
        for (Mieszkaniec mieszkaniec : mieszkancy) {
            if (mieszkaniec.zaloguj(login, mieszkaniec.haslo)) {
                mieszkancy.remove(mieszkaniec);
                System.out.println("Usunięto mieszkańca: " + login);
                return;
            }
        }
        throw new Exception("Mieszkaniec o podanym loginie nie istnieje.");
    }

    public void zarzadzajBudzetem() {
        budzet.wyswietlRaport();
        System.out.print("Dodaj przychód (podaj kwotę lub 0 aby pominąć): ");
        double przychod = WspolnotaMieszkaniowa.scanner.nextDouble();
        if (przychod > 0) {
            budzet.dodajPrzychod(przychod);
            System.out.println("Dodano przychód: " + przychod);
        }

        System.out.print("Dodaj wydatek (podaj kwotę lub 0 aby pominąć): ");
        double wydatek = WspolnotaMieszkaniowa.scanner.nextDouble();
        if (wydatek > 0) {
            budzet.dodajWydatek(wydatek);
            System.out.println("Dodano wydatek: " + wydatek);
        }

        System.out.println("Zaktualizowano budżet.");
    }

    @Override
    public void wyswietlMenu() {
        System.out.println("Menu administratora:");
        System.out.println("1. Wyświetl listę mieszkańców");
        System.out.println("2. Dodaj mieszkańca");
        System.out.println("3. Usuń mieszkańca");
        System.out.println("4. Zarządzaj budżetem");
        System.out.println("5. Wyloguj");
    }
}
