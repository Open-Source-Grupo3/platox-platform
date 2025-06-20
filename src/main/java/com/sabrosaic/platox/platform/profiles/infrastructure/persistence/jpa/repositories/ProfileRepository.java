package com.sabrosaic.platox.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.sabrosaic.platox.platform.profiles.domain.model.aggregates.Profile;
import com.sabrosaic.platox.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.PerfilType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
    boolean existsByEmail(EmailAddress emailAddress);

    List<Profile> findAllByType(PerfilType type);
}
