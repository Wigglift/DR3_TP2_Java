package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.exceptions.ReembolsoNaoAutorizadoException;
import br.edu.infnet.DR3_TP2.models.interfaces.AutorizadorReembolso;

public class GestaoAutorizadorReembolso {

    AutorizadorReembolso autorizador;

    GestaoAutorizadorReembolso(AutorizadorReembolso autorizador){
        this.autorizador = autorizador;
    }

    public boolean autorizar(Consulta consulta) {
        if (!autorizador.autorizarReembolso(consulta)) throw new ReembolsoNaoAutorizadoException("Reembolso não foi autorizado para esta consulta");

        return true;
    }
}
