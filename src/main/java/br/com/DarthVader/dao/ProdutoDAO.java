package br.com.DarthVader.dao;

import br.com.DarthVader.config.ConnectionPoolConfig;
import br.com.DarthVader.modal.Produto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastroProduto(Produto produto) {

        String SQL = "insert into produto(nome,avaliacao,descricao,preco,qtdEstoque,imagem) values(?,?,?,?,?,?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getAvaliacao());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setBigDecimal(4, produto.getPreco());
            preparedStatement.setInt(5, produto.getQtdEstoque()););
            preparedStatement.setBytes(6, produto.getImagem());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na criação");
        }
    }

    public void alterarProduto(Produto produto) {
        String SQL = "UPDATE produto SET nome = ?, avaliacao = ?, descricao = ?, preco = ?, estoque = ?, imagem = ? WHERE id = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getAvaliacao());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setBigDecimal(4, produto.getPreco());
            preparedStatement.setInt(5, produto.getQtdEstoque()););
            preparedStatement.setBytes(6, produto.getImagem());
            preparedStatement.setString(7, produto.getId());

            preparedStatement.execute();

            System.out.println("sucesso em alterar no banco de dados");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na alteração");
        }

    }

    public List<Produto> listar() {
        String SQL = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<Produto>();

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                Produto produto = new Produto();
                produto.setId(res.getString("id"));
                produto.setNome(res.getString("nome"));
                produto.setAvaliacao(res.getString("avaliacao"));
                produto.setDescricao(res.getString("descricao"));
                produto.setPreco(BigDecimal.valueOf(res.getInt("Preco")));
                produto.setQtdEstoque(res.getInt("Estoque"));
                produto.setImagem(res.getBytes("imagem"));

                lista.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro na listagem");
        }
        return lista;
    }

}
