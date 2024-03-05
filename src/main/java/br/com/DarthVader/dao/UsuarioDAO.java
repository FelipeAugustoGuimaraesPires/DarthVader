package br.com.DarthVader.dao;

import br.com.DarthVader.modal.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    public void criarUsuario(Usuario user){
        String SQL="insert into usuario (Nome, cpf, email, senha, grupo) values (?,?,?,?,?)";
        try{
            Connection connection=DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCPF());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.setString(5, user.getGrupo());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }
}
