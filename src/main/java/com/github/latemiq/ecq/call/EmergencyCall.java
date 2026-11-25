package com.github.latemiq.ecq.call;
import java.time.Instant;
import java.util.UUID;

public class EmergencyCall {
    private UUID id;
    private String callerNumber;
    private String location;
    private CallType type;
    private CallStatus status;
    private String dispatcherId;
    private Instant createdAt;

    private EmergencyCall(UUID id, String callerNumber, String location, CallType type, CallStatus status, String dispatcherId, Instant createdAt) {
        this.id = id;
        this.callerNumber = callerNumber;
        this.location = location;
        this.type = type;
        this.status = status;
        this.dispatcherId = dispatcherId;
        this.createdAt = createdAt;
    }

    public static EmergencyCall register(String callerNumber, String location, CallType type, Instant now) {
        return new EmergencyCall(UUID.randomUUID(), callerNumber, location, type, CallStatus.WAITING, null, now);
    }

    public UUID getId() {
        return id;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public String getLocation() {
        return location;
    }

    public CallType getType() {
        return type;
    }

    public CallStatus getStatus() {
        return status;
    }

    public String getDispatcherId() {
        return dispatcherId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
