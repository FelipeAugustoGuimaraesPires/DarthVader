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

@WebServlet("/edita-cliente")
public class EditarClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cliEmail=req.getParameter("email");
        String tela=req.getParameter("tela");

        if (tela.equals("Editar")){
            ClienteDAO DAO = new ClienteDAO();

            String email=req.getParameter("id");
            String id = DAO.AchaIDEmail(email);
            String nome=req.getParameter("nome");;
            String senha=req.getParameter("passwordConfirma");;
            String DataNascimento=req.getParameter("Data de nascimento");
            String genero=req.getParameter("genero");

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setSenha(senha);
            cliente.setDataNascimento(DataNascimento);
            cliente.setGenero(genero);
            cliente.setId(id);

            String cliCep=req.getParameter("CEP");
            String cliLog=req.getParameter("Logradouro");
            String cliNum=req.getParameter("Numero");
            String cliComp=req.getParameter("Complemento");
            String cliBairro=req.getParameter("Bairro");
            String cliCidade=req.getParameter("Cidade");
            String cliUF=req.getParameter("Uf");

            Endereco endereco = new Endereco(cliCep, cliLog, cliNum, cliComp, cliBairro, cliCidade,cliUF);

            DAO.criarEndereco(cliente, endereco);
            DAO.EditarCliente(cliente);

            req.setAttribute("id", id);

            req.getRequestDispatcher("/Cliente/TelaDeEditar.jsp").forward(req, resp);

        }else{
            ClienteDAO DAO = new ClienteDAO();
            String id = DAO.AchaIDEmail(cliEmail);

            req.setAttribute("id", id);

            req.getRequestDispatcher("/Cliente/TelaDeEditar.jsp").forward(req, resp);

        }
    }
}
