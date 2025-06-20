package com.sabrosaic.platox.platform.app.infrastructure.persistance.jpa.repositories;

import com.sabrosaic.platox.platform.app.domain.model.aggregates.Customer;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Order;
import com.sabrosaic.platox.platform.app.domain.model.aggregates.Seller;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustomerRecordId(CustomerRecordId customerRecordId);
    List<Order> findAllBySellerRecordId(SellerRecordId sellerRecordId);
    Optional<Order> findBySellerRecordIdAndCustomerRecordId(SellerRecordId sellerRecordId, CustomerRecordId customerRecordId);

}
