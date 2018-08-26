package com.task.project3.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mieszkanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numer;
    private double powierzchnia;

    @ManyToOne
    private Wspolnota wspolnota;

    @OneToMany(mappedBy = "mieszkanie", cascade = CascadeType.REMOVE)
    private List<Mieszkaniec> mieszkaniecList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public List<Mieszkaniec> getMieszkaniecList() {
        return mieszkaniecList;
    }

    public void setMieszkaniecList(List<Mieszkaniec> mieszkaniecList) {
        this.mieszkaniecList = mieszkaniecList;
    }

    public Wspolnota getWspolnota() {
        return wspolnota;
    }

    public void setWspolnota(Wspolnota wspolnota) {
        this.wspolnota = wspolnota;
    }
}
