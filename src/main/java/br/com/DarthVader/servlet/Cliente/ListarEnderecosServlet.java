package br.com.DarthVader.servlet.Cliente;

import br.com.DarthVader.dao.ClienteDAO;
import br.com.DarthVader.modal.Cliente;
import br.com.DarthVader.modal.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lista-endereco")
public class ListarEnderecosServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = new ClienteDAO().AchaIDEmail(req.getParameter("email"));
        List<Endereco> endereco = new ClienteDAO().ListarEnderecos(id);

        req.setAttribute("endereco", endereco);

        req.getRequestDispatcher("./Cliente/ListarEnderecos.jsp").forward(req, resp);
    }
}
