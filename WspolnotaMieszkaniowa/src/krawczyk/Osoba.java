package krawczyk;

abstract class Osoba implements Uzytkownik {
    protected String imie;
    protected String nazwisko;
    protected String login;
    protected String haslo;

    public Osoba(String imie, String nazwisko, String login, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
    }

    public boolean zaloguj(String login, String haslo) {
        return this.login.equals(login) && this.haslo.equals(haslo);
    }
}


