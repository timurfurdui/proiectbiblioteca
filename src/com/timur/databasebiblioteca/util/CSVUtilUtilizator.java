package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.Utilizator;

/**
 *
 * @author Timur
 */
public class CSVUtilUtilizator {
    public static final String CSV = ", ";
    public static final String EOL = "\n";

    public static String UtilizatorToLine(Utilizator u) {
        StringBuilder sb = new StringBuilder();
        sb.append(u.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(u.getNumPrenumPatr());
        sb.append(CSV);
        sb.append(u.getAnInreg());
        sb.append(CSV);
        sb.append(u.getTelMob());
        sb.append(CSV);
        sb.append(u.getEmail());
        sb.append(CSV);
        sb.append(u.getAdresaDomiciliu());
        sb.append(CSV);
        sb.append(u.getAnulNasterii());
        sb.append(CSV);
        sb.append(u.getSex());
        sb.append(CSV);
        sb.append(u.getEtnie());
        sb.append(CSV);
        sb.append(u.getOcupatia());
        sb.append(CSV);
        sb.append(u.getOficiulUtilizat());
        sb.append(CSV);
        sb.append(u.getImprumutDeCarte());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }
    
    public static Utilizator rindToUtilizator(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String numPrenumPatr = cuvinte[1];
        Date anInreg = Date.valueOf(cuvinte[2]);
        Long telMob = Long.parseLong(cuvinte[3]);
        String email = cuvinte[4];
        String adresaDomiciliu = cuvinte[5];
        Date anulNasterii = Date.valueOf(cuvinte[6]);
        String sex = cuvinte[7];
        String etnie = cuvinte[8];
        String ocupatia = cuvinte[9];
        String oficiulUtilizat = cuvinte[10];
        String imprumutDeCarte = cuvinte[11];
        Utilizator u = new Utilizator(nrDeInregistrare, numPrenumPatr, anInreg, 
                telMob, email, adresaDomiciliu, anulNasterii, sex, etnie, 
                ocupatia, oficiulUtilizat, imprumutDeCarte);
        return u;
    }
}
