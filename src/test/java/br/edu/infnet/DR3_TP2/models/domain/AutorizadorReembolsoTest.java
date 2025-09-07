package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.enumerators.ConsultaStatus;
import br.edu.infnet.DR3_TP2.models.exceptions.ReembolsoNaoAutorizadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class AutorizadorReembolsoTest {

    Consulta consulta;

    @BeforeEach
    void Setup(){
        consulta = ConsultaHelper.gerarConsultaPadrao();
    }

    @Test
    @DisplayName("Deve lançar uma exceção com consultas não autorizadas para reembolso")
    void deveLancarExcecaoQuandoConsultaNaoAutorizadaParaReembolso(){
        //setup
        String erroEsperado ="Reembolso não foi autorizado para esta consulta";

        AutorizadorReembolsoMock autorizador = mock(AutorizadorReembolsoMock.class);
        when(autorizador.autorizarReembolso(any(Consulta.class))).thenReturn(false);

        GestaoAutorizadorReembolso gestaoAutorizador = new GestaoAutorizadorReembolso(autorizador);

        //execution
        RuntimeException erro = assertThrows(RuntimeException.class,()->gestaoAutorizador.autorizar(consulta),"Deveria lançar uma exceção com uma consulta não autorizada");

        //assertion
        assertEquals(erroEsperado, erro.getMessage(),"Deveria ter lançado um erro de reembolso não autorizado");
    }

    @Test
    @DisplayName("Deve autorizar consultas que são elegíveis para reeembolso")
    void deveAutorizarReembolsoQuandoConsultaElegivelParaReembolso(){
        //setup
        AutorizadorReembolsoMock autorizador = mock(AutorizadorReembolsoMock.class);
        when(autorizador.autorizarReembolso(any(Consulta.class))).thenReturn(true);

        GestaoAutorizadorReembolso gestaoAutorizador = new GestaoAutorizadorReembolso(autorizador);

        //Execution
        boolean resultado = gestaoAutorizador.autorizar(consulta);

        //assertion
        assertTrue(resultado,"Deveria autorizar reembolso de consulta elegivel para reembolso");

    }
}
