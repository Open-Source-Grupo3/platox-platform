package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public record GetAllOrdersBySellerRecordIdQuery (SellerRecordId sellerRecordId){
    public GetAllOrdersBySellerRecordIdQuery{
        if (sellerRecordId == null || sellerRecordId.sellerRecordId() == null || sellerRecordId.sellerRecordId().isBlank()) {
            throw new IllegalArgumentException("Seller record id cannot be null or blank");
        }
    }
}
