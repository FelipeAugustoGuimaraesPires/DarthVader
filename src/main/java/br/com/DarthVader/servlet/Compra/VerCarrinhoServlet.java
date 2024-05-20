package br.com.DarthVader.servlet.Compra;

import br.com.DarthVader.dao.CarrinhoDAO;
import br.com.DarthVader.dao.ClienteDAO;
import br.com.DarthVader.modal.Carrinho;
import br.com.DarthVader.modal.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ver-carrinho")
public class VerCarrinhoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String produtos=req.getParameter("sla");
        ClienteDAO CliDAO= new ClienteDAO();

        String tela = req.getParameter("tela");

        if (tela.equalsIgnoreCase("Vitrine")){
            String idCli = CliDAO.AchaIDEmail(req.getParameter("email"));

            List<Carrinho> carrinho = new CarrinhoDAO().listarCarrinho(idCli);

            List<Endereco> endereco =CliDAO.ListarEnderecos(idCli);

            req.setAttribute("carrinho", carrinho);
            req.setAttribute("endereco", endereco);

            req.getRequestDispatcher("./Compra/Carrinho.jsp").forward(req, resp);
        }else {
            String idCli = CliDAO.AchaIDEmail(req.getParameter("email"));

            List<Carrinho> carrinho = new CarrinhoDAO().listarCarrinho(idCli);

            List<Endereco> endereco =CliDAO.ListarEnderecos(idCli);

            String totalProd = req.getParameter("totalGeral");
            String TotalFinal = req.getParameter("TotalFinal");

            String valorItens=req.getParameter("valorItens");
            String valorFrete=req.getParameter("entrega");

            String enderecoEntrega=req.getParameter("endereco");

            String qnt = req.getParameter("qntProd");

            totalProd=totalProd.replace("R$", "");

            int pointIndex = totalProd.indexOf(".");

            if (pointIndex != -1) {
                totalProd = totalProd.substring(0, pointIndex);
            }

            TotalFinal=TotalFinal.replace("R$", "");

            if (pointIndex != -1) {
                TotalFinal = TotalFinal.substring(0, pointIndex);
            }



            req.setAttribute("carrinho", carrinho);
            req.setAttribute("endereco", endereco);
            req.setAttribute("valor",totalProd);
            req.setAttribute("valorTotal",TotalFinal);

            req.getRequestDispatcher("./Compra/Pagamento.jsp").forward(req, resp);
        }

    }
}
