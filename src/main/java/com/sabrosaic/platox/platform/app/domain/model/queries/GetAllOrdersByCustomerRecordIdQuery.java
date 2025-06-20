package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;

public record GetAllOrdersByCustomerRecordIdQuery (CustomerRecordId customerRecordId){
    public GetAllOrdersByCustomerRecordIdQuery{
    if (customerRecordId == null || customerRecordId.customerRecordId() == null || customerRecordId.customerRecordId().isBlank()) {
        throw new IllegalArgumentException("Customer record id cannot be null or blank");
        }
    }
}
