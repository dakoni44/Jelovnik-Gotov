package com.example.termin18_d.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KategorijeProvider {

    public static List<Kategorija> getCategories() {

        List<Kategorija> categories = new ArrayList<>();
        categories.add(new Kategorija(0, "Rose"));
        categories.add(new Kategorija(1, "Citrus"));
        categories.add(new Kategorija(2, "Berry"));
        return categories;
    }

    public static ArrayList<String> getCategoryNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rostilj");
        names.add("Kuvano jelo");
        names.add("Desert");
        return names;
    }

    public static Kategorija getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Kategorija(0, "Rose");
            case 1:
                return new Kategorija(1, "Citrus");
            case 2:
                return new Kategorija(2, "Berry");
            default:
                return null;
        }
    }
}
