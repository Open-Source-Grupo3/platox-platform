package com.sabrosaic.platox.platform.app.interfaces.rest;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateOrderCommand;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetAllOrdersQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetOrderByCustomerRecordIdAndSellerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.OrderCommandService;
import com.sabrosaic.platox.platform.app.domain.services.OrderQueryService;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.OrderResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateOrderResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.OrderResourceFromEntityAssembler;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CreateOrderCommandFromResourceAssembler;
import com.sabrosaic.platox.platform.shared.interfaces.rest.source.MessageResource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Orders", description = "Operations related to orders")
public class OrdersController {

    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrdersController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping
    @Operation(summary = "Create Order", description = "Creates a new order")
    public ResponseEntity<OrderResource> createOrder(@RequestBody CreateOrderResource resource) {
        var command = CreateOrderCommandFromResourceAssembler.toCommandFromResource(resource);
        var orderId = orderCommandService.handle(command);
        if (orderId == null || orderId.equals(0L)) return ResponseEntity.badRequest().build();

        var query = new GetOrderByCustomerRecordIdAndSellerRecordIdQuery(
                command.sellerRecordId(), command.customerRecordId());

        var orderOptional = orderQueryService.handle(query);
        if (orderOptional.isEmpty()) return ResponseEntity.notFound().build();

        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(orderOptional.get());
        return ResponseEntity.ok(orderResource);
    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Returns all orders")
    public ResponseEntity<List<OrderResource>> getAllOrders() {
        var query = new GetAllOrdersQuery();
        var orders = orderQueryService.handle(query);
        var resources = orders.stream()
                .map(OrderResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/search")
    @Operation(summary = "Get Order by Seller and Customer", description = "Get an order by seller and customer record IDs")
    public ResponseEntity<OrderResource> getOrderBySellerAndCustomer(
            @RequestParam String sellerRecordId,
            @RequestParam String customerRecordId) {

        var query = new GetOrderByCustomerRecordIdAndSellerRecordIdQuery(
                new SellerRecordId(sellerRecordId),
                new CustomerRecordId(customerRecordId)
        );

        var orderOptional = orderQueryService.handle(query);
        if (orderOptional.isEmpty()) return ResponseEntity.notFound().build();

        var resource = OrderResourceFromEntityAssembler.toResourceFromEntity(orderOptional.get());
        return ResponseEntity.ok(resource);
    }
}
