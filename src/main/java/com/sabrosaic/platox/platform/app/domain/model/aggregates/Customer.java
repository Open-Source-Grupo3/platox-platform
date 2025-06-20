package com.sabrosaic.platox.platform.app.domain.model.aggregates;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;
import com.sabrosaic.platox.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
@Entity
public class Customer extends AuditableAbstractAggregateRoot<Customer> {
    @Getter
    @Embedded
    @Column(name = "customer_id")
    private final CustomerRecordId customerRecordId;

    @Embedded
    private ProfileId profileId;


    public Customer() {
        this.customerRecordId = new CustomerRecordId();
    }

    public Customer(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Customer(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public String getStringCustomerRecordId() {
        return this.customerRecordId.customerRecordId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

}