package com.sabrosaic.platox.platform.app.application.internal.commandservices;

import com.sabrosaic.platox.platform.app.application.internal.outboundservices.acl.ExternalProfileService;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.CustomerCommandService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {
    private final CustomerRepository customerRepository;
    private final ExternalProfileService externalProfileService;

    public CustomerCommandServiceImpl(CustomerRepository customerRepository, ExternalProfileService externalProfileService) {
        this.customerRepository = customerRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public CustomerRecordId handle(CreateCustomerCommand command) {
        // Fetch profile by email from external service

        var profileId = externalProfileService.fetchProfileByEmail(command.email());
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(
                    command.firstName(),
                    command.lastName(),
                    command.email(),
                    command.type());
        } else {
            customerRepository.findByProfileId(profileId.get()).ifPresent(student -> {
                throw new IllegalArgumentException("Student already exists in the system.");
            });
        }

        if (profileId.isEmpty()) {
            throw new IllegalArgumentException("Unable to create student profile.");
        }

        // Create a new student with the profile data.
        var customer = new Customer(profileId.get());
        customerRepository.save(customer);
        return customer.getCustomerRecordId();
    }

    
}
