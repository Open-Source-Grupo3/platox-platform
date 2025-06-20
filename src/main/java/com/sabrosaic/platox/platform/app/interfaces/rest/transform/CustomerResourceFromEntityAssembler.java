package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CustomerResource;

public class CustomerResourceFromEntityAssembler {
    public static CustomerResource toResourceFromEntity(Customer entity) {
        return new CustomerResource(entity.getStringCustomerRecordId(),
                entity.getProfileId());
    }
}
