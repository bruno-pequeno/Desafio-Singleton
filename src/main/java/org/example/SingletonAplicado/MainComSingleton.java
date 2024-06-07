package org.example.SingletonAplicado;

import java.sql.Connection;
import java.sql.SQLException;

public class MainComSingleton {
    public static void main(String[] args) {
        try {
            // Obter a instância única da conexão
            ConexaoDBComSingleton conexaoSingleton = ConexaoDBComSingleton.getInstance();
            // Obter a conexão a partir da instância singleton
            Connection connection = conexaoSingleton.getConnection();

            // Usar a conexão (exemplo simples de verificação do estado da conexão)
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão com Singleton estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão com Singleton.");
            }

            // Fechar a conexão
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
