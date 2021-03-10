package com.timur.databasebiblioteca.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.FinantatorDonator;
import com.timur.databasebiblioteca.service.FinantatorDonatorIOIntF;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Timur
 */
public class FinantatorDonatorIOExcelImpl implements FinantatorDonatorIOIntF {

    @Override
    public void saveToFile(String fileName, List<FinantatorDonator> listFinantatoriDonatori) {
        try {
            XSSFWorkbook finantatorDonatorWorkbook = new XSSFWorkbook();
            Sheet finantatorDonatorSheet = finantatorDonatorWorkbook.createSheet("Lista de finantatoriDonatori");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = finantatorDonatorSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("Nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Nume organizatie / persoana");
            row.createCell(cellIndex++).setCellValue("Adresa juridica");
            row.createCell(cellIndex++).setCellValue("Date de contact");
            row.createCell(cellIndex++).setCellValue("Info finantator");
            row.createCell(cellIndex++).setCellValue("Scopul finantarii / donarii");
            row.createCell(cellIndex++).setCellValue("Anul finantarii / donarii");
            row.createCell(cellIndex++).setCellValue("Valoarea finantarii");
            row.createCell(cellIndex++).setCellValue("Alte mentiuni");
            for (FinantatorDonator finantatorDonator : listFinantatoriDonatori) {
                row = finantatorDonatorSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getNumeOrgPers());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getAdresaJuridicar());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getDateDeContact());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getInfoFinatator());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getScopulFinatarii());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getAnulFinatarii().toString());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getValoareaFinantarii());
                row.createCell(cellIndex++).setCellValue(finantatorDonator.getAlteMentiuni());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            finantatorDonatorWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(FinantatorDonatorIOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<FinantatorDonator> readFile(String fileName) {
        List<FinantatorDonator> listaFinantatoriDonatori = new ArrayList<FinantatorDonator>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                FinantatorDonator finantatorDonator = new FinantatorDonator();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        finantatorDonator.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        finantatorDonator.setNumeOrgPers(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        finantatorDonator.setAdresaJuridicar(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 3) {
                        finantatorDonator.setDateDeContact(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        finantatorDonator.setInfoFinatator(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 5) {
                        finantatorDonator.setScopulFinatarii(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 6) {
                        finantatorDonator.setAnulFinatarii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 7) {
                        finantatorDonator.setValoareaFinantarii(cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 8) {
                        finantatorDonator.setAlteMentiuni(cell.getStringCellValue());
                    }
                }
                listaFinantatoriDonatori.add(finantatorDonator);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(FinantatorDonatorIOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaFinantatoriDonatori;
    }
}
