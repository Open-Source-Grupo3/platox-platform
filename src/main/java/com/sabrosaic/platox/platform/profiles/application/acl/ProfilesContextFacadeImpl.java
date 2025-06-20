package com.sabrosaic.platox.platform.profiles.application.acl;

import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.sabrosaic.platox.platform.profiles.domain.services.ProfileCommandService;
import com.sabrosaic.platox.platform.profiles.domain.services.ProfileQueryService;
import com.sabrosaic.platox.platform.profiles.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfilesContextFacadeImpl implements ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacadeImpl(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    // inherited javadoc
    public Long createProfile(
            String firstName,
            String lastName,
            String email,
            String type) {
        var createProfileCommand = new CreateProfileCommand(
                firstName,
                lastName,
                email,
                type);
        var profile = profileCommandService.handle(createProfileCommand);
        return profile.isEmpty() ? Long.valueOf(0L) : profile.get().getId();
    }


    // inherited javadoc
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        return profile.isEmpty() ? Long.valueOf(0L) : profile.get().getId();
    }
}
