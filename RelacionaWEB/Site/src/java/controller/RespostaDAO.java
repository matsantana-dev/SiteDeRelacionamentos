/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Banco;
import model.Resposta;

/**
 *
 * @author Mathias
 */
public class RespostaDAO {
    
    public void cadastrar(Resposta obj) throws Exception {
        Banco banco;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("INSERT INTO Resposta (cpfuser, r1, r2, r3) VALUES (?, ?, ?, ?)");
            
            banco.comando.setString(1, obj.getCpfuser());
            banco.comando.setString(2, obj.getR1()+"");
            banco.comando.setString(3, obj.getR2()+"");
            banco.comando.setString(4, obj.getR3()+"");
            banco.comando.executeUpdate();
            Banco.conexao.close();
        } catch (Exception ex) {
            throw new Exception("Erro no cadastrar-rd: " + ex.getMessage());
        }
    }
    
    public Resposta buscaResp(String cpf) throws Exception {
        Banco banco;
        Resposta obj;
        try {
            obj = null;
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("SELECT cpfuser, r1, r2, r3 FROM Resposta WHERE cpfuser = ?");
            banco.comando.setString(1, cpf);
            banco.tabela = banco.comando.executeQuery();

            if (banco.tabela.next()) {
                obj = new Resposta();
                obj.setCpfuser(banco.tabela.getString("cpfuser"));
                obj.setR1(banco.tabela.getString("r1").charAt(0));
                obj.setR2(banco.tabela.getString("r2").charAt(0));
                obj.setR3(banco.tabela.getString("r3").charAt(0));
            }
            Banco.conexao.close();
            return obj;
        } catch (Exception ex) {
            throw new Exception("Erro no buscaResp-rd: " + ex.getMessage());
        }
    }
}
