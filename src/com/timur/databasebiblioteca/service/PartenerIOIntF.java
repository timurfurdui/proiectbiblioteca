package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.Partener;

import java.util.List;

/**
 * @author Timur
 */
public interface PartenerIOIntF {
    void saveToFile(String fileName, List<Partener> listParteneri);

    List<Partener> readFile(String fileName);
}
