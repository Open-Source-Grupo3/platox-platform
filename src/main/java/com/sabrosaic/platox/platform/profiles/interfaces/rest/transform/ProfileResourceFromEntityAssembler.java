package com.sabrosaic.platox.platform.profiles.interfaces.rest.transform;

import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmailAddress(), entity.getType());

    }
}