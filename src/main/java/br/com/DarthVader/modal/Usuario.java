package br.com.DarthVader.modal;

public class Usuario {
    private String ID;
    private String email;
    private String Nome;
    private String CPF;
    private String Senha;
    private String Grupo;
    private boolean Estatus;
    private boolean backoffice;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Usuario(String email, String nome, String CPF, String senha, String grupo) {
        this.email = email;
        Nome = nome;
        this.CPF = CPF;
        Senha = senha;
        Grupo = grupo;
        Estatus=true;
    }

    public Usuario(String ID, String email, String nome, String CPF, String senha, String grupo) {
        this.ID = ID;
        this.email = email;
        Nome = nome;
        this.CPF = CPF;
        Senha = senha;
        Grupo = grupo;
        Estatus=true;
    }

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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
