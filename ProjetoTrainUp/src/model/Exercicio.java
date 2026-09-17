package model;

public class Exercicio {

    private int id;

    private String nome;

    private int series;

    private int repeticoes;

    private int treinoId;


    // =============================================
    // CONSTRUTOR PARA NOVO EXERCÍCIO
    // =============================================

    public Exercicio(
            String nome,
            int series,
            int repeticoes,
            int treinoId
    ) {

        this.id = 0;

        this.nome = nome;

        this.series = series;

        this.repeticoes = repeticoes;

        this.treinoId = treinoId;
    }


    // =============================================
    // CONSTRUTOR PARA EXERCÍCIO DO BANCO
    // =============================================

    public Exercicio(
            int id,
            String nome,
            int series,
            int repeticoes,
            int treinoId
    ) {

        this.id = id;

        this.nome = nome;

        this.series = series;

        this.repeticoes = repeticoes;

        this.treinoId = treinoId;
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


    public int getSeries() {
        return series;
    }


    public void setSeries(int series) {
        this.series = series;
    }


    public int getRepeticoes() {
        return repeticoes;
    }


    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }


    public int getTreinoId() {
        return treinoId;
    }


    public void setTreinoId(int treinoId) {
        this.treinoId = treinoId;
    }


    // =============================================
    // TEXTO MOSTRADO NA LISTA
    // =============================================

    @Override
    public String toString() {

        return nome
                + "   |   "
                + series
                + " séries x "
                + repeticoes
                + " repetições";
    }
}