package com.example.termin18_d.model;

import java.util.ArrayList;

public class JeloProvider {

    public static ArrayList<Jelo> getJela(){
        ArrayList<String> sastojciPljeskavica = new ArrayList<>();
        sastojciPljeskavica.add("Svinjetina");
        sastojciPljeskavica.add("Lepinja");
        sastojciPljeskavica.add("Pomfrit");

        ArrayList<String> sastojciGulas = new ArrayList<>();
        sastojciGulas.add("Junetina");
        sastojciGulas.add("Pire");
        sastojciGulas.add("Paprika");
        sastojciGulas.add("Sos");

        ArrayList<String> sastojciPalacinka = new ArrayList<>();
        sastojciPalacinka.add("Dzem");
        sastojciPalacinka.add("Voce");

        Kategorija k1=new Kategorija(0,"Rostilj");
        Kategorija k2=new Kategorija(1,"Kuvano jelo");
        Kategorija k3=new Kategorija(2,"Desert");

        ArrayList jela=new ArrayList<Jelo>();
        jela.add(new Jelo(0, "Pljeskavica", sastojciPljeskavica, k1, 200, "pljeskavica.jpg"));
        jela.add(new Jelo(1, "Gulas", sastojciGulas, k2, 300, "gulas.jpg"));
        jela.add(new Jelo(2, "Palacinka", sastojciPalacinka,k3, 150, "palacinka.jpg"));
        return jela;
    }



    public static Jelo getJeloById(int id){
        ArrayList<String> sastojciPljeskavica = new ArrayList<>();
        sastojciPljeskavica.add("Svinjetina");
        sastojciPljeskavica.add("Lepinja");
        sastojciPljeskavica.add("Pomfrit");

        ArrayList<String> sastojciGulas = new ArrayList<>();
        sastojciGulas.add("Junetina");
        sastojciGulas.add("Pire");
        sastojciGulas.add("Paprika");
        sastojciGulas.add("Sos");

        ArrayList<String> sastojciPalacinka = new ArrayList<>();
        sastojciPalacinka.add("Dzem");
        sastojciPalacinka.add("Voce");

        Kategorija k1=new Kategorija(0,"Rostilj");
        Kategorija k2=new Kategorija(1,"Kuvano jelo");
        Kategorija k3=new Kategorija(2,"Desert");

        switch (id){
            case 0:
                return new Jelo(0, "Pljeskavica", sastojciPljeskavica, k1, 200, "pljeskavica.jpg");
            case 1:
                return new Jelo(1, "Gulas", sastojciGulas, k2, 300, "gulas.jpg");
            case 2:
                return new Jelo(2, "Palacinka", sastojciPalacinka, k3, 150, "palacinka.jpg");
            default:
                return null;
        }
    }

}
