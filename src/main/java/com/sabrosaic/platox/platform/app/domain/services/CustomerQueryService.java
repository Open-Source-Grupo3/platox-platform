package com.sabrosaic.platox.platform.app.domain.services;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByProfileIdQuery;

import java.util.Optional;

public interface CustomerQueryService {
    Optional<Customer> handle(GetCustomerByProfileIdQuery query);
    Optional<Customer> handle(GetCustomerByCustomerRecordIdQuery query);
}
