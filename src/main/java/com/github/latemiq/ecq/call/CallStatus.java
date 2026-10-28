package com.github.latemiq.ecq.call;

public enum CallStatus {
    WAITING,
    ASSIGNED,
    IN_PROGRESS,
    CLOSED;

    public boolean
    canTransitionTo(CallStatus next) {
        return switch (this) {
            case WAITING -> next == CallStatus.ASSIGNED || next == CallStatus.CLOSED;
            case ASSIGNED -> next == CallStatus.IN_PROGRESS;
            case IN_PROGRESS -> next == CallStatus.CLOSED;
            case CLOSED -> false;
        };
    }
}
