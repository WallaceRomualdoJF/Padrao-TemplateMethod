package org.example.wallace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GerenciadorTransacao {
    private Connection connection;
    protected void abrirConexao() throws SQLException {
        // Lógica para abrir uma conexão com o banco de dados
        connection = DriverManager.getConnection("url_do_banco", "usuario", "senha");
    }

    protected void fecharConexao() {
        try {
            // Lógica para fechar a conexão com o banco de dados
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Tratar a exceção
        }
    }

    protected void iniciarTransacao() throws SQLException {
        // Lógica para iniciar a transação no banco de dados
        connection.setAutoCommit(false);
    }

    protected void confirmarTransacao() {
        try {
            // Lógica para confirmar a transação no banco de dados
            connection.commit();
        } catch (SQLException e) {
            // Tratar a exceção
        }
    }

    protected void desfazerTransacao() {
        try {
            // Lógica para desfazer a transação no banco de dados
            connection.rollback();
        } catch (SQLException e) {
            // Tratar a exceção
        }
    }

    protected abstract void validarTransacao() throws Exception;
    protected abstract void finalizarTransacao() throws Exception;
}