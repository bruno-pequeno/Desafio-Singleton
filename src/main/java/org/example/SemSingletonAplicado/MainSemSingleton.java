package org.example.SemSingletonAplicado;

import java.sql.Connection;
import java.sql.SQLException;

public class MainSemSingleton {
    public static void main(String[] args) {
        try {
            // Criar uma nova instância da classe de conexão
            ConexaoDBSemSingleton conexaoSemSingleton = new ConexaoDBSemSingleton();
            // Obter uma nova conexão a partir da instância
            Connection connection = conexaoSemSingleton.getConnection();

            // Usar a conexão (exemplo simples de verificação do estado da conexão)
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão sem Singleton estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão sem Singleton.");
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
