package com.timur.databasebiblioteca.service;

import java.util.List;

import com.timur.databasebiblioteca.model.Carte;

/**
 * @author Timur
 */
public interface CarteIOIntF {
    void saveToFile(String fileName, List<Carte> listCarti);

    List<Carte> readFile(String fileName);
}
