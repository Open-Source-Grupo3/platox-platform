package com.sabrosaic.platox.platform.app.application.internal.queryservices;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.services.CustomerQueryService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final CustomerRepository customerRepository;

    public CustomerQueryServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Customer> handle(GetCustomerByProfileIdQuery query) {
        return customerRepository.findByProfileId(query.profileId());
    }

    // inherited javadoc
    @Override
    public Optional<Customer> handle(GetCustomerByCustomerRecordIdQuery query) {
        return customerRepository.findByCustomerRecordId(query.customerRecordId());
    }
}