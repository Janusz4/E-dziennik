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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "roczniki")
@Table(name = "roczniki")
public class Rocznik {
    
    @Column(name = "id_rocznika", unique = true)
    @Id
    @GeneratedValue
    private int id_rocznika;

    @Column(name = "rok")
    private String rok;
    
    @OneToMany
    @JoinColumn(name="id_rocznika")
    private List<Klasa> klasa;

    public Rocznik(String rok) {
        this.rok = rok;
    }

    public Rocznik() {
    }

    public int getId_rocznika() {
        return id_rocznika;
    }

    public void setId_rocznika(int id_rocznika) {
        this.id_rocznika = id_rocznika;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    @Override
    public String toString() {
        return rok;
    }
    
}
