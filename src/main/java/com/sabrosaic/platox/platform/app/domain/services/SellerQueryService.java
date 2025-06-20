package com.sabrosaic.platox.platform.app.domain.services;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetSellerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetSellerBySellerRecordIdQuery;

import java.util.Optional;

public interface SellerQueryService {
    Optional<Seller> handle(GetSellerByProfileIdQuery query);
    Optional<Seller> handle(GetSellerBySellerRecordIdQuery query);
}
