package com.timur.databasebiblioteca.service;

import com.timur.databasebiblioteca.model.FinantatorDonator;

import java.util.List;

/**
 * @author Timur
 */
public interface FinantatorDonatorMockIntF {
    public void salveazaFinantatorDonator(FinantatorDonator fd);

    public void actualizeazaFinantatorDonator(FinantatorDonator fd);

    public void stergeFinantatorDonator(FinantatorDonator fd);

    public FinantatorDonator cautare(String numeOrgPers);

    public List<FinantatorDonator> cautaTot();
}
