package br.com.DarthVader.servlet;

import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail=req.getParameter("User-Email");
        String userNome=req.getParameter("User-Nome");
        String userSenha=req.getParameter("User-Senha");
        String userCPF=req.getParameter("User-CPF");
        String userGrupo=req.getParameter("User-Grupo");
        String userID=req.getParameter("ID");

        Usuario usuario=new Usuario(userID, userEmail, userNome, userCPF, userSenha, userGrupo);

        if (userID.length()==0){

            new UsuarioDAO().criarUsuario(usuario);
        }else{

        }



        resp.sendRedirect("/achar-todos-usuarios");
    }
}
