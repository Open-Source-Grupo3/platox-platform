package com.sabrosaic.platox.platform.profiles.application.internal.queryservices;

import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.*;
import com.sabrosaic.platox.platform.profiles.domain.services.ProfileQueryService;
import com.sabrosaic.platox.platform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());

    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
    @Override
    public List<Profile> handle(GetAllProfilesByCustomerTypeQuery query) {
        return profileRepository.findAllByType(query.type());
    }
    @Override
    public List<Profile> handle(GetAllProfilesBySellerTypeQuery query) {
        return profileRepository.findAllByType(query.type());
    }

}
