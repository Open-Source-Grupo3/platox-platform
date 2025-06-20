package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public record GetOrderByCustomerRecordIdAndSellerRecordIdQuery(SellerRecordId sellerRecordId,
                                                              CustomerRecordId customerRecordId ) {
    public GetOrderByCustomerRecordIdAndSellerRecordIdQuery {
        if (sellerRecordId == null || sellerRecordId.sellerRecordId() == null || sellerRecordId.sellerRecordId().isBlank()) {
            throw new IllegalArgumentException("Seller record id must not be null or blank.");
        }
        if (customerRecordId == null || customerRecordId.customerRecordId() == null || customerRecordId.customerRecordId().isBlank()) {
            throw new IllegalArgumentException("Customer record id must not be null or blank.");
        }

    }
}
