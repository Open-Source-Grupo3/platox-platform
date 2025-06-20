package com.sabrosaic.platox.platform.app.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record CustomerRecordId(String customerRecordId) {
    public CustomerRecordId() {
        this(UUID.randomUUID().toString());
    }

    public CustomerRecordId {
        if (customerRecordId == null || customerRecordId.isBlank()) {
            throw new IllegalArgumentException("Customer record id cannot be null or empty");
        }
    }
}