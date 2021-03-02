package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Angajat;

import java.util.List;

/**
 * @author Timur
 */
public interface AngajatOIntF {
    void saveToFile(String fileName, List<Angajat> listAngajati);

    List<Angajat> readFile(String fileName);
}
