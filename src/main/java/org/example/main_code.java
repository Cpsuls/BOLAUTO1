package org.example;

import org.example.sample.Const;
import org.example.sample.Excelik;
import org.example.sample.Handler;
import org.example.sample.StringManipulators;

import java.util.InputMismatchException;

import static org.example.sample.Change.changes;
import static org.example.sample.Exceliks.retdata;
import static org.example.sample.StringManipulators.HANDLER;
import static org.example.sample.StringManipulators.SCAN;

public class main_code {
    public static void main(String[] args) throws Exception {
        StringManipulators sms = new StringManipulators();
        System.out.println("Это текстовое задание группы №2");
        System.out.println("Текущая активная таблица: " + Const.OPERATIONS_TABLE + "\n");
        System.out.println("Консольное меню:");
        System.out.println("""
                1. Вывести все таблицы из MySQL.
                2. Создать таблицу в MySQL.
                3.Экспорт данных из Excel, потом в mysql
                4. Экспорт по столбцу
                5.Экспорт по посту
                6. Экспорт по дате и посту""");
        System.out.println("""
                Система такая:
                1.Вводим команду
                2.Нажимаем Enter
                3.Вводим данные при необходимости""");
        int command = 0;
        while (true) {
            try {
                command = SCAN.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Это не команда, бро");
            }

            switch (command) {
                case 1 -> HANDLER.displayData();
                case 2 -> HANDLER.createNew();
//                case 3 -> StringManipulators.reverseString();
//                case 4 -> StringManipulators.uniteStrings();
//                case 100 -> StringManipulators.changeRegister();
//                case 6 -> StringManipulators.ending();
                case 4 -> Excelik.readDataByColumnName();
//                case 5 -> retdata();
                case 5-> Handler.getRow();
//                case 11 -> changes();
                case 3->Excelik.outputEx();
                case 6->Handler.getRowDate();
                default -> System.out.println("Попробуй еще раз!");
            }
        }
//
    }
}




