package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Utilizator;

import java.util.List;

/**
 * @author Timur
 */
public interface UtilizatorIOIntF {
    void saveToFile(String fileName, List<Utilizator> listUtilizatori);

    List<Utilizator> readFile(String fileName);
}
