package org.example.sample;

import static org.example.sample.StringManipulators.HANDLER;
import static org.example.sample.StringManipulators.SCAN;

public class Exceliks {
    public static void retdata() throws Exception {
        System.out.println("Введите имя файла Excel, в который перенесем все ваши данные (создастся этот файл)");
        SCAN.nextLine();
        String excel_name = SCAN.nextLine();
        Excelik exik = new Excelik();
        String[][] data_table = HANDLER.selectAll(Const.OPERATIONS_TABLE);
        exik.inputsEx(data_table, excel_name);
        System.out.println("Занеслись данные из текущей активной таблицы - " + Const.OPERATIONS_TABLE + ":");
        System.out.println("Данные из таблицы Excel: " + excel_name);
        exik.outputEx(excel_name);
    }
}
