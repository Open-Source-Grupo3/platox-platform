package com.sabrosaic.platox.platform.app.domain.model.queries;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;

public record GetCustomerByProfileIdQuery(ProfileId profileId) {
    public GetCustomerByProfileIdQuery {
        if (profileId == null || profileId.profileId() == null || profileId.profileId() <= 0) {
            throw new IllegalArgumentException("Profile id must not be null or less than or equal to zero.");
        }
    }
}
