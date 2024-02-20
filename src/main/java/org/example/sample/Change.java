package sample;

import static sample.StringManipulators.HANDLER;
import static sample.StringManipulators.SCAN;

public class Change {
    public static void changes(){
    System.out.println("Введите название таблицы, на которую хотите переключится \n");
    SCAN.nextLine();
    String table_active = SCAN.nextLine();
    String[] tabs = HANDLER.listTable();
    boolean found = false;
    for (String name : tabs) {
        if (name.equals(table_active)) {
            found = true;
            break;
        }
    }
    if (found) {
        Const.OPERATIONS_TABLE = table_active;
        found = false;
    }
    System.out.println("Текущая активная страница: " + Const.OPERATIONS_TABLE);
}
}
