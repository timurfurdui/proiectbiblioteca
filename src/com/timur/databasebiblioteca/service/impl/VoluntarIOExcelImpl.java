package com.timur.databasebiblioteca.service.impl;

import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.Voluntar;
import com.timur.databasebiblioteca.service.VoluntarIOIntF;

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
public class VoluntarIOExcelImpl implements VoluntarIOIntF {
    private Stage stage;

    @Override
    public void saveToFile(String fileName, List<Voluntar> listVoluntari) {
        try {
            XSSFWorkbook voluntarWorkbook = new XSSFWorkbook();
            Sheet voluntarSheet = voluntarWorkbook.createSheet("Lista de voluntari");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = voluntarSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("Nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Numele voluntarului");
            row.createCell(cellIndex++).setCellValue("Virsta voluntarului");
            row.createCell(cellIndex++).setCellValue("Perioada de activitate");
            row.createCell(cellIndex++).setCellValue("Domeniul de activitate");
            row.createCell(cellIndex++).setCellValue("Descrierea activitatii");
            for (Voluntar voluntar : listVoluntari) {
                row = voluntarSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(voluntar.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(voluntar.getNumeleVoluntarului());
                row.createCell(cellIndex++).setCellValue(voluntar.getVirstaVoluntarului().toString());
                row.createCell(cellIndex++).setCellValue(voluntar.getPerioadaDeActivitate());
                row.createCell(cellIndex++).setCellValue(voluntar.getDomeniulDeActivitate());
                row.createCell(cellIndex++).setCellValue(voluntar.getDescriereaActivitatii());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            voluntarWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(VoluntarIOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Voluntar> readFile(String fileName) {
        List<Voluntar> listaVoluntari = new ArrayList<Voluntar>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                Voluntar voluntar = new Voluntar();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        voluntar.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        voluntar.setNumeleVoluntarului(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        voluntar.setVirstaVoluntarului(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 3) {
                        voluntar.setPerioadaDeActivitate((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        voluntar.setDomeniulDeActivitate(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 5) {
                        voluntar.setDescriereaActivitatii(cell.getStringCellValue());
                    }
                }
                listaVoluntari.add(voluntar);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(VoluntarIOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaVoluntari;
    }
}
