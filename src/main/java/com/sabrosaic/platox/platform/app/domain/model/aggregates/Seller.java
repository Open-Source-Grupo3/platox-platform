package com.sabrosaic.platox.platform.app.domain.model.aggregates;

import com.sabrosaic.platox.platform.app.domain.model.valueobjects.ProfileId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
public class Seller extends AuditableAbstractAggregateRoot<Seller> {
    @Getter
    @Embedded
    @Column(name = "seller_id")
    private final SellerRecordId sellerRecordId;

    @Embedded
    private ProfileId profileId;


    public Seller() {
        this.sellerRecordId = new SellerRecordId();
    }

    public Seller(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Seller(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public String getStringSellerRecordId() {
        return this.sellerRecordId.sellerRecordId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

}