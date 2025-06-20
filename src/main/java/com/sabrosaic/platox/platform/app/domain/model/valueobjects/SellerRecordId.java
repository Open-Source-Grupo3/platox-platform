package com.sabrosaic.platox.platform.app.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record SellerRecordId(String sellerRecordId) {
    public SellerRecordId() {
        this(UUID.randomUUID().toString());
    }

    public SellerRecordId {
        if (sellerRecordId == null || sellerRecordId.isBlank()) {
            throw new IllegalArgumentException("Seller record id cannot be null or empty");
        }
    }
}
