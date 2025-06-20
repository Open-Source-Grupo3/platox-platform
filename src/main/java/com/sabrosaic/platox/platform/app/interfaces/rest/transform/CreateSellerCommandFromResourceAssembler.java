package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateSellerCommand;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateCustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateSellerResource;

public class CreateSellerCommandFromResourceAssembler {
    public static CreateSellerCommand toCommandFromResource(CreateSellerResource resource) {
        return new CreateSellerCommand(resource.firstName(), resource.lastName(), resource.email(),
                resource.type());
    }
}
