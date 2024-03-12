package br.com.DarthVader.servlet;

import br.com.DarthVader.config.Criptografia;
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
        Criptografia criptografia = new Criptografia();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario user = new Usuario(email, senha);


         boolean isValid = new UsuarioDAO().VerificarLogin(user);
         boolean isActive = new UsuarioDAO().VerificarHabilitado(user);

         if (isValid&&isActive){
             req.getSession().setAttribute("loggedUser", email);

             resp.sendRedirect("PaginaInicial.jsp");
         } else if (!isActive) {
             req.setAttribute("mensagem", "Usuário Inativado");

             req.getRequestDispatcher("index.jsp").forward(req, resp);

         }else{
             req.setAttribute("mensagem", "login inválido");

             req.getRequestDispatcher("index.jsp").forward(req, resp);
         }


    }
}
