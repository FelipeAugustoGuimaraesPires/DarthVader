package br.com.DarthVader.dao;

import br.com.DarthVader.config.ConnectionPoolConfig;
import br.com.DarthVader.modal.Carrinho;
import br.com.DarthVader.modal.Cliente;
import br.com.DarthVader.modal.Endereco;
import br.com.DarthVader.modal.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CarrinhoDAO {
    public void criarCarrinho(Carrinho carrinho){
        String SQL="insert into carrinho (IdCli, IdProd, situacao) values (?,?,'carrinho')";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, carrinho.getCliId());
            preparedStatement.setString(2, carrinho.getProdId());


            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public boolean jaTem(Carrinho carrinho){
        String SQL="SELECT * FROM CARRINHO where idcli = ? and idprod=?";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, carrinho.getCliId());
            preparedStatement.setString(2, carrinho.getProdId());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                System.out.println("Produto já esta no carrinho");
                connection.close();
                return true;
            }else{
                System.out.println("Produto não está no carrinho");
                connection.close();
                return false;
            }

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return false;
        }
    }


    public List<Carrinho> listarCarrinho(String id){

        String SQL="Select * from carrinho where IdCli = ? ORDER BY id DESC";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Carrinho> ListaCarrinhos= new ArrayList<>();

            while (resultSet.next()){
                Carrinho carrinho = new Carrinho();
                carrinho.setId(resultSet.getString("ID"));
                carrinho.setCliId(resultSet.getString("IDCLI"));
                carrinho.setProdId(resultSet.getString("IDPROD"));


                String SQL2="Select * from produto where Id = ? ORDER BY id DESC";

                try {
                    PreparedStatement preparedStatement2 = connection.prepareStatement(SQL2);

                    preparedStatement2.setString(1, carrinho.getProdId());

                    ResultSet resultSet2 = preparedStatement2.executeQuery();

                    while (resultSet2.next()){
                        carrinho.setProdNome(resultSet2.getString("NOME"));
                        carrinho.setProdPreco(resultSet2.getString("PRECO"));
                        carrinho.setProdPrecoInt((int) Float.parseFloat(resultSet2.getString("PRECO")));
                    }

                }catch (Exception e){
                    System.out.println("Erro na conexão");
                    return Collections.emptyList();
                }

                ListaCarrinhos.add(carrinho);
            }

            System.out.println("Sucesso na seleção");

            connection.close();

            return ListaCarrinhos;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return Collections.emptyList();
        }
    }

    public void DeletarCarrinhoID(String ID){

        String SQL= "Delete carrinho where id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, ID);

            preparedStatement.execute();

            System.out.println("sucesso em apagar");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }

    }
}
