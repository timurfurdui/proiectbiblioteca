package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.Voluntar;

/**
 *
 * @author Timur
 */
public class CSVUtilVoluntar {
    public static final String CSV = ", ";
    public static final String EOL = "\n";

    public static String VoluntarToLine(Voluntar v) {
        StringBuilder sb = new StringBuilder();
        sb.append(v.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(v.getNumeleVoluntarului());
        sb.append(CSV);
        sb.append(v.getVirstaVoluntarului());
        sb.append(CSV);
        sb.append(v.getPerioadaDeActivitate());
        sb.append(CSV);
        sb.append(v.getDomeniulDeActivitate());
        sb.append(CSV);
        sb.append(v.getDescriereaActivitatii());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }
    
    public static Voluntar rindToVoluntar(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String numeleVoluntarului = cuvinte[1];
        Date virstaVoluntarului = Date.valueOf(cuvinte[2]);
        int perioadaDeActivitate = Integer.parseInt(cuvinte[3]);
        String domeniulDeActivitate = cuvinte[4];
        String descriereaActivitatii = cuvinte[5];
        Voluntar v = new Voluntar(nrDeInregistrare, numeleVoluntarului, virstaVoluntarului, 
                perioadaDeActivitate, domeniulDeActivitate, descriereaActivitatii);
        return v;
    }
}
