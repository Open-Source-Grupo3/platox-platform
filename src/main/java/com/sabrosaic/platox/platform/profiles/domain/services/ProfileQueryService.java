package com.sabrosaic.platox.platform.profiles.domain.services;

import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
    List<Profile> handle(GetAllProfilesQuery query);
    List<Profile> handle(GetAllProfilesByCustomerTypeQuery query);
    List<Profile> handle(GetAllProfilesBySellerTypeQuery query);
}
