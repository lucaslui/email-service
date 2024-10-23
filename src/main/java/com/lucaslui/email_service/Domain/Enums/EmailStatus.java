package com.lucaslui.email_service.Domain.Enums;

public enum EmailStatus {
    SENT("sent"),
    ERROR("error");

    private final String status;

    EmailStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
