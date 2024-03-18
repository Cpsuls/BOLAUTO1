package org.example.sample;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.example.sample.StringManipulators.SCAN;

public class Excelik {
    public static void outputEx() throws Exception {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\kosta\\OneDrive\\Рабочий стол\\Urovni2_1_1_new_1_2.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String[] datas = new String[11];

        System.out.println("Введите количество строк для вывода: ");
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int numCols = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < numCols; i++) {
            Cell cell = sheet.getRow(0).getCell(i);
            if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                System.out.printf("%-25s", cell.getNumericCellValue());
            } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                System.out.printf("%-25s", "NULL");
            } else if (cell.getCellType() ==XSSFCell.CELL_TYPE_STRING ) {
                System.out.printf("%-25s", cell.getStringCellValue());
            }
        }
        System.out.println();

        for (int i = 1; i <= numRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < numCols && j < numRows; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            datas[j] = new SimpleDateFormat("dd.MM.yyyy").format(date);
                            System.out.printf("%-25s", new SimpleDateFormat("dd.MM.yyyy").format(date));
                        } else {
                            System.out.printf("%-25s", cell.getNumericCellValue());
                            datas[j] = String.valueOf(cell.getNumericCellValue());
                        }
                    } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                        System.out.printf("%-25s", "NULL");
                        datas[j] = "NULL";
                    } else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        System.out.printf("%-25s", cell.getStringCellValue());
                        datas[j] = cell.getStringCellValue();
                    }

                    }
                else{
                    System.out.printf("%-25s", "NULL");
                    datas[j] = "NULL";
                }
            }
            System.out.println();
            Handler.enterRes(datas);
        }

        }

    public static void readDataByColumnName() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Введите имя столбца");
        SCAN.nextLine();
        String columnName = SCAN.nextLine();
        FileInputStream file = new FileInputStream(new File("C:\\Users\\kosta\\OneDrive\\Рабочий стол\\Urovni2_1_1_new_1_2.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        ArrayList<String> list = new ArrayList<>();
        String[] name_columns = {"Object_ID", "Код_поста", "Код_параметра", "Дата_время", "Уровень_воды",
                "Описание", "Температура_воздуха", "Атмосферное_давление", "Скорость_ветра",
                "Толщина_снежного_покрова", "Количество_осадков"};
        DataFormatter dataFormatter = new DataFormatter();
        int columnIdx = -1;
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            if (dataFormatter.formatCellValue(cell).equalsIgnoreCase(columnName)) {
                columnIdx = cell.getColumnIndex();
                break;
            }
        }

        if (columnIdx == -1) {
            System.out.println("Столбец с именем '" + columnName + "' не найден.");
            return;
        }
        list.add(name_columns[columnIdx]);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(columnIdx);
            String cellValue = dataFormatter.formatCellValue(cell);
            list.add(cellValue);
        }
        System.out.println("Сколько строк вывести?");
        int numRows = SCAN.nextInt();

        System.out.println("Данные из столбца '" + columnName + "':");
        for (int i = 1; i <= numRows && i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Handler.enterResOneCol(list);

        workbook.close();
        file.close();
    }

}




//    public void inputsEx(String[][] data, String path_name) throws Exception {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet newSheet = workbook.createSheet("Листик");
//        for (int i = 0; i < data.length; i++) {
//            Row row = newSheet.createRow(i);
//            for (int j = 0; j < data[i].length; j++) {
//                Cell cell = row.createCell(j);
//                cell.setCellValue(data[i][j]);
//                newSheet.setColumnWidth(j, 25 * 256); // Устанавливаем ширину столбца на 25 символов
//            }
//        }
//        try {
//            FileOutputStream fileOut = new FileOutputStream("C:\\javaprojects\\" + path_name + ".xlsx");
//            workbook.write(fileOut);
//            fileOut.close();
//            System.out.println("Проверяй папку, там твои данные в " + path_name + ".xlsx");
//        } catch (Exception e) {
//            System.out.println("Бро, проблемы с Excel");
//        }
//    }
//}

