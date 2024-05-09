package br.com.DarthVader.servlet.Cliente;

import br.com.DarthVader.dao.ClienteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tornar-endereco-faturamento")
public class TornarFaturamentoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Id=req.getParameter("id");

        new ClienteDAO().DesabilitarEndereco(Id);

        resp.sendRedirect("/lista-endereco");
    }
}
