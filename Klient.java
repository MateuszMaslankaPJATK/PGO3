public class Klient {
    // Atrybuty
    private int id;
    private String imie;
    private String nazwisko;
    private String email;
    private boolean czyStaly;

    // Gettery
    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public boolean isCzyStaly() {
        return czyStaly;
    }

    // Settery
    public void setId(int id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCzyStaly(boolean czyStaly) {
        this.czyStaly = czyStaly;
    }

    // Metoda wyświetlająca informacje o kliencie
    public void wyswietlInformacje() {
        System.out.println("ID: " + id);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("E-mail: " + email);
        System.out.println("Stały klient: " + (czyStaly ? "Tak (10% zniżki)" : "Nie"));
    }
}
