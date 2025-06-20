package com.sabrosaic.platox.platform.app.domain.services;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateSellerCommand;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;

public interface SellerCommandService {
    SellerRecordId handle(CreateSellerCommand command);
}
