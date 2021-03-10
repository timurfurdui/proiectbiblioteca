package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Timur
 */
public class Angajat {
    private int nrDeInregistrare;
    private String numelePrenumele;
    private Date dataDeNastere;
    private String seriaBI;
    private Date eliberatBI;
    private long CNP;
    private String adresaDomiciliu;
    private long tel;
    private String email;
    private String apartenentaEtnica;
    private String sexul;
    private String studiile;
    private String specializarea;
    private String functiaDetinuta;
    private Date dataAngajarii;
    private String premiiDistinctii;
    private Date anulConferirei;
    private String scopulPremiului;
    private Date demisionare;

    public Angajat() {
    }

    public Angajat(int nrDeInregistrare, String numelePrenumele, Date dataDeNastere, String seriaBI,
                   Date eliberatBI, long CNP, String adresaDomiciliu, long tel, String email,
                   String apartenentaEtnica, String sexul, String studiile, String specializarea,
                   String functiaDetinuta, Date dataAngajarii, String premiiDistinctii, Date anulConferirei,
                   String scopulPremiului, Date demisionare) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.numelePrenumele = numelePrenumele;
        this.dataDeNastere = dataDeNastere;
        this.seriaBI = seriaBI;
        this.eliberatBI = eliberatBI;
        this.CNP = CNP;
        this.adresaDomiciliu = adresaDomiciliu;
        this.tel = tel;
        this.email = email;
        this.apartenentaEtnica = apartenentaEtnica;
        this.sexul = sexul;
        this.studiile = studiile;
        this.specializarea = specializarea;
        this.functiaDetinuta = functiaDetinuta;
        this.dataAngajarii = dataAngajarii;
        this.premiiDistinctii = premiiDistinctii;
        this.anulConferirei = anulConferirei;
        this.scopulPremiului = scopulPremiului;
        this.demisionare = demisionare;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getNumelePrenumele() {
        return numelePrenumele;
    }

    public void setNumelePrenumele(String numelePrenumele) {
        this.numelePrenumele = numelePrenumele;
    }

    public Date getDataDeNastere() {
        return dataDeNastere;
    }

    public void setDataDeNastere(Date dataDeNastere) {
        this.dataDeNastere = dataDeNastere;
    }

    public String getSeriaBI() {
        return seriaBI;
    }

    public void setSeriaBI(String seriaBI) {
        this.seriaBI = seriaBI;
    }

    public Date getEliberatBI() {
        return eliberatBI;
    }

