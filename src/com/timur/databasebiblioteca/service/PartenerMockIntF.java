package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Partener;

import java.util.List;

/**
 * @author Timur
 */
public interface PartenerMockIntF {
    public void salveazaPartener(Partener p);

    public void actualizeazaPartener(Partener p);

    public void stergePartener(Partener p);

    public Partener cautare(String numelePartenerului);

    public List<Partener> cautaTot();
}
