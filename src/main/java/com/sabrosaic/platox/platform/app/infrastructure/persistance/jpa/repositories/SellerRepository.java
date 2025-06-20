package com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findBySellerRecordId(SellerRecordId customerRecordId);
    Optional<Seller> findByProfileId(ProfileId profileId);
    boolean existsBySellerRecordId(SellerRecordId sellerRecordId);
}

