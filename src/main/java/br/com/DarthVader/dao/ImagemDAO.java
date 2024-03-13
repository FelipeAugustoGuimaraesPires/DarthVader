//package br.com.DarthVader.dao;
//
//import br.com.DarthVader.config.ConnectionPoolConfig;
//import br.com.DarthVader.modal.Imagem;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class ImagemDAO {
//
//    public Boolean inserir(Imagem imagem) throws SQLException {
//
//        Boolean retorno = false;
//        String SQL = "insert into imagem (imagem) values(?)";
//
//        try {
//            Connection connection = ConnectionPoolConfig.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//
//            preparedStatement.setBytes(1,imagem.getImagem());
//            retorno = preparedStatement.execute();
//
//            return retorno;
//        } catch (Exception e) {
//            System.out.println("Erro na conexão");
//        }
//
//
//    }
//}
