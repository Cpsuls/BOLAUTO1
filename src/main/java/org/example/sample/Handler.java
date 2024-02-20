package org.example.sample;



import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.sample.StringManipulators.SCAN;


public class Handler extends DataConnect {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public String[] listTable() {
        String[] tables_list = new String[20];
        String select = "SHOW TABLES";
        int i = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            while (res_select.next()) {
                String tableName = res_select.getString(1);
                tables_list[i] = tableName;
                i += 1;
            }
            return tables_list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] selectAll(String table_name) {
        String select = "SELECT * FROM " + table_name;
        String[][] tables_list = new String[30][4];
        int i = 1;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            while (res_select.next()) {
                tables_list[i][0] = String.valueOf(res_select.getString(1));
                tables_list[i][1] = String.valueOf(res_select.getString(2));
                tables_list[i][2] = String.valueOf(res_select.getString(3));
                tables_list[i][3] = String.valueOf(res_select.getString(4));
                i += 1;
            }
            tables_list[0][0] = Const.OPERATIONS_ID;
            tables_list[0][1] = Const.OPERATIONS_NUMBERS;
            tables_list[0][2] = Const.OPERATIONS_CHARACTER;
            tables_list[0][3] = Const.OPERATIONS_RESULT;

            return tables_list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayData() {
        String select = "SHOW TABLES";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            System.out.println("Вот данные из таблиц: ");
            while (res_select.next()) {
                String tableName = res_select.getString(1);
                System.out.println("Table: " + tableName);

                String selectAllQuery = "SELECT * FROM " + tableName;
                try {
                    PreparedStatement prSt_1 = getDbConnection().prepareStatement(selectAllQuery);
                    ResultSet resultSet = prSt_1.executeQuery();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t\t");
                    }
                    System.out.println();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "  \t\t\t\t\t\t");
                        }
                        System.out.println();
                    }

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String createNew() {

        System.out.println("Введите имя новой таблицы: ");
        String new_name = SCAN.next();

        String create = "CREATE TABLE IF NOT EXISTS " + new_name + " ( " +
                Const.OPERATIONS_ID + " INT AUTO_INCREMENT PRIMARY KEY, " +
                Const.OPERATIONS_NUMBERS + " VARCHAR(100) NOT NULL, " +
                Const.OPERATIONS_CHARACTER + " VARCHAR(100) NOT NULL, " +
                Const.OPERATIONS_RESULT + " VARCHAR(100) NOT NULL" +
                ");";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(create);
            prSt.executeUpdate();
            System.out.println("Ура, мы создали таблицу " + new_name + "\n");
            System.out.println("Если вдруг захотите переключатся между таблицами вводите команду - 11\n");
            return new_name;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterRes(String com_tab, String Character_tab, String Result_tab) {
        String insert = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" + Const.OPERATIONS_NUMBERS + ", "
                + Const.OPERATIONS_CHARACTER + ", " + Const.OPERATIONS_RESULT + ")" + " VALUES (?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, com_tab);
            prSt.setString(2, Character_tab);
            prSt.setString(3, Result_tab);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}