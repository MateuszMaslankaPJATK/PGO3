public class Zamowienie {
    // Atrybuty
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    // Gettery
    public int getId() {
        return id;
    }

    public Klient getKlient() {
        return klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    // Settery
    public void setId(int id) {
        this.id = id;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Metoda obliczająca łączną wartość zamówienia
    public double obliczWartoscZamowienia() {
        double suma = 0;
        for (int i = 0; i < produkty.length; i++) {
            suma += produkty[i].getCena() * ilosci[i];
        }
        return suma;
    }

    // Metoda wyświetlająca szczegóły zamówienia
    public void wyswietlSzczegoly() {
        System.out.println("ID zamówienia: " + id);
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Data zamówienia: " + dataZamowienia);
        System.out.println("Status: " + status);
        System.out.println("Produkty:");
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("- " + produkty[i].getNazwa() + " x" + ilosci[i] + " - " + produkty[i].getCena() + " zł");
        }
        System.out.println("Łączna wartość: " + obliczWartoscZamowienia() + " zł");
    }

    // Metoda stosująca zniżkę dla stałych klientów
    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            double wartosc = obliczWartoscZamowienia();
            double znizka = wartosc * 0.10;
            double nowaWartosc = wartosc - znizka;
            System.out.println("Zniżka zastosowana: " + znizka + " zł");
            System.out.println("Nowa wartość zamówienia: " + nowaWartosc + " zł");
        }
    }
}