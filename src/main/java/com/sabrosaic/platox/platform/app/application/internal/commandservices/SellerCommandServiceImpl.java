package com.sabrosaic.platox.platform.app.application.internal.commandservices;

import com.sabrosaic.platox.platform.app.application.internal.outboundservices.acl.ExternalProfileService;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateCustomerCommand;
import com.sabrosaic.platox.platform.app.domain.model.commands.CreateSellerCommand;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.app.domain.services.CustomerCommandService;
import com.sabrosaic.platox.platform.app.domain.services.SellerCommandService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.CustomerRepository;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.SellerRepository;
import org.springframework.stereotype.Service;

@Service
public class SellerCommandServiceImpl implements SellerCommandService {
    private final SellerRepository sellerRepository;
    private final ExternalProfileService externalProfileService;

    public SellerCommandServiceImpl(SellerRepository sellerRepository, ExternalProfileService externalProfileService) {
        this.sellerRepository = sellerRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public SellerRecordId handle(CreateSellerCommand command) {
        // Fetch profile by email from external service

        var profileId = externalProfileService.fetchProfileByEmail(command.email());
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(
                    command.firstName(),
                    command.lastName(),
                    command.email(),
                    command.type());
        } else {
            sellerRepository.findByProfileId(profileId.get()).ifPresent(student -> {
                throw new IllegalArgumentException("Student already exists in the system.");
            });
        }

        if (profileId.isEmpty()) {
            throw new IllegalArgumentException("Unable to create student profile.");
        }

        // Create a new student with the profile data.
        var seller = new Seller(profileId.get());
        sellerRepository.save(seller);
        return seller.getSellerRecordId();
    }


}