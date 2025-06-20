package com.sabrosaic.platox.platform.app.interfaces.rest.transform;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Order;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.OrderResource;

public class OrderResourceFromEntityAssembler {
    public static OrderResource toResourceFromEntity(Order entity) {
        return new OrderResource(entity.getId(), entity.getSellerRecordId().sellerRecordId(), entity.getCustomerRecordId().customerRecordId(), entity.getDescription());
    }
}
