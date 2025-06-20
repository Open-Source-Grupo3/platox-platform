package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateCustomerResource;

public class CreateCustomerCommandFromResourceAssembler {


    public static CreateCustomerCommand toCommandFromResource(CreateCustomerResource resource) {
        return new CreateCustomerCommand(resource.firstName(), resource.lastName(), resource.email(),
                resource.type());
    }
}