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
        String userID=req.getParameter("ID");//verificar

        String userEmail=req.getParameter("User-Email");
        String userNome=req.getParameter("User-Nome");
        String userSenha=req.getParameter("User-Senha");
        String userCPF=req.getParameter("User-CPF");
        String userGrupo=req.getParameter("User-Grupo");



        Usuario usuario=new Usuario();
        usuario.setNome(userNome);
        usuario.setEmail(userEmail);
        usuario.setSenha(userSenha);
        usuario.setCPF(userCPF);
        usuario.setGrupo(userGrupo);
        usuario.setID(userID);
//
//
//        if (userID.isBlank()){
//            UsuarioDAO.criarUsuario(user);
//        }else UsuarioDAO.updateUsuario(user);

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