    public void setEliberatBI(Date eliberatBI) {
        this.eliberatBI = eliberatBI;
    }

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }

    public String getAdresaDomiciliu() {
        return adresaDomiciliu;
    }

    public void setAdresaDomiciliu(String adresaDomiciliu) {
        this.adresaDomiciliu = adresaDomiciliu;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApartenentaEtnica() {
        return apartenentaEtnica;
    }

    public void setApartenentaEtnica(String apartenentaEtnica) {
        this.apartenentaEtnica = apartenentaEtnica;
    }

    public String getSexul() {
        return sexul;
    }

    public void setSexul(String sexul) {
        this.sexul = sexul;
    }

    public String getStudiile() {
        return studiile;
    }

    public void setStudiile(String studiile) {
        this.studiile = studiile;
    }

    public String getSpecializarea() {
        return specializarea;
    }

    public void setSpecializarea(String specializarea) {
        this.specializarea = specializarea;
    }

    public String getFunctiaDetinuta() {
        return functiaDetinuta;
    }

    public void setFunctiaDetinuta(String functiaDetinuta) {
        this.functiaDetinuta = functiaDetinuta;
    }

    public Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public String getPremiiDistinctii() {
        return premiiDistinctii;
    }

    public void setPremiiDistinctii(String premiiDistinctii) {
        this.premiiDistinctii = premiiDistinctii;
    }

    public Date getAnulConferirei() {
        return anulConferirei;
    }

    public void setAnulConferirei(Date anulConferirei) {
        this.anulConferirei = anulConferirei;
    }

    public String getScopulPremiului() {
        return scopulPremiului;
    }

    public void setScopulPremiului(String scopulPremiului) {
        this.scopulPremiului = scopulPremiului;
    }

    public Date getDemisionare() {
        return demisionare;
    }

    public void setDemisionare(Date demisionare) {
        this.demisionare = demisionare;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nrDeInregistrare);
        hash = 53 * hash + Objects.hashCode(this.numelePrenumele);
        hash = 53 * hash + Objects.hashCode(this.dataDeNastere);
        hash = 53 * hash + Objects.hashCode(this.seriaBI);
        hash = 53 * hash + Objects.hashCode(this.eliberatBI);
        hash = 53 * hash + (int) (this.CNP ^ (this.CNP >>> 32));
        hash = 53 * hash + Objects.hashCode(this.adresaDomiciliu);
        hash = 53 * hash + (int) (this.tel ^ (this.tel >>> 32));
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.apartenentaEtnica);
        hash = 53 * hash + Objects.hashCode(this.sexul);
        hash = 53 * hash + Objects.hashCode(this.studiile);
        hash = 53 * hash + Objects.hashCode(this.specializarea);
        hash = 53 * hash + Objects.hashCode(this.functiaDetinuta);
        hash = 53 * hash + Objects.hashCode(this.dataAngajarii);
        hash = 53 * hash + Objects.hashCode(this.premiiDistinctii);
        hash = 53 * hash + Objects.hashCode(this.anulConferirei);
        hash = 53 * hash + Objects.hashCode(this.scopulPremiului);
        hash = 53 * hash + Objects.hashCode(this.demisionare);
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
        final Angajat other = (Angajat) obj;
        if (this.CNP != other.CNP) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (!Objects.equals(this.nrDeInregistrare, other.nrDeInregistrare)) {
            return false;
        }
        if (!Objects.equals(this.numelePrenumele, other.numelePrenumele)) {
            return false;
        }
        if (!Objects.equals(this.seriaBI, other.seriaBI)) {
            return false;
        }
        if (!Objects.equals(this.adresaDomiciliu, other.adresaDomiciliu)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.apartenentaEtnica, other.apartenentaEtnica)) {
            return false;
        }
        if (!Objects.equals(this.sexul, other.sexul)) {
            return false;
        }
        if (!Objects.equals(this.studiile, other.studiile)) {
            return false;
        }
        if (!Objects.equals(this.specializarea, other.specializarea)) {
            return false;
        }
        if (!Objects.equals(this.functiaDetinuta, other.functiaDetinuta)) {
            return false;
        }
        if (!Objects.equals(this.premiiDistinctii, other.premiiDistinctii)) {
            return false;
        }
        if (!Objects.equals(this.scopulPremiului, other.scopulPremiului)) {
            return false;
        }
        if (!Objects.equals(this.dataDeNastere, other.dataDeNastere)) {
            return false;
        }
        if (!Objects.equals(this.eliberatBI, other.eliberatBI)) {
            return false;
        }
        if (!Objects.equals(this.dataAngajarii, other.dataAngajarii)) {
            return false;
        }
        if (!Objects.equals(this.anulConferirei, other.anulConferirei)) {
            return false;
        }
        if (!Objects.equals(this.demisionare, other.demisionare)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Angajat {" + "nrDeInregistrare: " + nrDeInregistrare + ", numelePrenumele: " +
                numelePrenumele + ", dataDeNastere: " + dataDeNastere + ", seriaBI: " + seriaBI +
                ", eliberatBI: " + eliberatBI + ", CNP: " + CNP + ", adresaDomiciliu: " + adresaDomiciliu +
                ", tel: " + tel + ", email: " + email + ", apartenentaEtnica: " + apartenentaEtnica +
                ", sexul: " + sexul + ", studiile: " + studiile + ", specializarea: " + specializarea +
                ", functiaDetinuta: " + functiaDetinuta + ", dataAngajarii: " + dataAngajarii +
                ", premiiDistinctii: " + premiiDistinctii + ", anulConferirei: " + anulConferirei +
                ", scopulPremiului: " + scopulPremiului + ", demisionare: " + demisionare + "}\n";
    }

}
