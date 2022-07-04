package com.elitesapiens.model;

import com.elitesapiens.enums.LampadaStatus;
import com.elitesapiens.interfaces.ILampada;
import com.elitesapiens.interfaces.Interruptor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Lampada implements ILampada {
    private int clicks;
    private LampadaStatus status;
    private Interruptor interruptor;

    public Lampada() {
        this.clicks = 0;
        this.status = LampadaStatus.DESLIGADA;
        this.interruptor = new InterruptorSimples();
    }

    public void apertarInterruptor() {
        boolean queimada = isQueimada();

        if (queimada) {
            this.status = LampadaStatus.QUEIMADA;
        }
        else if (interruptor.ligar(this)) {
            this.clicks--;
            this.status = LampadaStatus.LIGADA;
        }
        else {
            this.clicks--;
            this.status = LampadaStatus.DESLIGADA;
        }
    }

    private boolean isQueimada() {
        return this.clicks <= 0;
    }

}

