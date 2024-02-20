package org.example.sample;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class Excelik {
    public void outputEx(String path_name) throws Exception {
        try{
            System.out.println(path_name);
            FileInputStream file = new FileInputStream(new File("C:\\javaprojects\\"+path_name+".xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file); // Объект для доступа к файлу
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue() + "\t\t");
                }
                System.out.print("\n");

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void inputsEx(String[][] data, String path_name) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet newSheet = workbook.createSheet("Листик");
        for (int i = 0; i < data.length; i++) {
            Row row = newSheet.createRow(i); // Объект Row для строк
            for (int j = 0; j < data[i].length; j++) {
                row.createCell(j).setCellValue(data[i][j]);
            }
        }
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\javaprojects\\"+path_name+".xlsx"); // Поток для файла, создает его по определенному пути
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Проверяй папку, там твои данные в " + path_name + ".xlsx");
        }
        catch (Exception e){
            System.out.println("Бро, проблемы с Excel");
        }
    }
}
