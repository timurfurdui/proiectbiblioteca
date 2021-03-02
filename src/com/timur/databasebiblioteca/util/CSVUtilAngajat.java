package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.Angajat;

/**
 *
 * @author Timur
 */
public class CSVUtilAngajat {

    public static final String CSV = ", ";
    public static final String EOL = "\n";

    public static String AngajatToLine(Angajat a) {
        StringBuilder sb = new StringBuilder();
        sb.append(a.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(a.getNumelePrenumele());
        sb.append(CSV);
        sb.append(a.getDataDeNastere());
        sb.append(CSV);
        sb.append(a.getSeriaBI());
        sb.append(CSV);
        sb.append(a.getEliberatBI());
        sb.append(CSV);
        sb.append(a.getCNP());
        sb.append(CSV);
        sb.append(a.getAdresaDomiciliu());
        sb.append(CSV);
        sb.append(a.getTel());
        sb.append(CSV);
        sb.append(a.getEmail());
        sb.append(CSV);
        sb.append(a.getApartenentaEtnica());
        sb.append(CSV);
        sb.append(a.getSexul());
        sb.append(CSV);
        sb.append(a.getStudiile());
        sb.append(CSV);
        sb.append(a.getSpecializarea());
        sb.append(CSV);
        sb.append(a.getFunctiaDetinuta());
        sb.append(CSV);
        sb.append(a.getDataAngajarii());
        sb.append(CSV);
        sb.append(a.getPremiiDistinctii());
        sb.append(CSV);
        sb.append(a.getAnulConferirei());
        sb.append(CSV);
        sb.append(a.getScopulPremiului());
        sb.append(CSV);
        sb.append(a.getDemisionare());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }

    public static Angajat rindToAngajat(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String numelePrenumele = cuvinte[1];
        Date dataDeNastere = Date.valueOf(cuvinte[2]);
        String seriaBI = cuvinte[3];
        Date eliberatBI = Date.valueOf(cuvinte[4]);
        Long CNP = Long.parseLong(cuvinte[5]);
        String adresaDomiciliu = cuvinte[6];
        Long tel = Long.parseLong(cuvinte[7]);
        String email = cuvinte[8];
        String apartenentaEtnica = cuvinte[9];
        String sexul = cuvinte[10];
        String studiile = cuvinte[11];
        String specializarea = cuvinte[12];
        String functiaDetinuta = cuvinte[13];
        Date dataAngajarii = Date.valueOf(cuvinte[14]);
        String premiiDistinctii = cuvinte[15];
        Date anulConferirei = Date.valueOf(cuvinte[16]);
        String scopulPremiului = cuvinte[17];
        Date demisionare = Date.valueOf(cuvinte[18]);
        Angajat a = new Angajat(nrDeInregistrare, numelePrenumele, dataDeNastere, 
                seriaBI, eliberatBI, CNP, adresaDomiciliu, tel, email, 
                apartenentaEtnica, sexul, studiile, specializarea, functiaDetinuta, 
                dataAngajarii, premiiDistinctii, anulConferirei, scopulPremiului,
                demisionare);
        return a;
    }
}
