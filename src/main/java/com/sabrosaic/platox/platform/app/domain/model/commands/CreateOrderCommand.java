package com.sabrosaic.platox.platform.app.domain.model.commands;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public record CreateOrderCommand (CustomerRecordId customerRecordId, SellerRecordId sellerRecordId, String description) {
}