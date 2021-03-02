package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.Carte;
import com.timur.databasebiblioteca.service.CarteMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
public class CarteMockImpl implements CarteMockIntF {
    List<Carte> listaCarti;

    public CarteMockImpl() {
        this.listaCarti = new ArrayList<>();
    }

    public CarteMockImpl(List<Carte> listaCarti) {
        this.listaCarti = listaCarti;
    }

    @Override
    public void salveazaCarte(Carte c) {
        listaCarti.add(c);
    }

    @Override
    public void actualizeazaCarte(Carte c) {
        for (int i = 0; i < listaCarti.size(); i++) {
            int idCautat = c.getNrDeInregistrare();
            int idDinLista = listaCarti.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaCarti.set(i, c);
                break;
            }
        }
    }

    @Override
    public void stergeCarte(Carte c) {
        for (int i = 0; i < listaCarti.size(); i++) {
            //if(listaCarti.get(i).getId() == c.getId()) 
            int idCautat = c.getNrDeInregistrare();
            int idDinLista = listaCarti.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaCarti.remove(i);
                break;
            }
        }
    }

    @Override
    public Carte cautare(String titlu) {
        Carte carte = new Carte();
        for (int i = 0; i < listaCarti.size(); i++) {
            String idTitlu = listaCarti.get(i).getTitlu();
            if (titlu.equals(idTitlu)) {
                carte = listaCarti.get(i);
                break;
            }
        }
        return carte;
    }

    @Override
    public List<Carte> cautaTot() {
        return listaCarti;
    }

}
