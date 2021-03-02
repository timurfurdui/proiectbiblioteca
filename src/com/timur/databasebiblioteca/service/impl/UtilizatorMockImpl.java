package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.Utilizator;
import com.timur.databasebiblioteca.service.UtilizatorMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
public class UtilizatorMockImpl implements UtilizatorMockIntF {
    List<Utilizator> listaUtilizatori;

    public UtilizatorMockImpl() {
        this.listaUtilizatori = new ArrayList<>();
    }

    public UtilizatorMockImpl(List<Utilizator> listaUtilizatori) {
        this.listaUtilizatori = listaUtilizatori;
    }


    @Override
    public void salveazaUtilizator(Utilizator u) {
        listaUtilizatori.add(u);
    }

    @Override
    public void actualizeazaUtilizator(Utilizator u) {
        for (int i = 0; i < listaUtilizatori.size(); i++) {
            int idCautat = u.getNrDeInregistrare();
            int idDinLista = listaUtilizatori.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaUtilizatori.set(i, u);
                break;
            }
        }
    }

    @Override
    public void stergeUtilizator(Utilizator u) {
        for (int i = 0; i < listaUtilizatori.size(); i++) {
            String numeCautat = u.getNumPrenumPatr();
            String numeDinLista = listaUtilizatori.get(i).getNumPrenumPatr();
            if (numeCautat.equals(numeDinLista)) {
                listaUtilizatori.remove(i);
                break;
            }
        }
    }

    @Override
    public Utilizator cautare(String numPrenumPatr) {
        Utilizator utilizator = new Utilizator();
        for (int i = 0; i < listaUtilizatori.size(); i++) {
            String numeLista = listaUtilizatori.get(i).getNumPrenumPatr();
            if (numPrenumPatr.equals(numeLista)) {
                utilizator = listaUtilizatori.get(i);
                break;
            }
        }
        return utilizator;
    }

    @Override
    public List<Utilizator> cautaTot() {
        return listaUtilizatori;
    }
}
