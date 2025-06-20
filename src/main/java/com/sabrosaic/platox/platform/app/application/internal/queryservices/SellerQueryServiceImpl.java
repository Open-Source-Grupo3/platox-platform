package com.sabrosaic.platox.platform.app.application.internal.queryservices;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByCustomerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetCustomerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetSellerByProfileIdQuery;
import com.sabrosaic.platox.platform.app.domain.model.queries.GetSellerBySellerRecordIdQuery;
import com.sabrosaic.platox.platform.app.domain.services.CustomerQueryService;
import com.sabrosaic.platox.platform.app.domain.services.SellerQueryService;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.CustomerRepository;
import com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SellerQueryServiceImpl implements SellerQueryService {
    private final SellerRepository sellerRepository;

    public SellerQueryServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Seller> handle(GetSellerByProfileIdQuery query) {
        return sellerRepository.findByProfileId(query.profileId());
    }

    // inherited javadoc
    @Override
    public Optional<Seller> handle(GetSellerBySellerRecordIdQuery query) {
        return sellerRepository.findBySellerRecordId(query.sellerRecordId());
    }
}