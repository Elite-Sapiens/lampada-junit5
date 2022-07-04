package com.elitesapiens.model;

import com.elitesapiens.enums.LampadaStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {
    private Lampada lampada;

    @BeforeEach
    void setUp() {
        this.lampada = new Lampada();
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
        void deveRetornarQueimadaQuandoForLigadaMaisDe1000Vezes() {
            for (int i = 0; i <= 2001; i++) {
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

    }
}