package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Registro de um treino concluído (usado na tela de progresso).
 */
public class Registro {

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm");

    private int id;

    private int treinoId;

    private String nomeTreino;

    private LocalDateTime data;


    // =============================================
    // CONSTRUTOR PARA NOVO REGISTRO
    // =============================================

    public Registro(
            int treinoId
    ) {

        this.id = 0;

        this.treinoId = treinoId;

        this.data = LocalDateTime.now();
    }


    // =============================================
    // CONSTRUTOR PARA REGISTRO DO BANCO
    // =============================================

    public Registro(
            int id,
            int treinoId,
            String nomeTreino,
            LocalDateTime data
    ) {

        this.id = id;

        this.treinoId = treinoId;

        this.nomeTreino = nomeTreino;

        this.data = data;
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


    public int getTreinoId() {
        return treinoId;
    }


    public String getNomeTreino() {
        return nomeTreino;
    }


    public LocalDateTime getData() {
        return data;
    }


    // =============================================
    // TEXTO MOSTRADO NA LISTA
    // =============================================

    @Override
    public String toString() {

        return data.format(FORMATO)
                + "   |   "
                + nomeTreino;
    }
}
