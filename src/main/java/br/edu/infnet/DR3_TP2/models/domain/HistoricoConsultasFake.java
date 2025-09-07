package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;
import br.edu.infnet.DR3_TP2.models.interfaces.HistoricoConsultas;

import java.time.LocalDate;
import java.util.List;

public class HistoricoConsultasFake implements HistoricoConsultas {

    private List<Consulta> historicoFake;

    HistoricoConsultasFake(){
        Consulta consulta1 = new Consulta(LocalDate.of(2025,9,24), ConsultaStatus.AGENDADA,900);
        historicoFake.add(consulta1);

        Consulta consulta2 = new Consulta(LocalDate.of(2025,4,18), ConsultaStatus.CONCLUIDA,500);
        historicoFake.add(consulta2);
    }

    @Override
    public List<Consulta> acessar() {
        return historicoFake;
    }
}
