package com.timur.databasebiblioteca.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.Angajat;
import com.timur.databasebiblioteca.service.AngajatOIntF;

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
 * @author User
 */
public class AngajatOExcelImpl implements AngajatOIntF {

    @Override
    public void saveToFile(String fileName, List<Angajat> listAngajati) {
        try {
            XSSFWorkbook angajatWorkbook = new XSSFWorkbook();
            Sheet angajatSheet = angajatWorkbook.createSheet("Lista de angajati");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = angajatSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("Nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Numele, Prenumele");
            row.createCell(cellIndex++).setCellValue("Data de nastere");
            row.createCell(cellIndex++).setCellValue("Seria si nr. buletin");
            row.createCell(cellIndex++).setCellValue("Data eliberare buletin");
            row.createCell(cellIndex++).setCellValue("CNP");
            row.createCell(cellIndex++).setCellValue("Adresa la domiciliu");
            row.createCell(cellIndex++).setCellValue("Telefon");
            row.createCell(cellIndex++).setCellValue("E-mail");
            row.createCell(cellIndex++).setCellValue("Apartenenta etnica");
            row.createCell(cellIndex++).setCellValue("Sexul");
            row.createCell(cellIndex++).setCellValue("Studiile");
            row.createCell(cellIndex++).setCellValue("Specializarea");
            row.createCell(cellIndex++).setCellValue("Functia detinuta");
            row.createCell(cellIndex++).setCellValue("Data angajarii");
            row.createCell(cellIndex++).setCellValue("Premii si distinctii");
            row.createCell(cellIndex++).setCellValue("Anul conferirei");
            row.createCell(cellIndex++).setCellValue("Scopul premiului");
            row.createCell(cellIndex++).setCellValue("Data demisionarii");
            for (Angajat angajat : listAngajati) {
                row = angajatSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(angajat.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(angajat.getNumelePrenumele());
                row.createCell(cellIndex++).setCellValue(angajat.getDataDeNastere().toString());
                row.createCell(cellIndex++).setCellValue(angajat.getSeriaBI());
                row.createCell(cellIndex++).setCellValue(angajat.getEliberatBI().toString());
                row.createCell(cellIndex++).setCellValue(angajat.getCNP());
                row.createCell(cellIndex++).setCellValue(angajat.getAdresaDomiciliu());
                row.createCell(cellIndex++).setCellValue(angajat.getTel());
                row.createCell(cellIndex++).setCellValue(angajat.getEmail());
                row.createCell(cellIndex++).setCellValue(angajat.getApartenentaEtnica());
                row.createCell(cellIndex++).setCellValue(angajat.getSexul());
                row.createCell(cellIndex++).setCellValue(angajat.getStudiile());
                row.createCell(cellIndex++).setCellValue(angajat.getSpecializarea());
                row.createCell(cellIndex++).setCellValue(angajat.getFunctiaDetinuta());
                row.createCell(cellIndex++).setCellValue(angajat.getDataAngajarii().toString());
                row.createCell(cellIndex++).setCellValue(angajat.getPremiiDistinctii());
                row.createCell(cellIndex++).setCellValue(angajat.getAnulConferirei().toString());
                row.createCell(cellIndex++).setCellValue(angajat.getScopulPremiului());
                row.createCell(cellIndex++).setCellValue(angajat.getDemisionare().toString());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            angajatWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(AngajatOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Angajat> readFile(String fileName) {
        List<Angajat> listaAngajati = new ArrayList<Angajat>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                Angajat angajat = new Angajat();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        angajat.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        angajat.setNumelePrenumele(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        angajat.setDataDeNastere(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 3) {
                        angajat.setSeriaBI(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        angajat.setEliberatBI(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 5) {
                        angajat.setCNP((long) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 6) {
                        angajat.setAdresaDomiciliu(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 7) {
                        angajat.setTel((long) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 8) {
                        angajat.setEmail(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 9) {
                        angajat.setApartenentaEtnica(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 10) {
                        angajat.setSexul(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 11) {
                        angajat.setStudiile(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 12) {
                        angajat.setSpecializarea(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 13) {
                        angajat.setFunctiaDetinuta(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 14) {
                        angajat.setDataAngajarii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 15) {
                        angajat.setPremiiDistinctii(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 16) {
                        angajat.setAnulConferirei(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 17) {
                        angajat.setScopulPremiului(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 18) {
                        angajat.setDemisionare(Date.valueOf(cell.getStringCellValue()));
                    }

                }
                listaAngajati.add(angajat);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(AngajatOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaAngajati;
    }
}
