package com.sabrosaic.platox.platform.app.domain.model.aggregates;


import com.sabrosaic.platox.platform.app.domain.model.valueobjects.CustomerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.SellerRecordId;
import com.sabrosaic.platox.platform.app.domain.model.valueobjects.OrderStatus;
import com.sabrosaic.platox.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
public class Order extends AuditableAbstractAggregateRoot<Order> {

    @Getter
    @Embedded
    private CustomerRecordId customerRecordId;

    @Getter
    @Embedded
    private SellerRecordId sellerRecordId;

    private String description;

    private OrderStatus status;
    public Order() {
    }
    public Order(CustomerRecordId customerRecordId,SellerRecordId sellerRecordId, String description) {
        this.customerRecordId = customerRecordId;
        this.sellerRecordId = sellerRecordId;
        this.description = description;
        this.status = OrderStatus.IN_PROGRESS;
    }

    public String getDescription() {
        return this.description != null ? this.description.toLowerCase() : "";
    }
    public String getStatus() {
        return this.status != null ? this.status.name().toLowerCase() : "";
    }
    public void complete() {
        this.status = OrderStatus.COMPLETED;
    }
    public boolean isCompleted() {
        return status == OrderStatus.COMPLETED;
    }

}