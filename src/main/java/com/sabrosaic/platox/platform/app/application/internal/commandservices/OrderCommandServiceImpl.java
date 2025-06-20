package com.sabrosaic.platox.platform.app.application.internal.commandservices;

import com.sabrosaic.platox.platform.app.application.internal.outboundservices.acl.ExternalProfileService;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Order;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateOrderCommand;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.CustomerCommandService;
import com.sabrosaic.platox.platform.app.domain.services.OrderCommandService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.CustomerRepository;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.OrderRepository;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.SellerRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private final OrderRepository orderRepository;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;


    public OrderCommandServiceImpl(OrderRepository orderRepository,CustomerRepository customerRepository, SellerRepository sellerRepository) {
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Long handle(CreateOrderCommand command) {
        Customer customer = customerRepository.findByCustomerRecordId(command.customerRecordId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + command.customerRecordId()));

        Seller seller = sellerRepository.findBySellerRecordId(command.sellerRecordId())
                .orElseThrow(() -> new IllegalArgumentException("Seller not found: " + command.sellerRecordId()));

        Order order = new Order(customer.getCustomerRecordId(), seller.getSellerRecordId(), command.description());

        Order savedOrder = orderRepository.save(order);

        return savedOrder.getId();
    }
}