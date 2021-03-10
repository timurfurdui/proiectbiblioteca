package com.timur.databasebiblioteca.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.Partener;
import com.timur.databasebiblioteca.service.PartenerIOIntF;

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
public class PartenerIOExcelImpl implements PartenerIOIntF {

    @Override
    public void saveToFile(String fileName, List<Partener> listParteneri) {
        try {
            XSSFWorkbook partenerWorkbook = new XSSFWorkbook();
            Sheet partenerSheet = partenerWorkbook.createSheet("Lista de parteneri");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = partenerSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Numele partenerului");
            row.createCell(cellIndex++).setCellValue("Domeniul de activitate");
            row.createCell(cellIndex++).setCellValue("Nr. acord / contract");
            row.createCell(cellIndex++).setCellValue("Data semnarii");
            row.createCell(cellIndex++).setCellValue("Valabilitatea contractului");
            row.createCell(cellIndex++).setCellValue("Scopul parteneriatului");
            for (Partener partener : listParteneri) {
                row = partenerSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(partener.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(partener.getNumelePartenerului());
                row.createCell(cellIndex++).setCellValue(partener.getDomeniulDeActivitate());
                row.createCell(cellIndex++).setCellValue(partener.getNumarulSemnarii());
                row.createCell(cellIndex++).setCellValue(partener.getDataSemnarii().toString());
                row.createCell(cellIndex++).setCellValue(partener.getValabilitateaContractului().toString());
                row.createCell(cellIndex++).setCellValue(partener.getScopulParteneriatului());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            partenerWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(PartenerIOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Partener> readFile(String fileName) {
        List<Partener> listaParteneri = new ArrayList<Partener>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                Partener partener = new Partener();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        partener.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        partener.setNumelePartenerului(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        partener.setDomeniulDeActivitate(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 3) {
                        partener.setNumarulSemnarii((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        partener.setDataSemnarii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 5) {
                        partener.setValabilitateaContractului(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 6) {
                        partener.setScopulParteneriatului(cell.getStringCellValue());
                    }
                }
                listaParteneri.add(partener);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(PartenerIOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaParteneri;
    }
}
