package krawczyk;

import java.util.ArrayList;
import java.util.List;

class Administrator extends Osoba {
    private List<Mieszkaniec> mieszkancy;

    public Administrator(String imie, String nazwisko, String login, String haslo) {
        super(imie, nazwisko, login, haslo);
        this.mieszkancy = new ArrayList<>();
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
            if (mieszkaniec.getLogin().equals(login)) {
                mieszkancy.remove(mieszkaniec);
                System.out.println("Usunięto mieszkańca: " + login);
                return;
            }
        }
        throw new Exception("Mieszkaniec o podanym loginie nie istnieje.");
    }
}