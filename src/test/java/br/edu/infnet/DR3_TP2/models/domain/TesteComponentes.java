package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.interfaces.PlanoSaude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TesteComponentes {

    @Test
    void deveFazerOProcessoInteiroDeReembolso(){
        //setup
        Paciente dummy = new Paciente();

        PlanoSaude plano = new Plano25Stub();

        Consulta consulta = ConsultaHelper.gerarConsulta(2025,11,23,"agendada",400.00);

        AutorizadorReembolsoMock autorizador = mock(AutorizadorReembolsoMock.class);
        when(autorizador.autorizarReembolso(any(Consulta.class))).thenReturn(true);

        GestaoAutorizadorReembolso gestaoAutorizador = new GestaoAutorizadorReembolso(autorizador);

        CalculadoraReembolso calculadoraReembolso = new CalculadoraReembolso(gestaoAutorizador);

        double reembolsoEsperado = 100.00;

        //Execution
        double reembolso = calculadoraReembolso.calcular(consulta,plano.getCobertura(),dummy);

        //Assertion
        assertEquals(reembolsoEsperado,reembolso,"O reembolso com todos os testes deveria ser igual a 100");
    }
}
