package org.example.sample;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.example.sample.StringManipulators.SCAN;
import org.example.sample.StringManipulators;

public class Handler extends DataConnect {

    static Connection dbConnection;
    public static String format;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
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
        String[][] tables_list = new String[31][4];
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
                int max = StringManipulators.string_mas[0];
                for (int j = 1; j < StringManipulators.string_mas.length; j++) {
                    if (max < StringManipulators.string_mas[j]) {
                        max = StringManipulators.string_mas[j];
                    }
                }

                try {
                    PreparedStatement prSt_1 = getDbConnection().prepareStatement(selectAllQuery);
                    ResultSet resultSet = prSt_1.executeQuery();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    format = "%-" + (max + 50) + "s";

                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf(format, metaData.getColumnName(i));
                    }
                    System.out.println();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf(format, resultSet.getString(i));
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
        Const.OPERATIONS_TABLE = new_name;
        String create = "CREATE TABLE IF NOT EXISTS " + new_name + " ( " +
                "Object_ID TEXT, " +
                "Код_поста TEXT, " +
                "Код_параметра TEXT," +
                "Дата_время TEXT," +
                "Уровень_воды TEXT," +
                "Описание TEXT," +
                "Температура_воздуха TEXT," +
                "Атмосферное_давление TEXT," +
                "Скорость_ветра TEXT," +
                "Толщина_снежного_покрова TEXT," +
                "Количество_осадков TEXT" +
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

    public static void enterRes(String[] values) {
        String insert = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" +
                "Object_ID, Код_поста, Код_параметра, Дата_время, Уровень_воды, " +
                "Описание, Температура_воздуха, Атмосферное_давление, Скорость_ветра, " +
                "Толщина_снежного_покрова, Количество_осадков) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getDbConnection();
             PreparedStatement prSt = connection.prepareStatement(insert)) {
            for (int i = 0; i < values.length; i++) {
                prSt.setString(i + 1, values[i]); // Установка значения с индексом, начиная с 1
            }
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enterResOneCol(ArrayList<String> values) throws SQLException, ClassNotFoundException {
        System.out.println("Введите имя новой таблицы: ");
        String new_name = SCAN.next();
        Const.OPERATIONS_TABLE = new_name;
        String create = "CREATE TABLE IF NOT EXISTS " + new_name + " ( " + values.get(0) + " TEXT" +
                ");";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(create);
            prSt.executeUpdate();
            System.out.println("Ура, мы создали таблицу " + new_name + "\n");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String insert = "INSERT INTO " + new_name + " (" + values.get(0) + ") VALUES ";
        int numValues = values.size() - 1;

        for (int i = 1; i <= numValues; i++) {
            insert += "(?)";
            if (i < numValues) {
                insert += ", ";
            }
        }

        try (Connection connection = getDbConnection();
             PreparedStatement prSt = connection.prepareStatement(insert)) {
            for (int i = 1; i <= numValues; i++) {
                prSt.setString(i, values.get(i));
            }
            prSt.executeUpdate();
        }
    }

    public static void getRow() {
        String columnName = "Код_поста";
        SCAN.nextLine();
        String searchValue = SCAN.nextLine();
        try (Connection connection = getDbConnection()) {
            String sql = "SELECT * FROM fgf WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchValue);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println("Найденная строка:");
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String name = rsmd.getColumnName(i);
                    String value = resultSet.getString(name);
                    System.out.println(name + ": " + value);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void getRowDate() throws ParseException, SQLException, ClassNotFoundException {
        String columnName = "Код_поста";
        SCAN.nextLine();
        String searchValue = SCAN.nextLine();
        System.out.println("Введите дату в формате 'dd.MM.yyyy': ");
        SCAN.nextLine();
        String searchDate = SCAN.nextLine();
        String sql = "SELECT * FROM fgf WHERE " + columnName + " = ? AND Дата_время = ?";
        Connection connection = getDbConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, searchValue);
        statement.setString(2,  searchDate);
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData rsmd = resultSet.getMetaData();

        while (resultSet.next()) {
            System.out.println("Найденная строка:");
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String name = rsmd.getColumnName(i);
                String value = resultSet.getString(name);
                System.out.println(name + ": " + value);
            }
        }
    }
}




