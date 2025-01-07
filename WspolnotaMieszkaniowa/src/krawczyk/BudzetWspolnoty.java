package krawczyk;

class BudzetWspolnoty {
    private double przychody;
    private double wydatki;

    public void dodajPrzychod(double kwota) {
        przychody += kwota;
    }

    public void dodajWydatek(double kwota) {
        wydatki += kwota;
    }

    public void wyswietlRaport() {
        System.out.println("Raport budżetu:");
        System.out.println("Przychody: " + przychody);
        System.out.println("Wydatki: " + wydatki);
        System.out.println("Bilans: " + (przychody - wydatki));
    }
}
