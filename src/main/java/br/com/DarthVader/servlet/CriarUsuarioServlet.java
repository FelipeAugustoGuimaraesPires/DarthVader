package br.com.DarthVader.servlet;

import br.com.DarthVader.dao.UsuarioDAO;
import br.com.DarthVader.modal.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/criar-usuario")
public class CriarUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail=req.getParameter("User-Email");
        String userNome=req.getParameter("User-Nome");
        String userSenha=req.getParameter("User-Senha");
        String userCPF=req.getParameter("User-CPF");
        String userGrupo=req.getParameter("User-Grupo");
        String userEstatus=req.getParameter("User-Estatus");
        String userID=req.getParameter("id");

        String senhaCriptografada = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(userSenha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            senhaCriptografada = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        Usuario usuario=new Usuario(userID, userEmail, userNome, userCPF, senhaCriptografada, userGrupo, userEstatus);
        System.out.println(usuario.getID());

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (userID.isEmpty()){
            usuarioDAO.criarUsuario(usuario);
        }else{
            usuarioDAO.AlterarUsuario(usuario);
        }

        resp.sendRedirect("/achar-todos-usuarios");
    }
}