package com.sabrosaic.platox.platform.app.application.internal.outboundservices.acl;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;
import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.sabrosaic.platox.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProfileService {
    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }
    public Optional<ProfileId> createProfile(
            String firstName,
            String lastName,
            String email,
            String type) {
        var profileId = profilesContextFacade.createProfile(firstName, lastName, email,type);
        return profileId == 0L ? Optional.empty() : Optional.of(new ProfileId(profileId));
    }

    public Optional<ProfileId> fetchProfileByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        return profileId == 0L ? Optional.empty() : Optional.of(new ProfileId(profileId));
    }
}