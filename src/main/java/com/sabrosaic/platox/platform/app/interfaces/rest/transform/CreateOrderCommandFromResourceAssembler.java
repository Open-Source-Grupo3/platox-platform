package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateOrderCommand;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateCustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateOrderResource;

public class CreateOrderCommandFromResourceAssembler {

    public static CreateOrderCommand toCommandFromResource(CreateOrderResource resource) {
        return new CreateOrderCommand(new CustomerRecordId(resource.customerRecordId()),new SellerRecordId(resource.sellerRecordId()), resource.description());
    }
}
