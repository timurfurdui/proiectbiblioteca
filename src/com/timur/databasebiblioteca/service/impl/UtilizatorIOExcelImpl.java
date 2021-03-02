package com.timur.databasebiblioteca.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.Utilizator;
import com.timur.databasebiblioteca.service.UtilizatorIOIntF;

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
public class UtilizatorIOExcelImpl implements UtilizatorIOIntF {

    @Override
    public void saveToFile(String fileName, List<Utilizator> listUtilizatori) {
        try {
            XSSFWorkbook utilizatorWorkbook = new XSSFWorkbook();
            Sheet utilizatorSheet = utilizatorWorkbook.createSheet("Lista de utilizatori");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = utilizatorSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("Nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Numele, Prenumele, Patronimicul");
            row.createCell(cellIndex++).setCellValue("Anul inregistrarii / reinregistrarii");
            row.createCell(cellIndex++).setCellValue("Nr. telefon");
            row.createCell(cellIndex++).setCellValue("E-mail");
            row.createCell(cellIndex++).setCellValue("Adresa la domiciliu");
            row.createCell(cellIndex++).setCellValue("Anul nasterii");
            row.createCell(cellIndex++).setCellValue("Sex");
            row.createCell(cellIndex++).setCellValue("Etnie");
            row.createCell(cellIndex++).setCellValue("Ocupatie");
            row.createCell(cellIndex++).setCellValue("Oficiu utilizat");
            row.createCell(cellIndex++).setCellValue("Imprumut de carte");
            for (Utilizator utilizator : listUtilizatori) {
                row = utilizatorSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(utilizator.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(utilizator.getNumPrenumPatr());
                row.createCell(cellIndex++).setCellValue(utilizator.getAnInreg().toString());
                row.createCell(cellIndex++).setCellValue(utilizator.getTelMob());
                row.createCell(cellIndex++).setCellValue(utilizator.getEmail());
                row.createCell(cellIndex++).setCellValue(utilizator.getAdresaDomiciliu());
                row.createCell(cellIndex++).setCellValue(utilizator.getAnulNasterii().toString());
                row.createCell(cellIndex++).setCellValue(utilizator.getSex());
                row.createCell(cellIndex++).setCellValue(utilizator.getEtnie());
                row.createCell(cellIndex++).setCellValue(utilizator.getOcupatia());
                row.createCell(cellIndex++).setCellValue(utilizator.getOficiulUtilizat());
                row.createCell(cellIndex++).setCellValue(utilizator.getImprumutDeCarte());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            utilizatorWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(UtilizatorIOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilizator> readFile(String fileName) {
        List<Utilizator> listaUtilizatori = new ArrayList<Utilizator>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                Utilizator utilizator = new Utilizator();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        utilizator.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        utilizator.setNumPrenumPatr(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        utilizator.setAnInreg(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 3) {
                        utilizator.setTelMob((long) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        utilizator.setEmail(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 5) {
                        utilizator.setAdresaDomiciliu(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 6) {
                        utilizator.setAnulNasterii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 7) {
                        utilizator.setSex(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 8) {
                        utilizator.setEtnie(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 9) {
                        utilizator.setOcupatia(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 10) {
                        utilizator.setOficiulUtilizat(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 11) {
                        utilizator.setImprumutDeCarte(cell.getStringCellValue());
                    }
                }
                listaUtilizatori.add(utilizator);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(UtilizatorIOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaUtilizatori;
    }
}
