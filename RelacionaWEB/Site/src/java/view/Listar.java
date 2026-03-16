/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.RespostaDAO;
import controller.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Mathias
 */
@WebServlet(name = "Listar", urlPatterns = {"/Listar"})
public class Listar extends HttpServlet {
    
        // Clase auxiliar pra definir os pontos, explico no Bubble Sort 
            class UsuarioPonto {
                private Usuario usuario;
                private int pontuacao;
                
                public UsuarioPonto(Usuario usuario, int pontuacao) {
                    this.usuario = usuario;
                    this.pontuacao = pontuacao;
                }
                public Usuario getUsuario() {
                    return usuario;
                }
                public int getPontuacao() {
                    return pontuacao;
                }
            }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession sessao = request.getSession();
        String cpf;
        UsuarioDAO dao;
        Resposta logado;
        RespostaDAO rdao;
        List<Usuario> lista;
        List<UsuarioPonto> listapontos;
        int ponto;
        
                
                
        try {
            
            cpf = (String) sessao.getAttribute("cpfuser");

        if (cpf == null) {
            out.println("<html>");
            out.println("<body>");
            out.println("<h2 align='center'>");
            out.println("Usuário não autenticado. Faça login novamente.");
            out.println("</h2>");
            out.println("</body>");
            out.println("</html>");
            return;
            }
        
            dao = new UsuarioDAO();
            rdao = new RespostaDAO();
            
            lista = dao.buscarOutros(cpf);
            logado = rdao.buscaResp(cpf);
            listapontos = new ArrayList<>();
            
            for (int i = 0; i < lista.size(); i++) {
                Usuario outros = lista.get(i);
                Resposta respostaoutros = rdao.buscaResp(outros.getCpf());
                ponto = 0;
                
                if (logado != null && respostaoutros != null) {
                    if (logado.getR1() == respostaoutros.getR1()) {
                        ponto++;
                    }
                    if (logado.getR2() == respostaoutros.getR2()) {
                        ponto++;
                    }
                    if (logado.getR3() == respostaoutros.getR3()) {
                        ponto++;
                    }
                }
                listapontos.add(new UsuarioPonto(outros, ponto));
            }

            for (int i = 0; i < listapontos.size() - 1; i++) {
                for (int x = 0; x < listapontos.size() - 1 - i; x++) {
                    if (listapontos.get(x).getPontuacao() < listapontos.get(x + 1).getPontuacao()) {
                        UsuarioPonto aux = listapontos.get(x);
                        listapontos.set(x, listapontos.get(x + 1));
                        listapontos.set(x + 1, aux);
                    }
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='pt-br'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Lista de Usuários</title>");
            out.println("<link rel='stylesheet' href='css/listagem.css'>");
            out.println("<script src='js/script.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Usuários cadastrados</h1>");
            if (listapontos.isEmpty()) {
                out.println("<p align='center'>Nenhum usuário encontrado.</p>");
            } else {
                out.println("<table class='tabela-usuarios'>");
                out.println("<thead>");
                out.println("<tr><th>Nome</th><th>Pontuação</th><th>Ação</th></tr>");
                out.println("</thead><tbody>");
                
                for (int i = 0; i < listapontos.size(); i++) {
                    Usuario obj = listapontos.get(i).getUsuario();
                    int pontos = listapontos.get(i).getPontuacao();
                    
                    out.println("<tr>");
                    out.println("<td>" + obj.getNome() + "</td>");
                    out.println("<td>" + pontos + "</td>");
                    // no 'onclick' eu puxo a função na pasta scripts e uso pra o botão funcionar
                    out.println("<td><button class='btn-detalhes' onclick=\"Detalhes('" + i + "')\">Ver detalhes</button></td>");
                    out.println("</tr>");
                    
                    out.println("<tr class='detalhes' id='detalhes-" + i + "' style='display:none;'>");
                    out.println("<td colspan='3'>");
                    out.println("<strong>Login:</strong> " + obj.getLogin() + "<br>");
                    out.println("<strong>CEP:</strong> " + obj.getCep() + "<br>");
                    out.println("<strong>CPF:</strong> " + obj.getCpf() + "<br>");
                    out.println("<strong>Rua:</strong> " + obj.getRua() + "<br>");
                    out.println("<strong>Número:</strong> " + obj.getNumero() + "<br>");
                    out.println("<strong>Bairro:</strong> " + obj.getBairro() + "<br>");
                    out.println("<strong>Cidade:</strong> " + obj.getCidade());
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody></table>");
            }
            out.println("</body></html>");
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Listar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro no S-Listar: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
