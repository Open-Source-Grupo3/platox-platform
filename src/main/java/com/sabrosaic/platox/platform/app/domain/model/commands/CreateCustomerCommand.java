package com.sabrosaic.platox.platform.app.domain.model.commands;

public record CreateCustomerCommand(String firstName,
                                    String lastName,
                                    String email,
                                    String type) {
}
