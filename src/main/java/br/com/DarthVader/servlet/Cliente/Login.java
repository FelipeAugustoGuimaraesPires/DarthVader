package br.com.DarthVader.servlet.Cliente;


import br.com.DarthVader.dao.ClienteDAO;
import br.com.DarthVader.modal.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-cliente")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Cliente/TelaDeLogin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Cliente cliente = new Cliente(email, senha);


        boolean isValid = new ClienteDAO().VerificarLogin(cliente);

        if (isValid){

            String nome = new ClienteDAO().AchaNome(cliente);
            req.getSession().setAttribute("loggedUser", nome);
            req.getSession().setAttribute("email", email);

            resp.sendRedirect("/achar-todos-produtos-cliente");
        }else{
            req.setAttribute("mensagem", "login inválido");

            req.getRequestDispatcher("/Cliente/TelaDeLogin.jsp").forward(req, resp);
        }
    }
}

