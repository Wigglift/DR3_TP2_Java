package br.edu.infnet.DR3_TP2.models.domain;

import br.edu.infnet.DR3_TP2.models.interfaces.AutorizadorReembolso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraReembolsoTest {

    Consulta consulta = null;
    AutorizadorReembolso autorizadorReembolso = new AutorizadorReembolsoMock();
    GestaoAutorizadorReembolso gestaoAutorizador = new GestaoAutorizadorReembolso(autorizadorReembolso);
    CalculadoraReembolso calculadoraReembolso = null;
    Paciente dummy = null;
    Plano25Stub planoSaoCarlos = new Plano25Stub();
    Plano50Stub planoSaoJoao = new Plano50Stub();
    Plano70Stub planoRobertoCarlos = new Plano70Stub();

    @BeforeEach
    void setup(){
        consulta = ConsultaHelper.gerarConsulta(2025,11,23,"cancelada",200);
        calculadoraReembolso = new CalculadoraReembolso(gestaoAutorizador);
        dummy = new Paciente();
        planoSaoCarlos = new Plano25Stub();
        planoSaoJoao = new Plano50Stub();
        planoRobertoCarlos = new Plano70Stub();
    }

    @Test
    void deveCalcularReembolsoCorretamente (){
        //setup
        double cobertura = 70;
        double resultadoEsperado = 140;
        //execution
        double resultado = calculadoraReembolso.calcular(consulta,cobertura,dummy);
        //assertion
        assertEquals(resultadoEsperado,resultado,"Deveria reembolsar corretamente 70% de 200 reais (140 reais)");
    }

    @Test
    void deveCalcularReembolsoCorretamenteQuandoPassadoPlanoStubDe25PorCento(){
        //setup
        double resultadoEsperado = 50;
        //execution
        double resultado = calculadoraReembolso.calcular(consulta,planoSaoCarlos.getCobertura(),dummy);
        //assertion
        assertEquals(resultadoEsperado,resultado,"Deveria reembolsar corretamente com o stub de plano de 25% de 200 reais (50 reais)");
    }

    @Test
    void deveCalcularReembolsoCorretamenteQuandoPassadoPlanoStubDe50PorCento(){
        //setup
        double resultadoEsperado = 100;
        //execution
        double resultado = calculadoraReembolso.calcular(consulta,planoSaoJoao.getCobertura(),dummy);
        //assertion
        assertEquals(resultadoEsperado,resultado,"Deveria reembolsar corretamente com o stub de plano de 50% de 200 reais (100 reais)");
    }

    @Test
    void deveCalcularReembolsoCorretamenteQuandoPassadoPlanoStubDe70PorCento(){
        //setup
        consulta.setValor(138.87);
        double resultadoEsperado = 97.2;
        //execution
        double resultado = calculadoraReembolso.calcular(consulta,planoRobertoCarlos.getCobertura(),dummy);
        //assertion
        assertEquals(resultadoEsperado,resultado,0.01,"Deveria reembolsar corretamente com o stub de plano de 70% de 200 reais (140 reais)");
    }

    @Test
    void deveDevolverOTetoDoValorQuandoReembolsoMaiorQueOLimite(){
        //setup
        consulta.setValor(300);
        double resultadoEsperado = 150;
        //execution
        double resultado = calculadoraReembolso.calcular(consulta,planoRobertoCarlos.getCobertura(),dummy);
        //assertion
        assertEquals(resultadoEsperado,resultado,"Deveria reembolsar corretamente o teto de reembolso quando reembolso acima de 150)");
    }

    @ParameterizedTest(name = "Valor: {0} Cobertura: {1} Resultado {2}")
    @CsvSource({
            "0,100,0",
            "100,0,0",
            "100,100,100",
            "0,0,0"})
    @DisplayName("Deve calcular reembolso corretamente com limites de entrada")
    void deveCalcularReembolsoCorretamenteQuandoEstaNosLimites(double valor, double cobertura, double resultadoEsperado){
        //setup
        consulta.setValor(valor);
        //Execution
        double resultado = calculadoraReembolso.calcular(consulta,cobertura,dummy);
        //Assertion
        assertEquals(resultadoEsperado,resultado,"O calculo do reembolso de "+valor+" com a cobertura de "+cobertura+" deveria ser igual a "+resultadoEsperado);
    }

}
