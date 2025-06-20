package com.sabrosaic.platox.platform.profiles.interfaces.rest.transform;

import com.sabrosaic.platox.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.sabrosaic.platox.platform.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.firstName(), resource.lastName(), resource.email(), resource.type());
    }
}
