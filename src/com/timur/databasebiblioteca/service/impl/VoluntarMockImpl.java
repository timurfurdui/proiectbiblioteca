package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.Voluntar;
import com.timur.databasebiblioteca.service.VoluntarMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur
 */
public class VoluntarMockImpl implements VoluntarMockIntF {
    List<Voluntar> listaVoluntari;

    public VoluntarMockImpl() {
        this.listaVoluntari = new ArrayList<>();
    }

    public VoluntarMockImpl(List<Voluntar> listaVoluntari) {
        this.listaVoluntari = listaVoluntari;
    }


    @Override
    public void salveazaVoluntar(Voluntar v) {
        listaVoluntari.add(v);
    }

    @Override
    public void actualizeazaVoluntar(Voluntar v) {
        for (int i = 0; i < listaVoluntari.size(); i++) {
            int idCautat = v.getNrDeInregistrare();
            ;
            int idDinLista = listaVoluntari.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaVoluntari.set(i, v);
                break;
            }
        }
    }

    @Override
    public void stergeVoluntar(Voluntar v) {
        for (int i = 0; i < listaVoluntari.size(); i++) {
            String numeCautat = v.getNumeleVoluntarului();
            String numeDinLista = listaVoluntari.get(i).getNumeleVoluntarului();
            if (numeCautat.equals(numeDinLista)) {
                listaVoluntari.remove(i);
                break;
            }
        }
    }

    @Override
    public Voluntar cautare(String numelePrenumele) {
        Voluntar voluntar = new Voluntar();
        for (int i = 0; i < listaVoluntari.size(); i++) {
            String numeLista = listaVoluntari.get(i).getNumeleVoluntarului();
            if (numelePrenumele.equals(numeLista)) {
                voluntar = listaVoluntari.get(i);
                break;
            }
        }
        return voluntar;
    }


    @Override
    public List<Voluntar> cautaTot() {
        return listaVoluntari;
    }
}
