package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;

public record GetCustomerByCustomerRecordIdQuery (CustomerRecordId customerRecordId) {

    public GetCustomerByCustomerRecordIdQuery {
        if (customerRecordId == null || customerRecordId.customerRecordId() == null || customerRecordId.customerRecordId().isBlank()) {
            throw new IllegalArgumentException("Customer record id must not be null or blank.");
        }
    }
}