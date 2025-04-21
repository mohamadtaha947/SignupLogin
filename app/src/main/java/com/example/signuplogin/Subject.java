package com.example.signuplogin;

import java.util.List;

public class Subject {
    private String name;
    private String form;
    private List<Bagrut> bagrutList;

    public Subject() {
        // Firestore constructor
    }

    public Subject(String name, String form, List<Bagrut> bagrutList) {
        this.name = name;
        this.form = form;
        this.bagrutList = bagrutList;
    }

    public String getName() { return name; }
    public String getForm() { return form; }
    public List<Bagrut> getBagrutList() { return bagrutList; }

    public void setName(String name) { this.name = name; }
    public void setForm(String form) { this.form = form; }
    public void setBagrutList(List<Bagrut> bagrutList) { this.bagrutList =bagrutList;}
}
