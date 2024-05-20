package br.com.DarthVader.modal;

public class Carrinho {
    String id;
    String cliId;
    String prodId;
    String prodNome;
    String prodPreco;

    String situacao;

    int prodPrecoInt;
    public Carrinho() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliId() {
        return cliId;
    }

    public void setCliId(String cliId) {
        this.cliId = cliId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public String getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(String prodPreco) {
        this.prodPreco = prodPreco;
    }

    public int getProdPrecoInt() {
        return prodPrecoInt;
    }

    public void setProdPrecoInt(int prodPrecoInt) {
        this.prodPrecoInt = prodPrecoInt;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
