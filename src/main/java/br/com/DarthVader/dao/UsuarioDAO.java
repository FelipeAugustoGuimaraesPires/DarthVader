package br.com.DarthVader.dao;

import br.com.DarthVader.modal.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public List<Usuario> ListarUsuarios(){

        String SQL="Select * from usuario";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios= new ArrayList<>();

            while (resultSet.next()){
                String UserID= resultSet.getString("id");
                String UserEmail= resultSet.getString("email");
                String UserNome= resultSet.getString("nome");
                String UserCPF= resultSet.getString("cpf");
                String UserSenha= resultSet.getString("senha");
                String UserGrupo= resultSet.getString("grupo");
                //String UserStatus= resultSet.getString("estatus");
                //String UserBackoffice= resultSet.getString("backoffice");

                Usuario usuario = new Usuario(UserID,UserEmail, UserNome, UserCPF, UserSenha, UserGrupo);
                usuarios.add(usuario);
            }

            System.out.println("Sucesso na seleção");

            connection.close();

            return usuarios;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return Collections.emptyList();
        }
    }

    public void DeletarUserID(String userID){

        String SQL= "Delete usuario where id = ?";

        try {
            Connection connection=DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, userID);

            preparedStatement.execute();

            System.out.println("sucesso em apagar o carro com ID=" + userID);
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }

    }

    public void AlterarUsuario(Usuario user){
        String SQL="update usuario set Nome = ?, cpf = ?, email = ?, senha = ?, grupo = ? where id = ?";
        try{
            Connection connection=DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso na conexão");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCPF());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.setString(5, user.getGrupo());
            preparedStatement.setString(6, user.getID());

            preparedStatement.execute();

            System.out.println("sucesso em alterar o usuario de id: "+user.getID()+" no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na alteração de usuario");
        }
    }
}
