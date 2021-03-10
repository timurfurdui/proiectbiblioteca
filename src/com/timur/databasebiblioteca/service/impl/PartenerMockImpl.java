package com.timur.databasebiblioteca.service.impl;

import com.timur.databasebiblioteca.model.Partener;
import com.timur.databasebiblioteca.service.PartenerMockIntF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timur
 */
public class PartenerMockImpl implements PartenerMockIntF {
    List<Partener> listaParteneri;

    public PartenerMockImpl() {
        this.listaParteneri = new ArrayList<>();
    }

    public PartenerMockImpl(List<Partener> listaParteneri) {
        this.listaParteneri = listaParteneri;
    }


    @Override
    public void salveazaPartener(Partener p) {
        listaParteneri.add(p);
    }

    @Override
    public void actualizeazaPartener(Partener p) {
        for (int i = 0; i < listaParteneri.size(); i++) {
            int idCautat = p.getNrDeInregistrare();
            int idDinLista = listaParteneri.get(i).getNrDeInregistrare();
            if (idCautat == idDinLista) {
                listaParteneri.set(i, p);
                break;
            }
        }
    }

    @Override
    public void stergePartener(Partener p) {
        for (int i = 0; i < listaParteneri.size(); i++) {
            String numeCautat = p.getNumelePartenerului();
            String numeDinLista = listaParteneri.get(i).getNumelePartenerului();
            if (numeCautat.equals(numeDinLista)) {
                listaParteneri.remove(i);
                break;
            }
        }
    }

    @Override
    public Partener cautare(String numelePartenerului) {
        Partener partener = new Partener();
        for (int i = 0; i < listaParteneri.size(); i++) {
            String numeLista = listaParteneri.get(i).getNumelePartenerului();
            if (numelePartenerului.equals(numeLista)) {
                partener = listaParteneri.get(i);
                break;
            }
        }
        return partener;
    }

    @Override
    public List<Partener> cautaTot() {
        return listaParteneri;
    }
}
