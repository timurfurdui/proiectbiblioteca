package com.timur.databasebiblioteca.util;

import java.sql.Date;
import com.timur.databasebiblioteca.model.Carte;

/**
 *
 * @author Timur
 */
public class CSVUtilCarte {
    public static final String CSV = ", ";
    public static final String EOL = "\n";
   
    public static String CarteToLine(Carte c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getNrDeInregistrare());
        sb.append(CSV);
        sb.append(c.getTitlu());
        sb.append(CSV);
        sb.append(c.getAutor());
        sb.append(CSV);
        sb.append(c.getLoculPublicarii());
        sb.append(CSV);
        sb.append(c.getISBN());
        sb.append(CSV);
        sb.append(c.getGen());
        sb.append(CSV);
        sb.append(c.getClasificareCZU());
        sb.append(CSV);
        sb.append(c.getNumarInventar());
        sb.append(CSV);
        sb.append(c.getDataPrimirii());
        sb.append(CSV);
        sb.append(c.getRepartizareOficii());
        sb.append(CSV);
        sb.append(c.getTipDocument());
        sb.append(CSV);
        sb.append(c.getLimbaDeEditare());
        sb.append(CSV);
        sb.append(c.getDescriereaBibliografica());
        sb.append(CSV);
        sb.append(EOL);

        sb.trimToSize();
        return sb.toString();
    }
    
    public static Carte rindToCarte(String rind) {
        String[] cuvinte = rind.split(CSV);
        int nrDeInregistrare = Integer.parseInt(cuvinte[0]);
        String titlu = cuvinte[1];
        String autor = cuvinte[4];
        String loculPublicarii = cuvinte[5];
        Date anulPublicarii = Date.valueOf(cuvinte[6]);
        Long ISBN = Long.parseLong(cuvinte[0]);
        String gen = cuvinte[7];
        String clasificareCZU = cuvinte[8];
        int numarInventar = Integer.parseInt(cuvinte[0]);
        Date dataPrimirii = Date.valueOf(cuvinte[6]);
        String repartizareOficii = cuvinte[11];
        String tipDocument = cuvinte[11];
        String limbaDeEditare = cuvinte[11];
        String descriereaBibliografica = cuvinte[11];
        Carte c = new Carte(nrDeInregistrare, titlu, autor, loculPublicarii, 
                anulPublicarii, ISBN, gen, clasificareCZU, numarInventar, 
                dataPrimirii, repartizareOficii, tipDocument, limbaDeEditare, 
                descriereaBibliografica);
        return c;
    }
}
