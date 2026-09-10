package model;

public class Treino {

    private int id;
    private String nome;
    private String foco;
    private int usuarioId;

    // Novo treino
    public Treino(String nome, String foco, int usuarioId) {
        this(0, nome, foco, usuarioId);
    }

    // Treino completo
    public Treino(int id, String nome, String foco, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.foco = foco;
        this.usuarioId = usuarioId;
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

    public String getFoco() {
        return foco;
    }

    public void setFoco(String foco) {
        this.foco = foco;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return String.format(
            "Treino[id=%d, nome=%s, foco=%s, usuarioId=%d]",
            id, nome, foco, usuarioId
        );
    }
}