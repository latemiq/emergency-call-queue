package com.github.latemiq.ecq.call;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CallStatusTest {
    @Test
    void waitingCallCanBeAssigned() {
        assertThat(CallStatus.WAITING.canTransitionTo(CallStatus.ASSIGNED)).isTrue();
    }
    @Test
    void closedCallCannotBeReassigned() {
        assertThat(CallStatus.CLOSED.canTransitionTo(CallStatus.ASSIGNED)).isFalse();
    }
    @Test
    void closedCallCannotBeClosedAgain()    {
        assertThat(CallStatus.CLOSED.canTransitionTo(CallStatus.CLOSED)).isFalse();
    }
    @Test
    void waitingCallCanBeClosedWhenCallerHangsUp() {
        assertThat(CallStatus.WAITING.canTransitionTo(CallStatus.CLOSED)).isTrue();
    }
    @Test
    void assignedCallCanBeStarted(){
        assertThat(CallStatus.ASSIGNED.canTransitionTo(CallStatus.IN_PROGRESS)).isTrue();
    }
    @Test
    void callInProgressCanBeClosed(){
        assertThat(CallStatus.IN_PROGRESS.canTransitionTo(CallStatus.CLOSED)).isTrue();
    }
    @Test
    void waitingCallCannotBeStartedWithoutAssignment(){
        assertThat(CallStatus.WAITING.canTransitionTo(CallStatus.IN_PROGRESS)).isFalse();
    }
}