package br.edu.infnet.DR3_TP2.models.interfaces;

import br.edu.infnet.DR3_TP2.models.domain.Consulta;

public interface AutorizadorReembolso {
    public boolean autorizarReembolso(Consulta consulta);
}
