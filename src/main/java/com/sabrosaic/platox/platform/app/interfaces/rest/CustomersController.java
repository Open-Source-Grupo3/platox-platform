package com.sabrosaic.platox.platform.app.interfaces.rest;

import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.CustomerCommandService;
import com.sabrosaic.platox.platform.app.domain.services.CustomerQueryService;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateCustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CreateCustomerCommandFromResourceAssembler;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CustomerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(value = "/api/v1/customers", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Customers", description = "Available Customer Endpoints")
public class CustomersController {
    private final CustomerCommandService customerCommandService;
    private final CustomerQueryService customerQueryService;

    public CustomersController(CustomerCommandService customerCommandService, CustomerQueryService customerQueryService) {
        this.customerCommandService = customerCommandService;
        this.customerQueryService = customerQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new Customer", description = "Create a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Student not found")})
    public ResponseEntity<CustomerResource> createCustomer(CreateCustomerResource resource) {
        var createCustomerCommand = CreateCustomerCommandFromResourceAssembler.toCommandFromResource(resource);
        var customerRecordId = customerCommandService.handle(createCustomerCommand);
        if (customerRecordId.customerRecordId().isEmpty()) return ResponseEntity.badRequest().build();
        var getCustomerByCustomerRecordIdQuery = new GetCustomerByCustomerRecordIdQuery(customerRecordId);
        var customer = customerQueryService.handle(getCustomerByCustomerRecordIdQuery);
        if (customer.isEmpty()) return ResponseEntity.notFound().build();
        var createdCustomer = customer.get();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(createdCustomer);
        return new ResponseEntity<>(customerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{customerRecordId}")
    @Operation(summary = "Get student by Acme Student Record Id", description = "Get student by Acme Student Record Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")})
    public ResponseEntity<CustomerResource> getStudentByAcmeStudentRecordId(@PathVariable String customerRecordId) {
        var tempCustomerRecordId = new CustomerRecordId(customerRecordId);
        var getCustomerByAcmeCustomerRecordIdQuery = new GetCustomerByCustomerRecordIdQuery(tempCustomerRecordId);
        var customer = customerQueryService.handle(getCustomerByAcmeCustomerRecordIdQuery);
        if (customer.isEmpty()) return ResponseEntity.notFound().build();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return ResponseEntity.ok(customerResource);
    }

}
