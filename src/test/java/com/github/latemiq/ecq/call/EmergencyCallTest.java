package com.github.latemiq.ecq.call;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class EmergencyCallTest {

    @Test
    void newCallIsWaitingInQueue() {
        EmergencyCall a = EmergencyCall.register("+48123", "Kraków", CallType.FIRE, Instant.now());
        assertThat(a.getStatus()).isEqualTo(CallStatus.WAITING);
        assertThat(a.getId()).isNotNull();
    }

    @Test
    void eachCallGetsUniqueId() {
        EmergencyCall a = EmergencyCall.register("+48123", "Kraków", CallType.FIRE, Instant.now());
        EmergencyCall b = EmergencyCall.register("+48123", "Kraków", CallType.FIRE, Instant.now());

        assertThat(a.getId()).isNotEqualTo(b.getId());
    }
}