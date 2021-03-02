package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.FinantatorDonator;

import java.util.List;

/**
 * @author Timur
 */
public interface FinantatorDonatorIOIntF {
    void saveToFile(String fileName, List<FinantatorDonator> listFinantatoriDonatori);

    List<FinantatorDonator> readFile(String fileName);
}
