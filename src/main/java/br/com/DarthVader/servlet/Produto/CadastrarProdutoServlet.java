package br.com.DarthVader.servlet.Produto;

import br.com.DarthVader.dao.ProdutoDAO;
import br.com.DarthVader.modal.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastrar-produto")
public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String prodNome=req.getParameter("Prod-Nome");
        String avaliacao=req.getParameter("Prod-Avaliacao");
        String prodDescricao=req.getParameter("Prod-Descricao");
        String preco=req.getParameter("Prod-Preco");
        String estoque=req.getParameter("Prod-Quantidade");
        String prodID=req.getParameter("id");

        double prodPreco = Double.parseDouble(preco.replace(",", "."));
        int prodEstoque = Integer.parseInt(estoque);
        int prodAvaliacao = Integer.parseInt(avaliacao);


        Produto produto = new Produto(prodID, prodNome, prodAvaliacao, prodDescricao, prodPreco, prodEstoque);
        System.out.println(produto.getId());

        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (prodID.isEmpty()){
            produtoDAO.cadastroProduto(produto);
        }else{
            produtoDAO.alterarProduto(produto);
        }

        resp.sendRedirect("/achar-todos-produtos");
    }
}
