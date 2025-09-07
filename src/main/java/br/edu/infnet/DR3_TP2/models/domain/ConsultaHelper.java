package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;

import java.time.LocalDate;

public class ConsultaHelper {

    public static Consulta gerarConsulta( int dataAno, int dataMes, int dataDia, String status, double valor){
        ConsultaStatus consultaStatus = null;

        switch (status){
            case "agendada":
                consultaStatus = ConsultaStatus.AGENDADA;
            case "concluida":
                consultaStatus = ConsultaStatus.CONCLUIDA;
            case "cancelada":
                consultaStatus = ConsultaStatus.CANCELADA;
        }

        return new Consulta(LocalDate.of(dataAno,dataMes,dataDia),consultaStatus,valor);
    }

    public static Consulta gerarConsultaPadrao(){
        return new Consulta(LocalDate.of(2025,11,24),ConsultaStatus.AGENDADA,200);
    }
}
