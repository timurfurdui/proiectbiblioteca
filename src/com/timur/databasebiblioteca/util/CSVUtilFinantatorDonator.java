package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.FinantatorDonator;

/**
 *
 * @author Timur
 */
public class CSVUtilFinantatorDonator {
    public static final String CSV = ", ";
    public static final String EOL = "\n";

    public static String FinantatorDonatorToLine(FinantatorDonator fd) {
        StringBuilder sb = new StringBuilder();
        sb.append(fd.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(fd.getNumeOrgPers());
        sb.append(CSV);
        sb.append(fd.getAdresaJuridicar());
        sb.append(CSV);
        sb.append(fd.getDateDeContact());
        sb.append(CSV);
        sb.append(fd.getInfoFinatator());
        sb.append(CSV);
        sb.append(fd.getAnulFinatarii());
        sb.append(CSV);
        sb.append(fd.getValoareaFinantarii());
        sb.append(CSV);
        sb.append(fd.getAlteMentiuni());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }

    public static FinantatorDonator rindToFinantatorDonator(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String numeOrgPers = cuvinte[1];
        String adresaJuridicar = cuvinte[2];
        String dateDeContact = cuvinte[3];
        String infoFinatator = cuvinte[4];
        String scopulFinatarii = cuvinte[5];
        Date anulFinatarii = Date.valueOf(cuvinte[6]);
        Double valoareaFinantarii = Double.parseDouble(cuvinte[7]);
        String alteMentiuni = cuvinte[8];
        FinantatorDonator fd = new FinantatorDonator(nrDeInregistrare, numeOrgPers, 
                adresaJuridicar, dateDeContact, infoFinatator, scopulFinatarii, 
                anulFinatarii, valoareaFinantarii, alteMentiuni);
        return fd;
    }
}
