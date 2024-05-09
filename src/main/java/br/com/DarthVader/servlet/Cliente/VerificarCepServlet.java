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

@WebServlet("/verificarCepServlet")
public class VerificarCepServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String CliNome=req.getParameter("nome");
        String CliEmail=req.getParameter("email-criar");
        String CliCPF=req.getParameter("cpf");

        String cliSenha=req.getParameter("confirmPassword");
        String cliNascimento=req.getParameter("Data de nascimento");
        String cliCep=req.getParameter("CEP");
        String cliLog=req.getParameter("Logradouro");
        String cliNum=req.getParameter("Numero");
        String cliComp=req.getParameter("Complemento");
        String cliBairro=req.getParameter("Bairro");
        String cliCidade=req.getParameter("Cidade");
        String cliUF=req.getParameter("Uf");
        String cliGen=req.getParameter("Genero");

        String cliCep2=req.getParameter("cep2");
        String cliLog2=req.getParameter("Logradouro2");
        String cliNum2=req.getParameter("Numero2");
        String cliComp2=req.getParameter("Complemento2");
        String cliBairro2=req.getParameter("Bairro2");
        String cliCidade2=req.getParameter("Cidade2");
        String cliUF2=req.getParameter("Cliente-uf2");

        if (cliCep==null&&cliCep2==null){
            req.setAttribute("nomeCliente", CliNome);
            req.setAttribute("cpfCliente", CliCPF);
            req.setAttribute("emailCliente", CliEmail);

            req.getRequestDispatcher("/Cliente/TelaDeCadastro.jsp").forward(req, resp);
        } else if (cliCep!=null) {
            ClienteDAO DAO = new ClienteDAO();
            Endereco endereco = DAO.obterInformacoesEndereco(cliCep);

            req.setAttribute("nomeCliente", CliNome);
            req.setAttribute("cpfCliente", CliCPF);
            req.setAttribute("emailCliente", CliEmail);

            req.setAttribute("Logradouro", endereco.getLogradouro());
            req.setAttribute("Bairro", endereco.getBairro());
            req.setAttribute("Cidade", endereco.getCidade());
            req.setAttribute("Uf", endereco.getUf());

            req.getRequestDispatcher("/Cliente/TelaDeCadastro.jsp").forward(req, resp);
        } else {
            ClienteDAO DAO = new ClienteDAO();
            Endereco endereco = DAO.obterInformacoesEndereco(cliCep);

            req.setAttribute("nomeCliente", CliNome);
            req.setAttribute("cpfCliente", CliCPF);
            req.setAttribute("emailCliente", CliEmail);

            req.setAttribute("Logradouro2", endereco.getLogradouro());
            req.setAttribute("Bairro2", endereco.getBairro());
            req.setAttribute("Cidade2", endereco.getCidade());
            req.setAttribute("Uf2", endereco.getUf());

            req.getRequestDispatcher("/Cliente/TelaDeCadastro.jsp").forward(req, resp);
        }
    }
}
