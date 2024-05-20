package br.com.DarthVader.servlet.Compra;

import br.com.DarthVader.dao.CarrinhoDAO;
import br.com.DarthVader.dao.ClienteDAO;
import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Carrinho;
import br.com.DarthVader.modal.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deletar-produto-carrinho")
public class RemoverProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClienteDAO CliDAO= new ClienteDAO();

        String id=req.getParameter("id");

        String idCli = CliDAO.AchaIDEmail(req.getParameter("email"));

        if (idCli==null){
            req.getRequestDispatcher("/ver-carrinho").forward(req, resp);

        } else if(id!=null) {
            new CarrinhoDAO().DeletarCarrinhoID(id);
        }

        List<Carrinho> carrinho = new CarrinhoDAO().listarCarrinho(idCli);

        List<Endereco> endereco =CliDAO.ListarEnderecos(idCli);

        req.setAttribute("carrinho", carrinho);
        req.setAttribute("endereco", endereco);

        req.getRequestDispatcher("./Compra/Carrinho.jsp").forward(req, resp);
    }


}

