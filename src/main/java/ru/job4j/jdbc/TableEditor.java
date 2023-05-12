package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("statement.properties")) {
            properties.load(in);
        }
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void processingRequest(String script) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(script);
        }
    }

    public void createTable(String tableName) throws SQLException {
        String script = String.format(
                "CREATE TABLE IF NOT EXISTS %s (%s, %s);", tableName,
                "id SERIAL PRIMARY KEY",
                "name TEXT"
        );
        processingRequest(script);
    }

    public void dropTable(String tableName) throws SQLException {
        String script = String.format("DROP TABLE IF EXISTS %s ;", tableName);
        processingRequest(script);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String script = String.format("ALTER TABLE %s "
                + "ADD COLUMN %s %s;", tableName, columnName, type);
        processingRequest(script);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String script = String.format("ALTER TABLE %s DROP COLUMN %s;",
                tableName, columnName);
        processingRequest(script);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String script = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName, columnName, newColumnName);
        processingRequest(script);
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.createTable("test_table");
        System.out.println("1. Create table:\n" + tableEditor.getTableScheme("test_table"));
        tableEditor.addColumn("test_table", "age", "int");
        System.out.println("2. Add column:\n" + tableEditor.getTableScheme("test_table"));
        tableEditor.dropColumn("test_table", "age");
        System.out.println("3. Drop column:\n" + tableEditor.getTableScheme("test_table"));
        tableEditor.renameColumn("test_table", "name", "new_column");
        System.out.println("4. Rename column:\n" + tableEditor.getTableScheme("test_table"));
        tableEditor.dropTable("test_table");
        System.out.println("5. Drop table:\n" + tableEditor.getTableScheme("test_table"));

    }
}