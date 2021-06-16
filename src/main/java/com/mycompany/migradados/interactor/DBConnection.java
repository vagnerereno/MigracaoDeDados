/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.migradados.interactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vagne
 */
public class DBConnection {

    String DB_CONNECTION = "pg";
    String PG_HOST = "jdbc:postgresql://localhost";
    String PG_PORT = "5432";
    String PG_USER = "postgres";
    String PG_PASSWORD = "database";
    String PG_DB_NAME = "inovadigital";

    public Connection connect() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(PG_HOST + ":" + PG_PORT + "/" + PG_DB_NAME, PG_USER, PG_PASSWORD);
            System.out.println("Conexão realizada com sucesso.");
        } catch (ClassNotFoundException e) {
            // Erro caso o driver JDBC não foi instalado
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();
        }
        return conexao;
    }

    public int executaSql(String sql) {
        try {
            Statement stm = connect().createStatement();
            int res = stm.executeUpdate(sql);
            connect().close();
            return res;
       } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    
    }
}
