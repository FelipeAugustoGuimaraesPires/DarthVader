package br.com.DarthVader.modal;


public class Produto {

    private String id;
    private String nome;
    private int avaliacao;
    private String descricao;

    private double preco;
    private int qtdEstoque;
    private String imagem;
    private String imagem2;
    private String imagem3;
    private String imagem4;
    private String estatus;

    public Produto() {
    }


    public Produto(String id, String nome, int avaliacao, String descricao, double preco, int qtdEstoque) {
        this.id = id;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.estatus="Ativo";
    }

    public Produto(String id, String nome, int avaliacao, String descricao, double preco, int qtdEstoque, String imagem, String imagem2, String imagem3, String imagem4) {
        this.id = id;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.imagem = imagem;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.imagem4 = imagem4;
        this.estatus="Ativo";
    }

    public Produto(String id, String nome, int avaliacao, String descricao, double preco, int qtdEstoque, String imagem, String imagem2, String imagem3, String imagem4, String estatus) {
        this.id = id;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.imagem = imagem;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.imagem4 = imagem4;
        this.estatus = estatus;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public String getImagem() {
        return imagem;
    }

    public String getImagem2() {
        return imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public String getImagem4() {
        return imagem4;
    }

    public String getEstatus() {
        return estatus;
    }
}