package org.example.SingletonAplicado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDBComSingleton {
    private static ConexaoDBComSingleton instance;
    private final Connection connection;

    private ConexaoDBComSingleton() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/singleton";
            String username = "root";
            String password = "";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static synchronized ConexaoDBComSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexaoDBComSingleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConexaoDBComSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
