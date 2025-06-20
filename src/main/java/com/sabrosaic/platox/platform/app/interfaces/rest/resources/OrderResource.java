package com.sabrosaic.platox.platform.app.interfaces.rest.resources;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public record OrderResource (Long orderId, String sellerRecordId,String customerRecordId, String description) {
}
