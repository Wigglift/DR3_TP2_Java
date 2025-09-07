package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.interfaces.PlanoSaude;

public class Plano50Stub implements PlanoSaude {
    @Override
    public double getCobertura() {
        return 50;
    }
}
