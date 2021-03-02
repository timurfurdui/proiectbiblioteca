package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author User
 */
public class FinantatorDonator {
    private int nrDeInregistrare;
    private String numeOrgPers;
    private String adresaJuridicar;
    private String dateDeContact;
    private String infoFinatator;
    private String scopulFinatarii;
    private Date anulFinatarii;
    private double valoareaFinantarii;
    private String alteMentiuni;

    public FinantatorDonator() {
    }

    public FinantatorDonator(int nrDeInregistrare, String numeOrgPers, String adresaJuridicar,
                             String dateDeContact, String infoFinatator, String scopulFinatarii, Date anulFinatarii,
                             double valoareaFinantarii, String alteMentiuni) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.numeOrgPers = numeOrgPers;
        this.adresaJuridicar = adresaJuridicar;
        this.dateDeContact = dateDeContact;
        this.infoFinatator = infoFinatator;
        this.scopulFinatarii = scopulFinatarii;
        this.anulFinatarii = anulFinatarii;
        this.valoareaFinantarii = valoareaFinantarii;
        this.alteMentiuni = alteMentiuni;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getNumeOrgPers() {
        return numeOrgPers;
    }

    public void setNumeOrgPers(String numeOrgPers) {
        this.numeOrgPers = numeOrgPers;
    }

    public String getAdresaJuridicar() {
        return adresaJuridicar;
    }

    public void setAdresaJuridicar(String adresaJuridicar) {
        this.adresaJuridicar = adresaJuridicar;
    }

    public String getDateDeContact() {
        return dateDeContact;
    }

    public void setDateDeContact(String dateDeContact) {
        this.dateDeContact = dateDeContact;
    }

    public String getInfoFinatator() {
        return infoFinatator;
    }

    public void setInfoFinatator(String infoFinatator) {
        this.infoFinatator = infoFinatator;
    }

    public String getScopulFinatarii() {
        return scopulFinatarii;
    }

    public void setScopulFinatarii(String scopulFinatarii) {
        this.scopulFinatarii = scopulFinatarii;
    }

    public Date getAnulFinatarii() {
        return anulFinatarii;
    }

    public void setAnulFinatarii(Date anulFinatarii) {
        this.anulFinatarii = anulFinatarii;
    }

    public double getValoareaFinantarii() {
        return valoareaFinantarii;
    }

    public void setValoareaFinantarii(double valoareaFinantarii) {
        this.valoareaFinantarii = valoareaFinantarii;
    }

    public String getAlteMentiuni() {
        return alteMentiuni;
    }

    public void setAlteMentiuni(String alteMentiuni) {
        this.alteMentiuni = alteMentiuni;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.nrDeInregistrare;
        hash = 17 * hash + Objects.hashCode(this.numeOrgPers);
        hash = 17 * hash + Objects.hashCode(this.adresaJuridicar);
        hash = 17 * hash + Objects.hashCode(this.dateDeContact);
        hash = 17 * hash + Objects.hashCode(this.infoFinatator);
        hash = 17 * hash + Objects.hashCode(this.scopulFinatarii);
        hash = 17 * hash + Objects.hashCode(this.anulFinatarii);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.valoareaFinantarii) ^ (Double.doubleToLongBits(this.valoareaFinantarii) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.alteMentiuni);
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
        final FinantatorDonator other = (FinantatorDonator) obj;
        if (this.nrDeInregistrare != other.nrDeInregistrare) {
            return false;
        }
        if (Double.doubleToLongBits(this.valoareaFinantarii) != Double.doubleToLongBits(other.valoareaFinantarii)) {
            return false;
        }
        if (!Objects.equals(this.numeOrgPers, other.numeOrgPers)) {
            return false;
        }
        if (!Objects.equals(this.adresaJuridicar, other.adresaJuridicar)) {
            return false;
        }
        if (!Objects.equals(this.dateDeContact, other.dateDeContact)) {
            return false;
        }
        if (!Objects.equals(this.infoFinatator, other.infoFinatator)) {
            return false;
        }
        if (!Objects.equals(this.scopulFinatarii, other.scopulFinatarii)) {
            return false;
        }
        if (!Objects.equals(this.alteMentiuni, other.alteMentiuni)) {
            return false;
        }
        if (!Objects.equals(this.anulFinatarii, other.anulFinatarii)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FinantatorDonator {" + "nrDeInregistrare: " + nrDeInregistrare +
                ", numeOrgPers: " + numeOrgPers + ", adresaJuridicar: " + adresaJuridicar +
                ", dateDeContact: " + dateDeContact + ", infoFinatator: " + infoFinatator +
                ", scopulFinatarii: " + scopulFinatarii + ", anulFinatarii: " + anulFinatarii +
                ", valoareaFinantarii: " + valoareaFinantarii + ", alteMentiuni: " + alteMentiuni + "}\n";
    }

}
