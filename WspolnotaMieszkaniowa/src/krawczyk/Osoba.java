package krawczyk;

abstract class Osoba {
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

    public String getLogin() {
        return login;
    }

    public boolean sprawdzHaslo(String haslo) {
        return this.haslo.equals(haslo);
    }
}

