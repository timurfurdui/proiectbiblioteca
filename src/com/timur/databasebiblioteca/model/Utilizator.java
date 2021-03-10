package com.timur.databasebiblioteca.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Timur
 */
public class Utilizator {

    private int nrDeInregistrare;
    private String numPrenumPatr;
    private Date anInreg;
    private long telMob;
    private String email;
    private String adresaDomiciliu;
    private Date anulNasterii;
    private String sex;
    private String etnie;
    private String ocupatia;
    private String oficiulUtilizat;
    private String imprumutDeCarte;

    public Utilizator() {
    }

    public Utilizator(int nrDeInregistrare, String numPrenumPatr, Date anInreg, long telMob, String email, String adresaDomiciliu,
                      Date anulNasterii, String sex, String etnie, String ocupatia, String oficiulUtilizat,
                      String imprumutDeCarte) {
        this.nrDeInregistrare = nrDeInregistrare;
        this.numPrenumPatr = numPrenumPatr;
        this.anInreg = anInreg;
        this.telMob = telMob;
        this.email = email;
        this.adresaDomiciliu = adresaDomiciliu;
        this.anulNasterii = anulNasterii;
        this.sex = sex;
        this.etnie = etnie;
        this.ocupatia = ocupatia;
        this.oficiulUtilizat = oficiulUtilizat;
        this.imprumutDeCarte = imprumutDeCarte;
    }

    public int getNrDeInregistrare() {
        return nrDeInregistrare;
    }

    public void setNrDeInregistrare(int nrDeInregistrare) {
        this.nrDeInregistrare = nrDeInregistrare;
    }

    public String getNumPrenumPatr() {
        return numPrenumPatr;
    }

    public void setNumPrenumPatr(String numPrenumPatr) {
        this.numPrenumPatr = numPrenumPatr;
    }

    public Date getAnInreg() {
        return anInreg;
    }

    public void setAnInreg(Date anInreg) {
        this.anInreg = anInreg;
    }

    public long getTelMob() {
        return telMob;
    }

    public void setTelMob(long telMob) {
        this.telMob = telMob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresaDomiciliu() {
        return adresaDomiciliu;
    }

    public void setAdresaDomiciliu(String adresaDomiciliu) {
        this.adresaDomiciliu = adresaDomiciliu;
    }

    public Date getAnulNasterii() {
        return anulNasterii;
    }

    public void setAnulNasterii(Date anulNasterii) {
        this.anulNasterii = anulNasterii;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEtnie() {
        return etnie;
    }

    public void setEtnie(String etnie) {
        this.etnie = etnie;
    }

    public String getOcupatia() {
        return ocupatia;
    }

    public void setOcupatia(String ocupatia) {
        this.ocupatia = ocupatia;
    }

    public String getOficiulUtilizat() {
        return oficiulUtilizat;
    }

    public void setOficiulUtilizat(String oficiulUtilizat) {
        this.oficiulUtilizat = oficiulUtilizat;
    }

    public String getImprumutDeCarte() {
        return imprumutDeCarte;
    }

    public void setImprumutDeCarte(String imprumutDeCarte) {
        this.imprumutDeCarte = imprumutDeCarte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return nrDeInregistrare == that.nrDeInregistrare && telMob == that.telMob && numPrenumPatr.equals(that.numPrenumPatr) && anInreg.equals(that.anInreg) && email.equals(that.email) && adresaDomiciliu.equals(that.adresaDomiciliu) && anulNasterii.equals(that.anulNasterii) && sex.equals(that.sex) && etnie.equals(that.etnie) && ocupatia.equals(that.ocupatia) && oficiulUtilizat.equals(that.oficiulUtilizat) && imprumutDeCarte.equals(that.imprumutDeCarte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrDeInregistrare, numPrenumPatr, anInreg, telMob, email, adresaDomiciliu,
                anulNasterii, sex, etnie, ocupatia, oficiulUtilizat, imprumutDeCarte);
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "nrDeInregistrare=" + nrDeInregistrare +
                ", numPrenumPatr='" + numPrenumPatr + '\'' +
                ", anInreg=" + anInreg +
                ", telMob=" + telMob +
                ", email='" + email + '\'' +
                ", adresaDomiciliu='" + adresaDomiciliu + '\'' +
                ", anulNasterii=" + anulNasterii +
                ", sex='" + sex + '\'' +
                ", etnie='" + etnie + '\'' +
                ", ocupatia='" + ocupatia + '\'' +
                ", oficiulUtilizat='" + oficiulUtilizat + '\'' +
                ", imprumutDeCarte='" + imprumutDeCarte + '\'' +
                "}\n";
    }
}
