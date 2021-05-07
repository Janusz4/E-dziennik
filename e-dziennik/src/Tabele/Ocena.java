package Tabele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "oceny")
@Table(name = "oceny")
public class Ocena {

    @Column(name = "id_oceny", unique = true)
    @Id
    @GeneratedValue
    private int id_oceny;

    @Column(name = "id_przedmiotu")
    private int id_przedmiotu;

    @Column(name = "id_ucznia")
    private int id_ucznia;

    @Column(name = "data")
    private Date data;

    @Column(name = "ocena")
    private int ocena;

    public Ocena() {
    }

    public Ocena(int id_przedmiotu, int id_ucznia, Date data, int ocena) {
        this.id_przedmiotu = id_przedmiotu;
        this.id_ucznia = id_ucznia;
        this.data = data;
        this.ocena = ocena;
    }

    public int getId_oceny() {
        return id_oceny;
    }

    public void setId_oceny(int id_oceny) {
        this.id_oceny = id_oceny;
    }

    public int getId_przedmiotu() {
        return id_przedmiotu;
    }

    public void setId_przedmiotu(int id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public int getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(int id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Ocena{" + "id_oceny=" + id_oceny + ", id_przedmiotu=" + id_przedmiotu + ", id_ucznia=" + id_ucznia + ", data=" + data + ", ocena=" + ocena + '}';
    }

}
