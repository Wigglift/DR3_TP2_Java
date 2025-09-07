package br.edu.infnet.DR3_TP2.models.exceptions;

public class ReembolsoNaoAutorizadoException extends RuntimeException {
    public ReembolsoNaoAutorizadoException(String message) {
        super(message);
    }
}
