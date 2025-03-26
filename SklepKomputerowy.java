public class SklepKomputerowy {
    // Atrybuty
    private Produkt[] produkty = new Produkt[100]; // Maksymalnie 100 produktów
    private Klient[] klienci = new Klient[50]; // Maksymalnie 50 klientów
    private Zamowienie[] zamowienia = new Zamowienie[100]; // Maksymalnie 100 zamówień

    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;

    // Metoda dodająca produkt do sklepu
    public void dodajProdukt(Produkt produkt) {
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow++] = produkt;
        } else {
            System.out.println("Brak miejsca na nowe produkty.");
        }
    }

    // Metoda dodająca klienta do sklepu
    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow++] = klient;
        } else {
            System.out.println("Brak miejsca na nowych klientów.");
        }
    }

    // Metoda tworząca zamówienie
    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        if (liczbaZamowien < zamowienia.length) {
            Zamowienie zamowienie = new Zamowienie();
            zamowienie.setId(liczbaZamowien + 1);
            zamowienie.setKlient(klient);
            zamowienie.setProdukty(produkty);
            zamowienie.setIlosci(ilosci);
            zamowienie.setDataZamowienia("2024-03-26");
            zamowienie.setStatus("Nowe");
            zamowienia[liczbaZamowien++] = zamowienie;
            return zamowienie;
        } else {
            System.out.println("Brak miejsca na nowe zamówienia.");
            return null;
        }
    }

    // Metoda aktualizująca stan magazynowy
    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] produktyZam = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();
        for (int i = 0; i < produktyZam.length; i++) {
            produktyZam[i].setIloscWMagazynie(produktyZam[i].getIloscWMagazynie() - ilosci[i]);
        }
    }

    // Metoda zmieniająca status zamówienia
    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                break;
            }
        }
    }

    // Metoda wyświetlająca produkty w danej kategorii
    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii: " + kategoria);
        for (int i = 0; i < liczbaProduktow; i++) {
            if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                produkty[i].wyswietlInformacje();
            }
        }
    }

    // Metoda wyświetlająca zamówienia danego klienta
    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta o ID: " + idKlienta);
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getId() == idKlienta) {
                zamowienia[i].wyswietlSzczegoly();
            }
        }
    }
}
