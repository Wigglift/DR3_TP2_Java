package br.edu.infnet.DR3_TP2.models.interfaces;

import br.edu.infnet.DR3_TP2.models.domain.Consulta;
import br.edu.infnet.DR3_TP2.models.domain.Paciente;

public interface Auditoria {
    public void registrarConsulta(Consulta consulta, Paciente paciente);
}
