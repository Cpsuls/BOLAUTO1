package org.example.sample;

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
                3. Ввод двух строк, результат сохранить в MySQL с последующим выводом в консоль.
                4. Подсчитать размер двух строк, результат сохранить в MySQL с последующим выводом в консоль.
                5. Объединить две строки, результат сохранить в MySQL с последующим выводом в консоль.
                6. Сравнить две строки, результат сохранить в MySQL с последующим выводом в консоль.
                7. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран""");
        System.out.println("""
                Система такая: 
                1. Вводим команду 
                2.Нажимаем Enter 
                3. Вводим данные при необходимости""");
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
                case 3 -> sms.inSqlOut();
                case 4 -> sms.getSizeOfStrings();
                case 5 -> sms.uniteStrings();
                case 6 -> sms.compareStrings();
                case 7 -> retdata();
                case 11 -> changes();
                default-> System.out.println("Попробуй еще раз!");}
            }

        }
    }

