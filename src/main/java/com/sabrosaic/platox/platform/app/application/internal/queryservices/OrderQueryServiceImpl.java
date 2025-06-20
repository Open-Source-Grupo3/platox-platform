package com.sabrosaic.platox.platform.app.application.internal.queryservices;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Order;
import com.sabrosaic.platox.platform.app.domain.model.queries.*;
import com.sabrosaic.platox.platform.app.domain.services.OrderQueryService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> handle(GetOrderByIdQuery query) {
        return orderRepository.findById(query.orderId());
    }

    @Override
    public Optional<Order> handle(GetOrderByCustomerRecordIdAndSellerRecordIdQuery query) {
        return orderRepository.findBySellerRecordIdAndCustomerRecordId(query.sellerRecordId(), query.customerRecordId());
    }

    @Override
    public List<Order> handle(GetAllOrdersBySellerRecordIdQuery query) {
        return orderRepository.findAllBySellerRecordId(query.sellerRecordId());
    }

    @Override
    public List<Order> handle(GetAllOrdersQuery query) {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> handle(GetAllOrdersByCustomerRecordIdQuery query) {
        return orderRepository.findAllByCustomerRecordId(query.customerRecordId());
    }
}
