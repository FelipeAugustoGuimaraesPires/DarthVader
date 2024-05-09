package br.com.DarthVader.dao;

import br.com.DarthVader.config.ConnectionPoolConfig;
import br.com.DarthVader.config.Criptografia;
import br.com.DarthVader.modal.Cliente;
import br.com.DarthVader.modal.Endereco;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteDAO {
    public void criarCleinte1(Cliente cliente){
        String SQL="insert into cliente (Nome, cpf, email) values (?,?,?)";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getEmail());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public void EditarCliente(Cliente cliente){
        String SQL="update cliente set nome = ?, senha= ?, DATANASCIMENTO =?, genero = ?  where id = ?";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getDataNascimento());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setString(5, cliente.getId());

            preparedStatement.execute();

            System.out.println("sucesso em alterar cliente");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public boolean buscaEmail(Cliente cliente){
        String SQL = "SELECT * FROM cliente WHERE email = ?";
        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cliente.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean emailExists = resultSet.next();

            if (emailExists) {
                System.out.println("O email já existe no banco de dados.");
                return true;
            } else {
                System.out.println("O email não existe no banco de dados.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexão");
            e.printStackTrace();
            return false;
        }
    }

    public boolean buscaCpf(Cliente cliente){
        String SQL = "SELECT * FROM cliente WHERE cpf = ?";
        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cliente.getCpf());
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean emailExists = resultSet.next();

            if (emailExists) {
                System.out.println("O cpf já existe no banco de dados.");
                return true;
            } else {
                System.out.println("O cpf não existe no banco de dados.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erro na conexão");
            e.printStackTrace();
            return false;
        }
    }
    public boolean criarCleinte2(Cliente cliente){
        String SQL="update cliente set senha= ?, genero = ?, datanascimento = ? where id = ?";
        ClienteDAO DAO = new ClienteDAO();
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            Criptografia criptografia = new Criptografia();

            preparedStatement.setString(1, cliente.getSenha());
            preparedStatement.setString(2, cliente.getGenero());
            preparedStatement.setString(3, cliente.getDataNascimento());
            preparedStatement.setString(4, DAO.AchaID(cliente));

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();
            return true;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return false;
        }
    }

    public boolean criarEnderecoFat(Cliente cliente, Endereco endereco){
        String SQL="insert into endereco (FK_CLI_ID, CEP, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, tipo) values (?,?,?,?,?,?,?,?,'FAT')";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, AchaID(cliente));
            preparedStatement.setString(2, endereco.getCep());
            preparedStatement.setString(3, endereco.getLogradouro());
            preparedStatement.setString(4, endereco.getNumero());
            preparedStatement.setString(5, endereco.getComplemento());
            preparedStatement.setString(6, endereco.getBairro());
            preparedStatement.setString(7, endereco.getCidade());
            preparedStatement.setString(8, endereco.getUf());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();
            return true;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return false;
        }
    }

    public boolean criarEndereco(Cliente cliente, Endereco endereco){
        String SQL="insert into endereco (FK_CLI_ID, CEP, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, tipo) values (?,?,?,?,?,?,?,?,'REC')";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            String id;

            if (AchaID(cliente)==null){
                id=cliente.getId();
            }else{
                id=AchaID(cliente);
            }

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, endereco.getCep());
            preparedStatement.setString(3, endereco.getLogradouro());
            preparedStatement.setString(4, endereco.getNumero());
            preparedStatement.setString(5, endereco.getComplemento());
            preparedStatement.setString(6, endereco.getBairro());
            preparedStatement.setString(7, endereco.getCidade());
            preparedStatement.setString(8, endereco.getUf());

            preparedStatement.execute();

            System.out.println("sucesso em inserir no banco de dados");
            connection.close();
            return true;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return false;
        }
    }

    public boolean VerificarLogin(Cliente cliente){
        Criptografia criptografia = new Criptografia();
        String SQL ="select * from cliente where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar email");

            while (resultSet.next()){
                String senha = resultSet.getString("SENHA");

                if (senha.equals (cliente.getSenha())){

                    return true;
                }
            }

            connection.close();
            return false;
        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return false;
        }

    }

    public String AchaNome (Cliente cliente){
        String SQL ="select * from cliente where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar email");

            String nome=null;

            while (resultSet.next()){
                nome= resultSet.getString("nome");
            }

            return nome;

        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return null;
        }
    }

    public String AchaID (Cliente cliente){
        String SQL ="select * from cliente where cpf = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar cpf");

            String nome=null;

            while (resultSet.next()){
                nome= resultSet.getString("id");
            }

            return nome;

        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return null;
        }
    }

    public String AchaIDEmail (String email){
        String SQL ="select * from cliente where email = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("sucesso em selecionar cpf");

            String nome=null;

            while (resultSet.next()){
                nome= resultSet.getString("id");
            }

            return nome;

        }catch (Exception e){

            System.out.println("ERRO: "+e.getMessage());

            return null;
        }
    }

    public Endereco obterInformacoesEndereco(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String json = response.toString();

                Endereco endereco = new Endereco();

                endereco.setLogradouro(JsonParser.parseString(json).getAsJsonObject().get("logradouro").getAsString());
                endereco.setBairro(JsonParser.parseString(json).getAsJsonObject().get("bairro").getAsString());
                endereco.setCidade(JsonParser.parseString(json).getAsJsonObject().get("localidade").getAsString());
                endereco.setUf(JsonParser.parseString(json).getAsJsonObject().get("uf").getAsString());


                System.out.println("Informações do endereço adquiridas com sucesso:");
                return endereco;
            } else {
                System.out.println("CEP não encontrado.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Endereco> ListarEnderecos(String idCli){

        String SQL="Select * from endereco where FK_CLI_ID = ? order by estatus, tipo";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, idCli);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Endereco> enderecos= new ArrayList<>();

            while (resultSet.next()){
                String EndID= resultSet.getString("id");
                String EndCep= resultSet.getString("CEP");
                String EndLogradouro= resultSet.getString("LOGRADOURO");
                String EndNumero= resultSet.getString("NUMERO");
                String EndComplemento= resultSet.getString("COMPLEMENTO");
                String EndBairro= resultSet.getString("BAIRRO");
                String EndCidade= resultSet.getString("CIDADE");
                String EndUF= resultSet.getString("UF");
                String EndTipo= resultSet.getString("TIPO");
                String EndStatus= resultSet.getString("ESTATUS");

                Endereco endereco = new Endereco(EndID, EndCep, EndLogradouro, EndNumero, EndComplemento, EndBairro, EndCidade, EndUF, EndTipo, EndStatus);
                enderecos.add(endereco);
            }

            System.out.println("Sucesso na seleção");

            connection.close();

            return enderecos;

        }catch (Exception e){
            System.out.println("Erro na conexão");
            return Collections.emptyList();
        }
    }

    public void DesabilitarEndereco(String id){
        String SQL="update endereco set estatus = 'Inativo' where id = ?";
        try{
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("sucesso em alterar cliente");
            connection.close();

        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public void tornarEnderecoFaturamento(String id) {
        String sql = "SELECT FK_CLI_ID FROM Endereco WHERE id = ?";

        String sql2 = "UPDATE endereco SET tipo = 'REC' WHERE FK_CLI_ID = ?";

        String sql3 = "UPDATE endereco SET tipo = 'FAT' WHERE id = ?";
        String cliId = null;

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
             PreparedStatement preparedStatement3 = connection.prepareStatement(sql3)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliId = resultSet.getString("FK_CLI_ID");
            }

            preparedStatement2.setString(1, cliId);
            preparedStatement2.execute();

            preparedStatement3.setString(1, id);
            preparedStatement3.execute();

            System.out.println("Sucesso em alterar endereço de faturamento");
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}

