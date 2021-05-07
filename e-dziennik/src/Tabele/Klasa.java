/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@Entity(name = "klasy")
@Table(name = "klasy")
public class Klasa {
    
    @Column(name = "id_klasy", unique = true)
    @Id
    @GeneratedValue
    private int id_klasy;

    @Column(name = "nazwa")
    private String nazwa;
    
    @Column(name = "id_rocznika")
    private int id_rocznika;
    
    @OneToMany
    @JoinColumn(name="id_klasy")
    private List<Uczen> uczen;

    public Klasa(String nazwa, int id_rocznika) {
        this.nazwa = nazwa;
        this.id_rocznika = id_rocznika;
    }

    public Klasa() {
    }

    public int getId_klasy() {
        return id_klasy;
    }

    public void setId_klasy(int id_klasy) {
        this.id_klasy = id_klasy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId_rocznika() {
        return id_rocznika;
    }

    public void setId_rocznika(int id_rocznika) {
        this.id_rocznika = id_rocznika;
    }

    @Override
    public String toString() {
        return nazwa;
    }
    
    
    
}
