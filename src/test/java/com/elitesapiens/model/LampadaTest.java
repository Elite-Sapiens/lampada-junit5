package com.elitesapiens.model;

import com.elitesapiens.enums.LampadaStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {
    private Lampada lampada;

    @BeforeEach
    void setUp() {
        this.lampada = new Lampada();
        this.lampada.setClicks(1000);
    }

    @Nested
    class ApertarInterruptor {

        @Test
        void deveRetornarDesligadaQuandoInstanciaAClasse() {
            assertEquals(LampadaStatus.DESLIGADA, lampada.getStatus());
        }

        @Test
        void deveRetornarLigadaQuandoApertarOInterruptorPelaPrimeiraVez() {
            lampada.apertarInterruptor();
            assertEquals(LampadaStatus.LIGADA, lampada.getStatus());
        }

        @Test
        void deveRetornarDesligadaQuandoApertarOInterruptorDuasVezes() {
            for (int i = 0; i < 2; i++) {
                lampada.apertarInterruptor();
            }
            assertEquals(LampadaStatus.DESLIGADA, lampada.getStatus());
        }

        @Test
        void deveRetornarQueimadaQuandoForAcionadaMaisDe1000Vezes() {
            for (int i = 0; i <= 1000; i++) {
                lampada.apertarInterruptor();
            }
            assertEquals(LampadaStatus.QUEIMADA, lampada.getStatus());
        }

        @Test
        void deveRetornarDesligadaAoApertarOInterruptorUmaQuantidadeParDeVezes() {
            for (int i = 0; i < 50; i++) {
                lampada.apertarInterruptor();
            }
            assertEquals(LampadaStatus.DESLIGADA, lampada.getStatus());
        }

        @ParameterizedTest(name = "Quantidade de clicks: {0}")
        @CsvFileSource(resources = "/interruptor.csv", numLinesToSkip = 1)
        void deveSempreRetornarQueimadaComAQuantidadeDeApertosInformada(int quantidade) {
            lampada.setClicks(quantidade);

            for (int i = 0; i <= quantidade; i++) {
                lampada.apertarInterruptor();
            }

            assertEquals(LampadaStatus.QUEIMADA, lampada.getStatus());
        }

    }
}