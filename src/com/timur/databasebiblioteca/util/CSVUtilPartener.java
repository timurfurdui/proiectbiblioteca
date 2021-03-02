package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.Partener;

/**
 *
 * @author Timur
 */
public class CSVUtilPartener {
    public static final String CSV = ", ";
    public static final String EOL = "\n";
    
    public static String PartenerToLine(Partener p) {
        StringBuilder sb = new StringBuilder();
        sb.append(p.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(p.getNumelePartenerului());
        sb.append(CSV);
        sb.append(p.getDomeniulDeActivitate());
        sb.append(CSV);
        sb.append(p.getNumarulSemnarii());
        sb.append(CSV);
        sb.append(p.getDataSemnarii());
        sb.append(CSV);
        sb.append(p.getValabilitateaContractului());
        sb.append(CSV);
        sb.append(p.getScopulParteneriatului());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }

    public static Partener rindToPartener(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String numelePartenerului = cuvinte[1];
        String domeniulDeActivitate = cuvinte[2];
        int numarulSemnarii = Integer.parseInt(cuvinte[3]);
        Date dataSemnarii = Date.valueOf(cuvinte[4]);
        Date valabilitateaContractului = Date.valueOf(cuvinte[5]);
        String scopulParteneriatului = cuvinte[6];
        Partener p = new Partener(nrDeInregistrare, numelePartenerului, 
                domeniulDeActivitate, numarulSemnarii, dataSemnarii, 
                valabilitateaContractului, scopulParteneriatului);
        return p;
    }
}
