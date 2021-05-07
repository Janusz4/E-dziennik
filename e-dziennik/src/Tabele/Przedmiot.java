package Tabele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "przedmioty")
@Table(name = "przedmioty")
public class Przedmiot implements Serializable {

    private static final long serialVersionUID = -300025L;

    @Column(name = "id_przedmiotu", unique = true)
    @Id
    @GeneratedValue
    private int id_przedmiotu;

    @Column(name = "nazwa")
    private String nazwa;
    
    @OneToMany
    @JoinColumn(name="id_przedmiotu")
    private List<Ocena> ocena;

    public Przedmiot(String nazwa) {
        this.nazwa = nazwa;
    }

    public Przedmiot() {
    }

    public int getId_przedmiotu() {
        return id_przedmiotu;
    }

    public void setId_przedmiotu(int id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }

}
