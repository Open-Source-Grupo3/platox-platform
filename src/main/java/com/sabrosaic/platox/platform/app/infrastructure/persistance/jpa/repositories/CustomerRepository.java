package com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerRecordId(CustomerRecordId customerRecordId);
    Optional<Customer> findByProfileId(ProfileId profileId);
    boolean existsByCustomerRecordId(CustomerRecordId customerRecordId);
}
