package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.interfaces.Auditoria;

public class AuditoriaSpy implements Auditoria {

    private Paciente paciente;
    private Consulta consulta;
    private boolean consultaRegistrada;

    @Override
    public void registrarConsulta(Consulta consulta, Paciente paciente) {
        this.consulta = consulta;
        this.paciente = paciente;
        this.consultaRegistrada = true;
    }

    public boolean getConsultaRegistrada() {
        return consultaRegistrada;
    }

    public void setConsultaRegistrada(boolean consultaRegistrada) {
        this.consultaRegistrada = consultaRegistrada;
    }
}
