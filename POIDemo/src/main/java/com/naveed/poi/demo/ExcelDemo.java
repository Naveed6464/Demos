/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.poi.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nmrehman
 */
public class ExcelDemo {

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    public void read() throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(new File("demo.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        for (Iterator<Row> rows = sheet.iterator(); rows.hasNext();) {
            XSSFRow row = (XSSFRow) rows.next();
            for (Iterator<Cell> cells = row.iterator(); cells.hasNext();) {
                XSSFCell cell = (XSSFCell) cells.next();
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case 0:
                        //aBook.setTitle((String) getCellValue(nextCell));
                        System.out.println("0  " +getCellValue(cell));
                        break;
                    case 1:
                        //aBook.setTitle((String) getCellValue(nextCell));
                        System.out.println(getCellValue(cell));
                        break;
                    case 2:
                        System.out.println(getCellValue(cell));
                        //aBook.setAuthor((String) getCellValue(nextCell));
                        break;
                    case 3:
                        System.out.println(getCellValue(cell));
                        //aBook.setPrice((double) getCellValue(nextCell));
                        break;
                }
            }
            System.out.println();
        }
    }

    public void demo() {
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 1000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }

        // Rows with rownum < 900 are flushed and not accessible
        for (int rownum = 0; rownum < 900; rownum++) {
            //Assert.assertNull(sh.getRow(rownum));
        }

        // ther last 100 rows are still in memory
        for (int rownum = 900; rownum < 1000; rownum++) {
            //Assert.assertNotNull(sh.getRow(rownum));
        }

        //FileOutputStream out = new FileOutputStream("/temp/sxssf.xlsx");
        //wb.write(out);
        //out.close();
        // dispose of temporary files backing this workbook on disk
        //wb.dispose();
    }

}
