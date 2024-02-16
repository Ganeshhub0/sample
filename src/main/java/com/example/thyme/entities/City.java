package com.example.thyme.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    private int Cid;
    private String city;

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
