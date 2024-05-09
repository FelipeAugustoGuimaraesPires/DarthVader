package br.com.DarthVader.servlet.Produto;

import br.com.DarthVader.dao.ProdutoDAO;
import br.com.DarthVader.modal.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/achar-todos-produtos-cliente")
public class ListarProdutoClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = new ProdutoDAO().ListarProdutos();

        req.setAttribute("produtos", produtos);

        req.getRequestDispatcher("./Cliente/TelaVitrine.jsp").forward(req, resp);
    }
}
