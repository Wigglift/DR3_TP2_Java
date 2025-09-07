package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;
import br.edu.infnet.DR3_TP2.models.exceptions.ReembolsoNaoAutorizadoException;
import br.edu.infnet.DR3_TP2.models.interfaces.AutorizadorReembolso;

public class AutorizadorReembolsoMock implements AutorizadorReembolso {

    @Override
    public boolean autorizarReembolso(Consulta consulta) {
        return consulta.isElegivelParaReembolso();
    }
}
