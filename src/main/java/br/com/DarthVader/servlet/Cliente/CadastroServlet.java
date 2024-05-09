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

@WebServlet ("/cadastroServlet")
public class CadastroServlet extends HttpServlet {
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

        if (cliSenha==null){
            Cliente cliente=new Cliente(CliNome, CliEmail, CliCPF);

            ClienteDAO DAO = new ClienteDAO();

            if (DAO.buscaEmail(cliente) || DAO.buscaCpf(cliente)){

                req.setAttribute("mensagemCad", "Email ou CPF já cadastrados");

                req.getRequestDispatcher("/Cliente/TelaDeLogin.jsp").forward(req, resp);
            }else {
                DAO.criarCleinte1(cliente);

                req.setAttribute("nomeCliente", cliente.getNome());
                req.setAttribute("cpfCliente", cliente.getCpf());
                req.setAttribute("emailCliente", cliente.getEmail());

                req.getRequestDispatcher("/Cliente/TelaDeCadastro.jsp").forward(req, resp);

            }
        }else {
            Cliente cliente=new Cliente(CliNome, CliEmail, cliSenha, CliCPF, cliGen, cliNascimento);
            System.out.println(cliente.getId());

            Endereco enderecoFat = new Endereco(cliCep, cliLog, cliNum, cliComp, cliBairro, cliCidade, cliUF);
            Endereco enderecoRec = new Endereco(cliCep2, cliLog2, cliNum2, cliComp2, cliBairro2, cliCidade2, cliUF2);


            ClienteDAO DAO = new ClienteDAO();

            boolean criarCliente = DAO.criarCleinte2(cliente);
            boolean criarEnderecoFat=DAO.criarEnderecoFat(cliente, enderecoFat);
            boolean criaEnderecoRec=DAO.criarEndereco(cliente, enderecoRec);


            if(criarEnderecoFat && criarCliente&&criaEnderecoRec){
                req.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
                resp.sendRedirect("/Cliente/TelaDeLogin.jsp");

            }else{
                req.setAttribute("nomeCliente", cliente.getNome());
                req.setAttribute("cpfCliente", cliente.getCpf());
                req.setAttribute("emailCliente", cliente.getEmail());

                req.getRequestDispatcher("/Cliente/TelaDeCadastro.jsp").forward(req, resp);
            }
        }
    }
}
