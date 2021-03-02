package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.FinantatorDonator;
import com.timur.databasebiblioteca.service.FinantatorDonatorMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
public class FinantatorDonatorMockImpl implements FinantatorDonatorMockIntF {
    List<FinantatorDonator> listaFinantatoriDonatori;

    public FinantatorDonatorMockImpl() {
        this.listaFinantatoriDonatori = new ArrayList<>();
    }

    public FinantatorDonatorMockImpl(List<FinantatorDonator> listaFinantatoriDonatori) {
        this.listaFinantatoriDonatori = listaFinantatoriDonatori;
    }


    @Override
    public void salveazaFinantatorDonator(FinantatorDonator fd) {
        listaFinantatoriDonatori.add(fd);
    }

    @Override
    public void actualizeazaFinantatorDonator(FinantatorDonator fd) {
        for (int i = 0; i < listaFinantatoriDonatori.size(); i++) {
            int idCautat = fd.getNrDeInregistrare();
            ;
            int idDinLista = listaFinantatoriDonatori.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaFinantatoriDonatori.set(i, fd);
                break;
            }
        }
    }

    @Override
    public void stergeFinantatorDonator(FinantatorDonator fd) {
        for (int i = 0; i < listaFinantatoriDonatori.size(); i++) {
            String numeOrgPers = fd.getNumeOrgPers();
            String numeDinOrgPers = listaFinantatoriDonatori.get(i).getNumeOrgPers();
            if (numeOrgPers.equals(numeDinOrgPers)) {
                listaFinantatoriDonatori.remove(i);
                break;
            }
        }
    }

    @Override
    public FinantatorDonator cautare(String numeOrgPers) {
        FinantatorDonator finantatorDonator = new FinantatorDonator();
        for (int i = 0; i < listaFinantatoriDonatori.size(); i++) {
            String numeDinOrgPers = listaFinantatoriDonatori.get(i).getNumeOrgPers();
            if (numeOrgPers.equals(numeDinOrgPers)) {
                finantatorDonator = listaFinantatoriDonatori.get(i);
                break;
            }
        }
        return finantatorDonator;
    }

    @Override
    public List<FinantatorDonator> cautaTot() {
        return listaFinantatoriDonatori;
    }
}
