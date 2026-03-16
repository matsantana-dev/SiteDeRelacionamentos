/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Mathias
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        Usuario usuario;
        UsuarioDAO dao;
        
        try {
            dao = new UsuarioDAO();
            usuario = dao.login(login, senha);
            
        if (usuario != null) {
            sessao.setAttribute("usuario", usuario);
            sessao.setAttribute("cpfuser", usuario.getCpf());
            out.println("<!DOCTYPE html>");
            out.println("<html lang='pt-br'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Login Bem-Sucedido</title>");
            out.println("<link rel='stylesheet' href='css/confirmacao.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='msg'>");
            out.println("<h2>Login realizado com sucesso!</h2>");
            out.println("<p>Bem-vindo(a) de volta, " + usuario.getNome() + "!</p>");
            out.println("<a href='Listar'>Procurar Par</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='pt-br'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Login</title>");
            out.println("<link rel='stylesheet' href='css/confirmacao.css'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='msg'>");
            out.println("<h2>Login inválido!</h2>");
            out.println("<p>Verifique seu login e senha e tente novamente.</p>");
            out.println("<a href='login.html'>Tentar novamente</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            }
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro no S-Login: " + ex.getMessage() + "</h1>");
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
