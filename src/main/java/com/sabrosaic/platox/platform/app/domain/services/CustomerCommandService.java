package com.sabrosaic.platox.platform.app.domain.services;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;

public interface CustomerCommandService {

    CustomerRecordId handle(CreateCustomerCommand command);
}
