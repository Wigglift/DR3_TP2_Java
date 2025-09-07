package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;
import br.edu.infnet.DR3_TP2.models.exceptions.ReembolsoNaoAutorizadoException;

import java.time.LocalDate;
import java.util.Date;

public class Consulta {
    private LocalDate data;
    private ConsultaStatus status;
    private double valor;
    private boolean elegivelParaReembolso;

    Consulta(LocalDate data, ConsultaStatus status, double valor){
        this.data = data;
        this.status = status;
        this.valor = valor;
        elegivelParaReembolso = this.status == ConsultaStatus.CANCELADA;
    }


    @Override
    public String toString(){
        return String.format("Consulta data: " + data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear() + "\nStatus: " + status + "\nValor: %.2f",valor);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ConsultaStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultaStatus status) {
        this.status = status;
    }

    public boolean isElegivelParaReembolso() {
        return elegivelParaReembolso;
    }

    public void setElegivelParaReembolso(boolean elegivelParaReembolso) {
        this.elegivelParaReembolso = elegivelParaReembolso;
    }
}
