package model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
  *
  * @author Mathias
  */
public class Banco {

     public static Connection conexao = null;
     public PreparedStatement comando = null;
     public ResultSet tabela = null;
     
     public Banco() throws Exception {
         try {
             Class.forName("org.postgresql.Driver");
             if ((conexao == null) || (conexao.isClosed())) {
                 conexao =
DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/WEBTrab2","postgres", "ifsp");
             }
         } catch (Exception ex) {
             throw new Exception("Erro de conexao:" + ex.getMessage());
         }
     }
}
