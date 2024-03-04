package br.com.DarthVader.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail=req.getParameter("User-Email");

        System.out.println(userEmail);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
