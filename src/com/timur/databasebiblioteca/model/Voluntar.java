package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Timur
 */
public class Voluntar {

    private int nrDeInregistrare;
    private String numeleVoluntarului;
    private Date virstaVoluntarului;
    private int perioadaDeActivitate;
    private String domeniulDeActivitate;
    private String descriereaActivitatii;

    public Voluntar() {
    }

    public Voluntar(int nrDeInregistrare, String numeleVoluntarului, Date virstaVoluntarului,
                    int perioadaDeActivitate, String domeniulDeActivitate, String descriereaActivitatii) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.numeleVoluntarului = numeleVoluntarului;
        this.virstaVoluntarului = virstaVoluntarului;
        this.perioadaDeActivitate = perioadaDeActivitate;
        this.domeniulDeActivitate = domeniulDeActivitate;
        this.descriereaActivitatii = descriereaActivitatii;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getNumeleVoluntarului() {
        return numeleVoluntarului;
    }

    public void setNumeleVoluntarului(String numeleVoluntarului) {
        this.numeleVoluntarului = numeleVoluntarului;
    }

    public Date getVirstaVoluntarului() {
        return virstaVoluntarului;
    }

    public void setVirstaVoluntarului(Date virstaVoluntarului) {
        this.virstaVoluntarului = virstaVoluntarului;
    }

    public int getPerioadaDeActivitate() {
        return perioadaDeActivitate;
    }

    public void setPerioadaDeActivitate(int perioadaDeActivitate) {
        this.perioadaDeActivitate = perioadaDeActivitate;
    }

    public String getDomeniulDeActivitate() {
        return domeniulDeActivitate;
    }

    public void setDomeniulDeActivitate(String domeniulDeActivitate) {
        this.domeniulDeActivitate = domeniulDeActivitate;
    }

    public String getDescriereaActivitatii() {
        return descriereaActivitatii;
    }

    public void setDescriereaActivitatii(String descriereaActivitatii) {
        this.descriereaActivitatii = descriereaActivitatii;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.nrDeInregistrare;
        hash = 59 * hash + Objects.hashCode(this.numeleVoluntarului);
        hash = 59 * hash + Objects.hashCode(this.virstaVoluntarului);
        hash = 59 * hash + this.perioadaDeActivitate;
        hash = 59 * hash + Objects.hashCode(this.domeniulDeActivitate);
        hash = 59 * hash + Objects.hashCode(this.descriereaActivitatii);
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
        final Voluntar other = (Voluntar) obj;
        if (this.nrDeInregistrare != other.nrDeInregistrare) {
            return false;
        }
        if (this.perioadaDeActivitate != other.perioadaDeActivitate) {
            return false;
        }
        if (!Objects.equals(this.numeleVoluntarului, other.numeleVoluntarului)) {
            return false;
        }
        if (!Objects.equals(this.domeniulDeActivitate, other.domeniulDeActivitate)) {
            return false;
        }
        if (!Objects.equals(this.descriereaActivitatii, other.descriereaActivitatii)) {
            return false;
        }
        if (!Objects.equals(this.virstaVoluntarului, other.virstaVoluntarului)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Voluntar {" + "nrDeInregistrare: " + nrDeInregistrare + ", numeleVoluntarului: " +
                numeleVoluntarului + ", virstaVoluntarului: " + virstaVoluntarului +
                ", perioadaDeActivitate: " + perioadaDeActivitate + ", domeniulDeActivitate: " +
                domeniulDeActivitate + ", descriereaActivitatii: " + descriereaActivitatii + "}\n";
    }

}
