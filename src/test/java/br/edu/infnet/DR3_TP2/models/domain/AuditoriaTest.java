package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AuditoriaTest {

    Paciente dummy = null;

    @BeforeEach
    void Setup(){
        dummy = new Paciente();
    }

    @Test
    @DisplayName("Deve chamar o método de registrar consultas corretamente")
    void deveChamarOMetodoDeRegistrarConsultasCorretamente(){
        //Setup
        Consulta consulta = ConsultaHelper.gerarConsultaPadrao();
        AuditoriaSpy auditoria = new AuditoriaSpy();

        //Execution
        auditoria.registrarConsulta(consulta,dummy);

        //Assertion
        assertTrue(auditoria.getConsultaRegistrada());
    }


}
