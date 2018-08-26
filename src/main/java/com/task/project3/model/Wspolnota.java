package com.task.project3.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wspolnota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String adres;

    @OneToMany(mappedBy = "wspolnota", cascade = CascadeType.REMOVE)
    private List<Mieszkanie> mieszkanieList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Mieszkanie> getMieszkanieList() {
        return mieszkanieList;
    }

    public void setMieszkanieList(List<Mieszkanie> mieszkanieList) {
        this.mieszkanieList = mieszkanieList;
    }
}
