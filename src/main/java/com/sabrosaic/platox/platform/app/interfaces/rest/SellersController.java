package com.sabrosaic.platox.platform.app.interfaces.rest;

import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetSellerBySellerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.CustomerCommandService;
import com.sabrosaic.platox.platform.app.domain.services.CustomerQueryService;
import com.sabrosaic.platox.platform.app.domain.services.SellerCommandService;
import com.sabrosaic.platox.platform.app.domain.services.SellerQueryService;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateCustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CreateSellerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.CustomerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.resources.SellerResource;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CreateCustomerCommandFromResourceAssembler;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CreateSellerCommandFromResourceAssembler;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.CustomerResourceFromEntityAssembler;
import com.sabrosaic.platox.platform.app.interfaces.rest.transform.SellerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/sellers", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Sellers", description = "Available Seller Endpoints")
public class SellersController {
    private final SellerCommandService sellerCommandService;
    private final SellerQueryService sellerQueryService;

    public SellersController(SellerCommandService sellerCommandService, SellerQueryService sellerQueryService) {
        this.sellerCommandService = sellerCommandService;
        this.sellerQueryService = sellerQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new Customer", description = "Create a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Student not found")})
    public ResponseEntity<SellerResource> createSeller(CreateSellerResource resource) {
        var createSellerCommand = CreateSellerCommandFromResourceAssembler.toCommandFromResource(resource);
        var sellerRecordId = sellerCommandService.handle(createSellerCommand);
        if (sellerRecordId.sellerRecordId().isEmpty()) return ResponseEntity.badRequest().build();
        var getSellerBySellerRecordIdQuery = new GetSellerBySellerRecordIdQuery(sellerRecordId);
        var seller = sellerQueryService.handle(getSellerBySellerRecordIdQuery);
        if (seller.isEmpty()) return ResponseEntity.notFound().build();
        var createdSeller = seller.get();
        var sellerResource = SellerResourceFromEntityAssembler.toResourceFromEntity(createdSeller);
        return new ResponseEntity<>(sellerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{sellerRecordId}")
    @Operation(summary = "Get student by Acme Student Record Id", description = "Get student by Acme Student Record Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")})
    public ResponseEntity<SellerResource> getSellerByAcmeStudentRecordId(@PathVariable String sellerRecordId) {
        var tempSellerRecordId = new SellerRecordId(sellerRecordId);
        var getSellerByAcmeSellerRecordIdQuery = new GetSellerBySellerRecordIdQuery(tempSellerRecordId);
        var seller = sellerQueryService.handle(getSellerByAcmeSellerRecordIdQuery);
        if (seller.isEmpty()) return ResponseEntity.notFound().build();
        var sellerResource = SellerResourceFromEntityAssembler.toResourceFromEntity(seller.get());
        return ResponseEntity.ok(sellerResource);
    }

}
