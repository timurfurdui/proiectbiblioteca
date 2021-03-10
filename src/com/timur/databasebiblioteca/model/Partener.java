package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Timur
 */
public class Partener {
    private int nrDeInregistrare;
    private String numelePartenerului;
    private String domeniulDeActivitate;
    private int numarulSemnarii;
    private Date dataSemnarii;
    private Date valabilitateaContractului;
    private String scopulParteneriatului;

    public Partener() {
    }

    public Partener(int nrDeInregistrare, String numelePartenerului, String domeniulDeActivitate,
                    int numarulSemnarii, Date dataSemnarii, Date valabilitateaContractului,
                    String scopulParteneriatului) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.numelePartenerului = numelePartenerului;
        this.domeniulDeActivitate = domeniulDeActivitate;
        this.numarulSemnarii = numarulSemnarii;
        this.dataSemnarii = dataSemnarii;
        this.valabilitateaContractului = valabilitateaContractului;
        this.scopulParteneriatului = scopulParteneriatului;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getNumelePartenerului() {
        return numelePartenerului;
    }

    public void setNumelePartenerului(String numelePartenerului) {
        this.numelePartenerului = numelePartenerului;
    }

    public String getDomeniulDeActivitate() {
        return domeniulDeActivitate;
    }

    public void setDomeniulDeActivitate(String domeniulDeActivitate) {
        this.domeniulDeActivitate = domeniulDeActivitate;
    }

    public int getNumarulSemnarii() {
        return numarulSemnarii;
    }

    public void setNumarulSemnarii(int numarulSemnarii) {
        this.numarulSemnarii = numarulSemnarii;
    }

    public Date getDataSemnarii() {
        return dataSemnarii;
    }

    public void setDataSemnarii(Date dataSemnarii) {
        this.dataSemnarii = dataSemnarii;
    }

    public Date getValabilitateaContractului() {
        return valabilitateaContractului;
    }

    public void setValabilitateaContractului(Date valabilitateaContractului) {
        this.valabilitateaContractului = valabilitateaContractului;
    }

    public String getScopulParteneriatului() {
        return scopulParteneriatului;
    }

    public void setScopulParteneriatului(String scopulParteneriatului) {
        this.scopulParteneriatului = scopulParteneriatului;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nrDeInregistrare);
        hash = 47 * hash + Objects.hashCode(this.numelePartenerului);
        hash = 47 * hash + Objects.hashCode(this.domeniulDeActivitate);
        hash = 47 * hash + this.numarulSemnarii;
        hash = 47 * hash + Objects.hashCode(this.dataSemnarii);
        hash = 47 * hash + Objects.hashCode(this.valabilitateaContractului);
        hash = 47 * hash + Objects.hashCode(this.scopulParteneriatului);
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
        final Partener other = (Partener) obj;
        if (this.numarulSemnarii != other.numarulSemnarii) {
            return false;
        }
        if (!Objects.equals(this.nrDeInregistrare, other.nrDeInregistrare)) {
            return false;
        }
        if (!Objects.equals(this.numelePartenerului, other.numelePartenerului)) {
            return false;
        }
        if (!Objects.equals(this.domeniulDeActivitate, other.domeniulDeActivitate)) {
            return false;
        }
        if (!Objects.equals(this.scopulParteneriatului, other.scopulParteneriatului)) {
            return false;
        }
        if (!Objects.equals(this.dataSemnarii, other.dataSemnarii)) {
            return false;
        }
        if (!Objects.equals(this.valabilitateaContractului, other.valabilitateaContractului)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Partener {" + "nrDeInregistrare: " + nrDeInregistrare + ", numelePartenerului: " +
                numelePartenerului + ", domeniulDeActivitate=" + domeniulDeActivitate +
                ", numarulSemnarii: " + numarulSemnarii + ", dataSemnarii: " + dataSemnarii +
                ", valabilitateaContractului: " + valabilitateaContractului +
                ", scopulParteneriatului: " + scopulParteneriatului + "}\n";
    }

}
