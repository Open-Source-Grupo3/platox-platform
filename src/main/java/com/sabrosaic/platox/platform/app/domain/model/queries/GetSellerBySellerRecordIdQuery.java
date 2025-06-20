package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public record GetSellerBySellerRecordIdQuery(SellerRecordId sellerRecordId) {
    public GetSellerBySellerRecordIdQuery {
        if (sellerRecordId == null || sellerRecordId.sellerRecordId() == null || sellerRecordId.sellerRecordId().isBlank()) {
            throw new IllegalArgumentException("Customer record id must not be null or blank.");
        }
    }
}
