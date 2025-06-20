package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.SellerResource;

public class SellerResourceFromEntityAssembler {
    public static SellerResource toResourceFromEntity(Seller entity) {
        return new SellerResource(entity.getStringSellerRecordId(),
                entity.getProfileId());
    }
}