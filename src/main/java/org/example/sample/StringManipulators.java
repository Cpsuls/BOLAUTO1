package org.example.sample;
import java.util.Locale;
import java.util.Scanner;
public class StringManipulators {
    public static String FIRST_STRING = "";
    public static String SECOND_STRING = "";
    public static Scanner SCAN = new Scanner(System.in);
    public static Handler HANDLER = new Handler();
    public static int[] string_mas=new int[100];
    public static int i=0;
    public static String THIRD_STRING;

//    public static void inSqlOut() {
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine();
//        StringBuffer s_buffer_1 = new StringBuffer(FIRST_STRING.subSequence(0, FIRST_STRING.length()));
//        System.out.println(FIRST_STRING);
//        System.out.println("Введите вторую строку");
//        SECOND_STRING = SCAN.nextLine();
//        StringBuffer s_buffer_2 = new StringBuffer(SECOND_STRING.subSequence(0, SECOND_STRING.length()));
//        System.out.println(SECOND_STRING);
//        HANDLER.enterRes("3", FIRST_STRING, SECOND_STRING);
//        System.out.println("Данные занесены в базочку данных");
//    }

//    public static void getSizeOfStrings() {
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine();
//        StringBuffer s_buffer_1 = new StringBuffer(FIRST_STRING.subSequence(0, FIRST_STRING.length()));
//        HANDLER.enterRes("4", FIRST_STRING, String.valueOf(FIRST_STRING.length()));
//        System.out.println(FIRST_STRING + "Длина строки:" + FIRST_STRING.length());
//        System.out.println("Введите 2 строку");
//        SECOND_STRING = SCAN.nextLine();
//        StringBuffer s_buffer_2 = new StringBuffer(SECOND_STRING.subSequence(0, SECOND_STRING.length()));
//        HANDLER.enterRes("4", SECOND_STRING, String.valueOf(SECOND_STRING.length()));
//        System.out.println(SECOND_STRING + "Длина строки:" + SECOND_STRING.length());
//        System.out.println("Данные занесены в базочку данных");
//    }

//    public static void reverseString() {
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=FIRST_STRING.length();
//        i+=1;
//        StringBuffer s_buffer_1 = new StringBuffer(FIRST_STRING.subSequence(0, FIRST_STRING.length()));
//        HANDLER.enterRes("3", s_buffer_1.toString(), s_buffer_1.reverse().toString());
//        String formattedString1 = String.format("%-50s", s_buffer_1);
//        System.out.println(formattedString1);
//        System.out.println("Введите 2 строку");
//        SECOND_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=SECOND_STRING.length();
//        i+=1;
//        StringBuffer s_buffer_2 = new StringBuffer(SECOND_STRING.subSequence(0, SECOND_STRING.length()));
//        HANDLER.enterRes("3", s_buffer_2.toString(), s_buffer_2.reverse().toString());
//        String format = "%-50s\n%-50s";
//        System.out.printf(format, FIRST_STRING, SECOND_STRING);
//        System.out.println();
//        System.out.println("Данные занесены в базочку данных");
//    }
//
//    public static  void getOnindexes(){
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=FIRST_STRING.length();
//        i+=1;
//        System.out.println("ВВедите индекс начальный");
//        SCAN.nextLine();
//        int index_start = Integer.parseInt(SCAN.nextLine());
//        System.out.println("ВВедите индекс конечный");
//        SCAN.nextLine();
//        int index_end  = Integer.parseInt(SCAN.nextLine());
//        HANDLER.enterRes("8", FIRST_STRING,FIRST_STRING.substring(index_start,index_end));
//        String formattedString1 = String.format("%-50s", FIRST_STRING.substring(index_start,index_end));
//        System.out.println(formattedString1);
//    }
//
//    public static  void changeRegister(){
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=FIRST_STRING.length();
//        i+=1;
//        HANDLER.enterRes("100", FIRST_STRING.toLowerCase(),FIRST_STRING.toUpperCase());
//        String formattedString1 = String.format("%-50s", FIRST_STRING.toUpperCase());
//        System.out.println(formattedString1);
//    }
//
//    public static  void ending(){
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=FIRST_STRING.length();
//        i+=1;
//        int length=FIRST_STRING.length();
//        String ends=FIRST_STRING.substring(length-2,length);
//        HANDLER.enterRes("6", FIRST_STRING,ends);
//        System.out.println(ends);
//        SECOND_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=SECOND_STRING.length();
//        i+=1;
//        if(FIRST_STRING.contains(SECOND_STRING)){
//            System.out.println("Подстрока найдена");
//            HANDLER.enterRes("6", FIRST_STRING,SECOND_STRING);
//        }
//        String formattedString1 = String.format("%-50s", SECOND_STRING);
//        System.out.println(formattedString1);
//    }
//
//
//
//
//
//    public static void uniteStrings() {
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=FIRST_STRING.length();
//        i+=1;
//        StringBuffer s_buffer_1 = new StringBuffer(FIRST_STRING.subSequence(0, FIRST_STRING.length()));
//        System.out.println(FIRST_STRING);
//        System.out.println("Введите вторую строку");
//        SECOND_STRING = SCAN.nextLine().replaceAll(" ", "");
//        string_mas[i]=SECOND_STRING.length();
//        i+=1;
//        StringBuffer s_buffer_2 = new StringBuffer(SECOND_STRING.subSequence(0, SECOND_STRING.length()));
//        System.out.println(SECOND_STRING);
//        StringBuffer s_buffer_3 = new StringBuffer(FIRST_STRING.subSequence(0, FIRST_STRING.length())).append(s_buffer_2);
//        System.out.println(s_buffer_3);
//        HANDLER.enterRes("4", s_buffer_3.toString(), s_buffer_3.toString());
//        String format = "%-50s\n%-50s";
//        System.out.printf(format, FIRST_STRING, SECOND_STRING);
//        System.out.println("Данные занесены в базочку данных");
//    }

//    public static void compareStrings() {
//        System.out.println("Введите первую строку");
//        SCAN.nextLine();
//        FIRST_STRING = SCAN.nextLine();
//        System.out.println(FIRST_STRING);
//        System.out.println("Введите вторую строку");
//        SECOND_STRING = SCAN.nextLine();
//        System.out.println(SECOND_STRING);
//        int compares = FIRST_STRING.compareTo(SECOND_STRING);
//        System.out.println(compares);
//        HANDLER.enterRes("6", FIRST_STRING.concat(SECOND_STRING), String.valueOf(compares));
//    }
}
