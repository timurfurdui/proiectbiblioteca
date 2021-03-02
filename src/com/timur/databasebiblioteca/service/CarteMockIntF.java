package com.timur.databasebiblioteca.service;

import java.util.List;

import com.timur.databasebiblioteca.model.Carte;

/**
 * @author User
 */
public interface CarteMockIntF {
    public void salveazaCarte(Carte c);

    public void actualizeazaCarte(Carte c);

    public void stergeCarte(Carte c);

    public Carte cautare(String titlu);

    public List<Carte> cautaTot();
}
