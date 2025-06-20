package com.sabrosaic.platox.platform.app.interfaces.rest.resources;

public record CreateOrderResource(String sellerRecordId, String customerRecordId, String description) {
}
