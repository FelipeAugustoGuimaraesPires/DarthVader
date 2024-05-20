package br.com.DarthVader.servlet.Compra;

import br.com.DarthVader.config.Criptografia;
import br.com.DarthVader.dao.CarrinhoDAO;
import br.com.DarthVader.dao.ClienteDAO;
import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Carrinho;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adicionar-no-carrinho")
public class AdicionarNoCarrinhoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClienteDAO CliDAO = new ClienteDAO();
        CarrinhoDAO CarrinhoDAO = new CarrinhoDAO();

        String idProd=req.getParameter("id");
        String idCli= CliDAO.AchaIDEmail(req.getParameter("cliId"));


        Carrinho carrinho= new Carrinho();
        carrinho.setCliId(idCli);
        carrinho.setProdId(idProd);

        boolean jaTem=CarrinhoDAO.jaTem(carrinho);

        if (jaTem){
            resp.sendRedirect("/achar-todos-produtos-cliente");
        }else {
            CarrinhoDAO.criarCarrinho(carrinho);

            resp.sendRedirect("/achar-todos-produtos-cliente");
        }

    }
}
