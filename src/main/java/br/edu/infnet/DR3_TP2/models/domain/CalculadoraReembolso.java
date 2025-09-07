package br.edu.infnet.DR3_TP2.models.domain;

public class CalculadoraReembolso {

    GestaoAutorizadorReembolso gestaoAutorizador;

    CalculadoraReembolso(GestaoAutorizadorReembolso gestaoAutorizador){
        this.gestaoAutorizador = gestaoAutorizador;
    }

    public double calcular(Consulta consulta, double cobertura,Paciente paciente){
        gestaoAutorizador.autorizar(consulta);

        if(cobertura == 0)return 0;
        return (consulta.getValor() * (cobertura/100) > 150) ? 150 : consulta.getValor() * (cobertura/100);
    }
}
