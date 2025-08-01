package com.iam.iamdashboard.model;

import java.time.LocalDateTime;

public class AuditLog {
    private String message;
    private LocalDateTime timestamp;

    public AuditLog(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
