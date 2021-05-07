
package Tabele;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "uczniowie")
@Table(name = "uczniowie")

public class Uczen {
    
    private static final long serialVersionUID = -300025L;

    @Column(name = "id_ucznia", unique = true)
    @Id
    @GeneratedValue
    private int id_ucznia;

    @Column(name = "imie")
    private String imie;
    
    @Column(name = "nazwisko")
    private String nazwisko;
    
    @Column(name = "pesel")
    private String pesel;
    
    @Column(name = "id_klasy")
    private int id_klasy;
    
    @Column(name = "adres")
    private String adres;
    
    @Column(name = "nr_telefonu")
    private String nr_telefonu;
          
    @OneToMany
    @JoinColumn(name="id_ucznia")
    private List<Ocena> ocena;

    public Uczen(String imie, String nazwisko, String pesel, int id_klasy, String adres, String nr_telefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.id_klasy = id_klasy;
        this.adres = adres;
        this.nr_telefonu = nr_telefonu;
    }
    
    public Uczen(){
        
    }

    public int getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(int id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getId_klasy() {
        return id_klasy;
    }

    public void setId_klasy(int id_klasy) {
        this.id_klasy = id_klasy;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    @Override
    public String toString() {
        return "imie: " + imie + ", nazwisko: " + nazwisko + ", pesel: " + pesel + ", adres: " + adres;
    }
    
    
}
