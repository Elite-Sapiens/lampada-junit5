package com.elitesapiens.interfaces;

import com.elitesapiens.enums.LampadaStatus;

public interface ILampada {

    void apertarInterruptor();
    void setStatus(LampadaStatus status);
    LampadaStatus getStatus();
}

