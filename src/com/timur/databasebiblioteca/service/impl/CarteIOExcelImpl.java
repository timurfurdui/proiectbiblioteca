package com.timur.databasebiblioteca.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.timur.databasebiblioteca.model.Carte;
import com.timur.databasebiblioteca.service.CarteIOIntF;

/**
 * @author Timur
 */
public class CarteIOExcelImpl implements CarteIOIntF {

    @Override
    public void saveToFile(String fileName, List<Carte> listCarti) {
        try {
            XSSFWorkbook carteWorkbook = new XSSFWorkbook();
            Sheet carteSheet = carteWorkbook.createSheet("Lista de carti");
            int rowIndex = 0;
            //Scriem headerul in excel
            Row row = carteSheet.createRow(rowIndex++);
            int cellIndex = 0;
            row.createCell(cellIndex++).setCellValue("Nr. de inregistrare");
            row.createCell(cellIndex++).setCellValue("Titlu");
            row.createCell(cellIndex++).setCellValue("Autor");
            row.createCell(cellIndex++).setCellValue("Locul publicarii");
            row.createCell(cellIndex++).setCellValue("Anul publicarii");
            row.createCell(cellIndex++).setCellValue("ISBN");
            row.createCell(cellIndex++).setCellValue("Gen");
            row.createCell(cellIndex++).setCellValue("Clasificare CZU");
            row.createCell(cellIndex++).setCellValue("Numar inventar");
            row.createCell(cellIndex++).setCellValue("Data primirii");
            row.createCell(cellIndex++).setCellValue("Repartizare oficii");
            row.createCell(cellIndex++).setCellValue("Tip document");
            row.createCell(cellIndex++).setCellValue("Limba de editare");
            row.createCell(cellIndex++).setCellValue("Descrierea bibliografica");
            for (Carte carte : listCarti) {
                row = carteSheet.createRow(rowIndex++);
                cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(carte.getNrDeInregistrare());
                row.createCell(cellIndex++).setCellValue(carte.getTitlu());
                row.createCell(cellIndex++).setCellValue(carte.getAutor());
                row.createCell(cellIndex++).setCellValue(carte.getLoculPublicarii());
                row.createCell(cellIndex++).setCellValue(carte.getAnulPublicarii().toString());
                row.createCell(cellIndex++).setCellValue(carte.getISBN());
                row.createCell(cellIndex++).setCellValue(carte.getGen());
                row.createCell(cellIndex++).setCellValue(carte.getClasificareCZU());
                row.createCell(cellIndex++).setCellValue(carte.getNumarInventar());
                row.createCell(cellIndex++).setCellValue(carte.getDataPrimirii().toString());
                row.createCell(cellIndex++).setCellValue(carte.getRepartizareOficii());
                row.createCell(cellIndex++).setCellValue(carte.getTipDocument());
                row.createCell(cellIndex++).setCellValue(carte.getLimbaDeEditare());
                row.createCell(cellIndex++).setCellValue(carte.getDescriereaBibliografica());
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            carteWorkbook.write(fos);
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(CarteIOExcelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Carte> readFile(String fileName) {
        List<Carte> listaCarti = new ArrayList<Carte>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowHeader = rowIterator.next();
            //Itereaza fiecare rind
            while (rowIterator.hasNext()) {
                Carte carte = new Carte();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                //Iterator pentru celule
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    if (cell.getColumnIndex() == 0) {
                        carte.setNrDeInregistrare((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 1) {
                        carte.setTitlu(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        carte.setAutor(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 3) {
                        carte.setLoculPublicarii(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        carte.setAnulPublicarii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 5) {
                        carte.setISBN((long) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 6) {
                        carte.setGen(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 7) {
                        carte.setClasificareCZU(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 8) {
                        carte.setNumarInventar((int) cell.getNumericCellValue());
                    } else if (cell.getColumnIndex() == 9) {
                        carte.setDataPrimirii(Date.valueOf(cell.getStringCellValue()));
                    } else if (cell.getColumnIndex() == 10) {
                        carte.setRepartizareOficii(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 11) {
                        carte.setTipDocument(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 12) {
                        carte.setLimbaDeEditare(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 13) {
                        carte.setDescriereaBibliografica(cell.getStringCellValue());
                    }
                }
                listaCarti.add(carte);
            }
            fis.close();
            workBook = null;
        } catch (Exception e) {
            Logger.getLogger(CarteIOExcelImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaCarti;
    }
}
