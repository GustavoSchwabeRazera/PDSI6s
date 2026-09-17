package model;

public class Treino {

    private int id;
    private String nome;
    private int usuarioId;


    // =============================================
    // CONSTRUTOR PARA NOVO TREINO
    // =============================================

    public Treino(String nome, int usuarioId) {

        this.id = 0;
        this.nome = nome;
        this.usuarioId = usuarioId;
    }


    // =============================================
    // CONSTRUTOR PARA TREINO VINDO DO BANCO
    // =============================================

    public Treino(
            int id,
            String nome,
            int usuarioId
    ) {

        this.id = id;
        this.nome = nome;
        this.usuarioId = usuarioId;
    }


    // =============================================
    // GETTERS E SETTERS
    // =============================================

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


    public int getUsuarioId() {
        return usuarioId;
    }


    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }


    // =============================================
    // TOSTRING
    // =============================================

    @Override
    public String toString() {
        return nome;
    }
}