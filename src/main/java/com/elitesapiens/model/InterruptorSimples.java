package com.elitesapiens.model;

import com.elitesapiens.enums.LampadaStatus;
import com.elitesapiens.interfaces.ILampada;
import com.elitesapiens.interfaces.Interruptor;

public class InterruptorSimples implements Interruptor {
    @Override
    public boolean ligar(ILampada lampada) {
        return lampada.getStatus() == LampadaStatus.DESLIGADA;
    }
}
