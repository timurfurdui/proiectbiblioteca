package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.Angajat;
import com.timur.databasebiblioteca.service.AngajatMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur
 */
public class AngajatMockImpl implements AngajatMockIntF {
    List<Angajat> listaAngajati;

    public AngajatMockImpl() {
        this.listaAngajati = new ArrayList<>();
    }

    public AngajatMockImpl(List<Angajat> listaAngajati) {
        this.listaAngajati = listaAngajati;
    }


    @Override
    public void salveazaAngajat(Angajat a) {
        listaAngajati.add(a);
    }

    @Override
    public void actualizeazaAngajat(Angajat a) {
        for (int i = 0; i < listaAngajati.size(); i++) {
            int idCautat = a.getNrDeInregistrare();
            int idDinLista = listaAngajati.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaAngajati.set(i, a);
                break;
            }
        }
    }

    @Override
    public void stergeAngajat(Angajat a) {
        for (int i = 0; i < listaAngajati.size(); i++) {
            String numeCautat = a.getNumelePrenumele();
            String numeDinLista = listaAngajati.get(i).getNumelePrenumele();
            if (numeCautat.equals(numeDinLista)) {
                listaAngajati.remove(i);
                break;
            }
        }
    }

    @Override
    public Angajat cautare(String numelePrenumele) {
        Angajat angajat = new Angajat();
        for (int i = 0; i < listaAngajati.size(); i++) {
            String numeLista = listaAngajati.get(i).getNumelePrenumele();
            if (numelePrenumele.equals(numeLista)) {
                angajat = listaAngajati.get(i);
                break;
            }
        }
        return angajat;
    }

    @Override
    public List<Angajat> cautaTot() {
        return listaAngajati;
    }
}
