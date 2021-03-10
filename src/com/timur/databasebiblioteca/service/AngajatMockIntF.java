package com.timur.databasebiblioteca.service;

import java.util.List;

import com.timur.databasebiblioteca.model.Angajat;

/**
 * @author Timur
 */
public interface AngajatMockIntF {
    public void salveazaAngajat(Angajat a);

    public void actualizeazaAngajat(Angajat a);

    public void stergeAngajat(Angajat a);

    public Angajat cautare(String numelePrenumele);

    public List<Angajat> cautaTot();
}
