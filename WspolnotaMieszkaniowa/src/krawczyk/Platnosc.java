package krawczyk;

class Platnosc {
    private double kwota;
    private String data;
    private boolean uregulowana;

    public Platnosc(double kwota, String data, boolean uregulowana) {
        this.kwota = kwota;
        this.data = data;
        this.uregulowana = uregulowana;
    }

    public void wyswietlPlatnosc() {
        System.out.println("Kwota: " + kwota + ", Data: " + data + ", Uregulowana: " + (uregulowana ? "Tak" : "Nie"));
    }
}
