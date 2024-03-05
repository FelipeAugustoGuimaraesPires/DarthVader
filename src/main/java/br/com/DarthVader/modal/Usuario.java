package br.com.DarthVader.modal;

public class Usuario {
    private String email;
    private String Nome;
    private String CPF;
    private String Senha;
    private String Grupo;
    private boolean Estatus;
    private boolean backoffice;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public boolean isEstatus() {
        return Estatus;
    }

    public void setEstatus(boolean estatus) {
        Estatus = estatus;
    }

    public boolean isBackoffice() {
        return backoffice;
    }

    public void setBackoffice(boolean backoffice) {
        this.backoffice = backoffice;
    }
}
