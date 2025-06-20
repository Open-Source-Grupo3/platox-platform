package com.sabrosaic.platox.platform.app.domain.model.commands;

public record CreateSellerCommand(String firstName,
                                  String lastName,
                                  String email,
                                  String type) {
}

