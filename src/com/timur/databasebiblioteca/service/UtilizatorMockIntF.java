package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Utilizator;

import java.util.List;

/**
 * @author Timur
 */
public interface UtilizatorMockIntF {
    public void salveazaUtilizator(Utilizator u);

    public void actualizeazaUtilizator(Utilizator u);

    public void stergeUtilizator(Utilizator u);

    public Utilizator cautare(String numPrenumPatr);

    public List<Utilizator> cautaTot();
}
