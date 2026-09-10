package model;

public class Exercicio {

    private int id;
    private String nome;
    private String repeticoes;
    private float carga;

    // Novo exercício
    public Exercicio(String nome, String repeticoes, float carga) {
        this(0, nome, repeticoes, carga);
    }

    // Exercício completo
    public Exercicio(int id, String nome, String repeticoes, float carga) {
        this.id = id;
        this.nome = nome;
        this.repeticoes = repeticoes;
        this.carga = carga;
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

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return String.format(
            "Exercicio[id=%d, nome=%s, repeticoes=%s, carga=%.2f]",
            id, nome, repeticoes, carga
        );
    }
}