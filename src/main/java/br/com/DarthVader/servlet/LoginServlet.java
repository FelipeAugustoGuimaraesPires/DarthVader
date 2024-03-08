package br.com.DarthVader.servlet;

import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        String senhaCriptografada;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            senhaCriptografada = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            senhaCriptografada=senha;
            e.printStackTrace();
        }

        Usuario user = new Usuario(email, senhaCriptografada);

         boolean isValid = new UsuarioDAO().VerificarLogin(user);

         if (isValid){
             req.getSession().setAttribute("loggedUser", email);

             resp.sendRedirect("PaginaInicial.jsp");
         }else {
             req.setAttribute("mensagem", "login inválido");

             req.getRequestDispatcher("index.jsp").forward(req, resp);
         }
    }
}
