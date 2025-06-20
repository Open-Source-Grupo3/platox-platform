package com.sabrosaic.platox.platform.app.domain.model.queries;

public record GetOrderByIdQuery(Long orderId) {
    public GetOrderByIdQuery{
        if(orderId == null||orderId==0){
            throw new IllegalArgumentException("Order id must not be null or less than or equal to zero.");
        }
    }
}
