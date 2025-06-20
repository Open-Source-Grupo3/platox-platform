package com.sabrosaic.platox.platform.profiles.domain.model.commands;

public record CreateProfileCommand(String firstName,
                                   String lastName,
                                   String email,
                                   String type) { }