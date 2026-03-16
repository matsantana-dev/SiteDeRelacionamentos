/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Banco;
import model.Usuario;

/**
 *
 * @author Mathias
 */
public class UsuarioDAO {
    
    public Usuario login(String login, String senha) throws Exception {
        Banco banco;
        Usuario obj = null;
        String sql;
        try {
            banco = new Banco();
            sql = "SELECT cpf, nome, login, senha, cep, rua, numero, bairro, cidade FROM Usuario WHERE login =? AND senha =?";
            banco.comando = Banco.conexao.prepareStatement(sql);
            banco.comando.setString(1, login);
            banco.comando.setString(2, senha);
            banco.tabela = banco.comando.executeQuery();
            
            if (banco.tabela.next()) {
                obj = new Usuario();
                obj.setCpf(banco.tabela.getString(1));
                obj.setNome(banco.tabela.getString(2));
                obj.setLogin(banco.tabela.getString(3));
                obj.setSenha(banco.tabela.getString(4));
                obj.setCep(banco.tabela.getString(5));
                obj.setRua(banco.tabela.getString(6));
                obj.setNumero(banco.tabela.getString(7));
                obj.setBairro(banco.tabela.getString(8));
                obj.setCidade(banco.tabela.getString(9));
            } 
            Banco.conexao.close();
            return obj;
        } catch (Exception ex) {
            throw new Exception("Erro no Login-D: " + ex.getMessage());
        }
    }
    
    public void cadastrar(Usuario obj) throws Exception {
        Banco banco;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("INSERT INTO Usuario (cpf, nome, login, senha, cep, rua, numero, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            banco.comando.setString(1, obj.getCpf());
            banco.comando.setString(2, obj.getNome());
            banco.comando.setString(3, obj.getLogin());
            banco.comando.setString(4, obj.getSenha());
            banco.comando.setString(5, obj.getCep());
            banco.comando.setString(6, obj.getRua());
            banco.comando.setString(7, obj.getNumero());
            banco.comando.setString(8, obj.getBairro());
            banco.comando.setString(9, obj.getCidade());
            banco.comando.executeUpdate();

            Banco.conexao.close();
        } catch (Exception ex) {
            throw new Exception("Erro no Cadastro-D: " + ex.getMessage());
        }
    }
    
    public Usuario preencher(String cpf) throws Exception {
        Banco banco;
        Usuario obj = null;
        try {
            banco = new Banco();
            banco.comando = Banco.conexao.prepareStatement("SELECT cpf, nome, login, senha, cep, rua, numero, bairro, cidade FROM Usuario WHERE cpf =?");
            banco.comando.setString(1, cpf);
            banco.tabela = banco.comando.executeQuery();
            
            if (banco.tabela.next()) {
                obj = new Usuario();
                obj.setCpf(banco.tabela.getString(1));
                obj.setNome(banco.tabela.getString(2));
                obj.setLogin(banco.tabela.getString(3));
                obj.setCep(banco.tabela.getString(5));
                obj.setRua(banco.tabela.getString(6));
                obj.setNumero(banco.tabela.getString(7));
                obj.setBairro(banco.tabela.getString(8));
                obj.setCidade(banco.tabela.getString(9));
            } 
            Banco.conexao.close();
            return obj;
        } catch (Exception ex) {
            throw new Exception("Erro no preencher-D: " + ex.getMessage());
        }
    }
    
    public List<Usuario> buscarOutros(String cpf) throws Exception {
        Banco banco;
        List<Usuario> lista;
        try {
            banco = new Banco();
            lista = new ArrayList<>();
            banco.comando = Banco.conexao.prepareStatement("SELECT cpf, nome, login, senha, cep, rua, numero, bairro, cidade FROM Usuario WHERE cpf != ?");
            banco.comando.setString(1, cpf);
            banco.tabela = banco.comando.executeQuery();
            
            while (banco.tabela.next()) {
                Usuario obj = new Usuario();
                obj.setCpf(banco.tabela.getString("cpf"));
                obj.setNome(banco.tabela.getString("nome"));
                obj.setLogin(banco.tabela.getString("login"));
                obj.setCep(banco.tabela.getString("cep"));
                obj.setRua(banco.tabela.getString("rua"));
                obj.setNumero(banco.tabela.getString("numero"));
                obj.setBairro(banco.tabela.getString("bairro"));
                obj.setCidade(banco.tabela.getString("cidade"));
                lista.add(obj);
            }
            Banco.conexao.close();
            return lista;
        } catch (Exception ex) {
            throw new Exception("Erro no buscarOutros-D: " + ex.getMessage());
        }
    } 
}
