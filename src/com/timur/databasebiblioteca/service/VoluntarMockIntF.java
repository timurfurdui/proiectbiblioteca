package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Voluntar;

import java.util.List;

/**
 * @author User
 */
public interface VoluntarMockIntF {
    public void salveazaVoluntar(Voluntar v);

    public void actualizeazaVoluntar(Voluntar v);

    public void stergeVoluntar(Voluntar v);

    public Voluntar cautare(String numelePrenumele);

    public List<Voluntar> cautaTot();
}
