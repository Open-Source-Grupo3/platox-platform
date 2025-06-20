package com.sabrosaic.platox.platform.app.interfaces.rest.resources;

public record CreateCustomerResource(String firstName,
                                    String lastName,
                                    String email,
                                    String type) {
    public CreateCustomerResource {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type is required");
        }
    }
}