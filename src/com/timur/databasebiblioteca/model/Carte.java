package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author User
 */
public class Carte {

    private int nrDeInregistrare;
    private String titlu;
    private String autor;
    private String loculPublicarii;
    private Date anulPublicarii;
    private long ISBN;
    private String gen;
    private String clasificareCZU;
    private int numarInventar;
    private Date dataPrimirii;
    private String repartizareOficii;
    private String tipDocument;
    private String limbaDeEditare;
    private String descriereaBibliografica;

    public Carte() {
    }

    public Carte(int nrDeInregistrare, String titlu, String autor, String loculPublicarii,
                 Date anulPublicarii, long ISBN, String gen, String clasificareCZU, int numarInventar,
                 Date dataPrimirii, String repartizareOficii, String tipDocument, String limbaDeEditare,
                 String descriereaBibliografica) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.titlu = titlu;
        this.autor = autor;
        this.loculPublicarii = loculPublicarii;
        this.anulPublicarii = anulPublicarii;
        this.ISBN = ISBN;
        this.gen = gen;
        this.clasificareCZU = clasificareCZU;
        this.numarInventar = numarInventar;
        this.dataPrimirii = dataPrimirii;
        this.repartizareOficii = repartizareOficii;
        this.tipDocument = tipDocument;
        this.limbaDeEditare = limbaDeEditare;
        this.descriereaBibliografica = descriereaBibliografica;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLoculPublicarii() {
        return loculPublicarii;
    }

    public void setLoculPublicarii(String loculPublicarii) {
        this.loculPublicarii = loculPublicarii;
    }

    public Date getAnulPublicarii() {
        return anulPublicarii;
    }

    public void setAnulPublicarii(Date anulPublicarii) {
        this.anulPublicarii = anulPublicarii;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getClasificareCZU() {
        return clasificareCZU;
    }

    public void setClasificareCZU(String clasificareCZU) {
        this.clasificareCZU = clasificareCZU;
    }

    public int getNumarInventar() {
        return numarInventar;
    }

    public void setNumarInventar(int numarInventar) {
        this.numarInventar = numarInventar;
    }

    public Date getDataPrimirii() {
        return dataPrimirii;
    }

    public void setDataPrimirii(Date dataPrimirii) {
        this.dataPrimirii = dataPrimirii;
    }

    public String getRepartizareOficii() {
        return repartizareOficii;
    }

    public void setRepartizareOficii(String repartizareOficii) {
        this.repartizareOficii = repartizareOficii;
    }

    public String getTipDocument() {
        return tipDocument;
    }

    public void setTipDocument(String tipDocument) {
        this.tipDocument = tipDocument;
    }

    public String getLimbaDeEditare() {
        return limbaDeEditare;
    }

    public void setLimbaDeEditare(String limbaDeEditare) {
        this.limbaDeEditare = limbaDeEditare;
    }

    public String getDescriereaBibliografica() {
        return descriereaBibliografica;
    }

    public void setDescriereaBibliografica(String descriereaBibliografica) {
        this.descriereaBibliografica = descriereaBibliografica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.nrDeInregistrare;
        hash = 53 * hash + Objects.hashCode(this.titlu);
        hash = 53 * hash + Objects.hashCode(this.autor);
        hash = 53 * hash + Objects.hashCode(this.loculPublicarii);
        hash = 53 * hash + Objects.hashCode(this.anulPublicarii);
        hash = 53 * hash + (int) (this.ISBN ^ (this.ISBN >>> 32));
        hash = 53 * hash + Objects.hashCode(this.gen);
        hash = 53 * hash + Objects.hashCode(this.clasificareCZU);
        hash = 53 * hash + this.numarInventar;
        hash = 53 * hash + Objects.hashCode(this.dataPrimirii);
        hash = 53 * hash + Objects.hashCode(this.repartizareOficii);
        hash = 53 * hash + Objects.hashCode(this.tipDocument);
        hash = 53 * hash + Objects.hashCode(this.limbaDeEditare);
        hash = 53 * hash + Objects.hashCode(this.descriereaBibliografica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carte other = (Carte) obj;
        if (this.nrDeInregistrare != other.nrDeInregistrare) {
            return false;
        }
        if (this.ISBN != other.ISBN) {
            return false;
        }
        if (this.numarInventar != other.numarInventar) {
            return false;
        }
        if (!Objects.equals(this.titlu, other.titlu)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.loculPublicarii, other.loculPublicarii)) {
            return false;
        }
        if (!Objects.equals(this.gen, other.gen)) {
            return false;
        }
        if (!Objects.equals(this.clasificareCZU, other.clasificareCZU)) {
            return false;
        }
        if (!Objects.equals(this.repartizareOficii, other.repartizareOficii)) {
            return false;
        }
        if (!Objects.equals(this.tipDocument, other.tipDocument)) {
            return false;
        }
        if (!Objects.equals(this.limbaDeEditare, other.limbaDeEditare)) {
            return false;
        }
        if (!Objects.equals(this.descriereaBibliografica, other.descriereaBibliografica)) {
            return false;
        }
        if (!Objects.equals(this.anulPublicarii, other.anulPublicarii)) {
            return false;
        }
        if (!Objects.equals(this.dataPrimirii, other.dataPrimirii)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carte {" + "nrDeInregistrare: " + nrDeInregistrare + ", titlu: " +
                titlu + ", autor: " + autor + ", loculPublicarii: " + loculPublicarii +
                ", anulPublicarii: " + anulPublicarii + ", ISBN: " + ISBN + ", gen: " +
                gen + ", clasificareCZU: " + clasificareCZU + ", numarInventar: " + numarInventar +
                ", dataPrimirii: " + dataPrimirii + ", repartizareOficii: " + repartizareOficii +
                ", tipDocument: " + tipDocument + ", limbaDeEditare: " + limbaDeEditare +
                ", descriereaBibliografica: " + descriereaBibliografica + "}\n";
    }
}
