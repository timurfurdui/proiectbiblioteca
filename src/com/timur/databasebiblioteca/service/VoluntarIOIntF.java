package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Voluntar;

import java.util.List;

/**
 * @author Timur
 */
public interface VoluntarIOIntF {
    void saveToFile(String fileName, List<Voluntar> listVoluntari);

    List<Voluntar> readFile(String fileName);
}
