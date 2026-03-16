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
import model.Resposta;
import model.Usuario;

/**
 *
 * @author Mathias
 */
@WebServlet(name = "Cadastrar", urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

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
        Usuario obj;
        Resposta robj;
        UsuarioDAO dao;
        RespostaDAO rdao;
        // ---------- //
        String cpf = request.getParameter("txtCPF").replaceAll("\\D", "");
        String nome = request.getParameter("txtNome");
        String senha = request.getParameter("txtSenha");
        String login = request.getParameter("txtLogin");
        // ---------- //
        String cep = request.getParameter("txtCEP");
        String rua = request.getParameter("txtRua");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String numero = request.getParameter("txtNum");
        // ---------- //
        String r1 = request.getParameter("txtR1");
        String r2 = request.getParameter("txtR2");
        String r3 = request.getParameter("txtR3");
        
        try {
            obj = new Usuario();
            robj = new Resposta();
            dao = new UsuarioDAO();
            rdao = new RespostaDAO();
            
            obj.setCpf(cpf);
            obj.setNome(nome);
            obj.setLogin(login);
            obj.setSenha(senha);
            obj.setCep(cep);
            obj.setRua(rua);
            obj.setNumero(numero);
            obj.setBairro(bairro);
            obj.setCidade(cidade);
            
            dao.cadastrar(obj);
            
            robj.setCpfuser(cpf);
            robj.setR1(r1.charAt(0));
            robj.setR2(r2.charAt(0));
            robj.setR3(r3.charAt(0));
            
            rdao.cadastrar(robj);
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='pt-br'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Cadastro Realizado</title>");
            out.println("<link rel='stylesheet' href='css/confirmacao.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='msg'>");
            out.println("<h2>Cadastro realizado com sucesso!</h2>");
            out.println("<p>Bem-vindo(a), " + nome + "! Você foi cadastrado(a) com sucesso!</p>");
            out.println("<a href='login.html'>Faça o Login</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro no S-Cadastrar: " + ex.getMessage() + "</h1>");
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
