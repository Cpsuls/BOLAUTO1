package sample;
import java.util.Scanner;
public class StringManipulators {
    public static String FIRST_STRING="";
    public static String SECOND_STRING="";
    public static Scanner SCAN=new Scanner(System.in);
    public static Handler HANDLER=new Handler();
    public static String THIRD_STRING;
    public static void inSqlOut(){
        System.out.println("Введите первую строку");
        FIRST_STRING = SCAN.next();
        System.out.println(FIRST_STRING);
        System.out.println("Введите вторую строку");
        SECOND_STRING = SCAN.next();
        HANDLER.enterRes("3", FIRST_STRING, SECOND_STRING);
    }
    public static void getSizeOfStrings(){
        System.out.println("Введите первую строку");
        FIRST_STRING = SCAN.next();
        HANDLER.enterRes("4", FIRST_STRING, String.valueOf(FIRST_STRING.length()));
        System.out.println(FIRST_STRING + "Длина строки:" + FIRST_STRING.length());
        System.out.println("Введите 2 строку");
        SECOND_STRING = SCAN.next();
        HANDLER.enterRes("4", SECOND_STRING, String.valueOf(SECOND_STRING.length()));
        System.out.println(SECOND_STRING + "Длина строки:" + SECOND_STRING.length());
    }
    public static void uniteStrings(){
        System.out.println("Введите первую строку");
        FIRST_STRING = SCAN.next();
        System.out.println("Введите вторую строку");
        SECOND_STRING = SCAN.next();
        THIRD_STRING=FIRST_STRING.concat(SECOND_STRING);
        System.out.println(THIRD_STRING);
        HANDLER.enterRes("5", THIRD_STRING, String.valueOf(THIRD_STRING.length()));
    }
    public static void compareStrings(){
        System.out.println("Введите первую строку");
        FIRST_STRING = SCAN.next();
        System.out.println("Введите вторую строку");
        int compares=FIRST_STRING.compareTo(SECOND_STRING);
        HANDLER.enterRes("6", FIRST_STRING.concat(SECOND_STRING), String.valueOf(compares));
        System.out.println(compares);

    }
}
