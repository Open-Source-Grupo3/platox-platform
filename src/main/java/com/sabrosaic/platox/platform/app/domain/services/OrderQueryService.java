package com.sabrosaic.platox.platform.app.domain.services;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Order;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuery query);
    Optional<Order> handle(GetOrderByCustomerRecordIdAndSellerRecordIdQuery query);
    List<Order> handle(GetAllOrdersBySellerRecordIdQuery query);
    List<Order> handle(GetAllOrdersQuery query);
    List<Order> handle(GetAllOrdersByCustomerRecordIdQuery query);

}
