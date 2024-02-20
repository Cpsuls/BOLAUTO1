package sample;

import static sample.StringManipulators.HANDLER;
import static sample.StringManipulators.SCAN;

public class Exceliks {
    public static void retdata() throws Exception {
        System.out.println("������� ��� ����� Excel, � ������� ��������� ��� ���� ������ (��������� ���� ����)");
        SCAN.nextLine();
        String excel_name = SCAN.nextLine();
        Excelik exik = new Excelik();
        String[][] data_table = HANDLER.selectAll(Const.OPERATIONS_TABLE);
        exik.inputsEx(data_table, excel_name);
        System.out.println("��������� ������ �� ������� �������� ������� - " + Const.OPERATIONS_TABLE + ":");
        System.out.println("������ �� ������� Excel: " + excel_name);
        exik.outputEx(excel_name);
    }
}
