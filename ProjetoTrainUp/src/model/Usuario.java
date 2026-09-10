package model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private int idade;

    // Construtor para novo usuário
    public Usuario(String nome, String email, String senha, int idade) {
        this(0, nome, email, senha, idade);
    }

    // Construtor completo
    public Usuario(int id, String nome, String email, String senha, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format(
            "Usuario[id=%d, nome=%s, email=%s, senha=%s, idade=%d]",
            id, nome, email, senha, idade
        );
    }
}