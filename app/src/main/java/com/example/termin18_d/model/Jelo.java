package com.example.termin18_d.model;

import java.util.ArrayList;

public class Jelo {

    private int id;
    private String naziv;
    private ArrayList<String> sastojci;
    private Kategorija opis;
    private double cena;
    private String slika;

    public Jelo() {
    }

    public Jelo(int id, String naziv, ArrayList<String> sastojci, Kategorija opis, double cena, String slika) {
        this.id = id;
        this.naziv = naziv;
        this.sastojci = sastojci;
        this.opis = opis;
        this.cena = cena;
        this.slika = slika;
    }

    public Jelo(Jelo a){
        this.id=a.id;
        this.naziv = a.naziv;
        this.sastojci = a.sastojci;
        this.opis = a.opis;
        this.cena = a.cena;
        this.slika = a.slika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<String> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<String> sastojci) {
        this.sastojci = sastojci;
    }

    public Kategorija getOpis() {
        return opis;
    }

    public void setOpis(Kategorija opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

}
