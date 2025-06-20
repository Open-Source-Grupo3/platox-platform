package com.sabrosaic.platox.platform.profiles.interfaces.rest.resources;

public record CreateProfileResource (
        String firstName,
        String lastName,
        String email,
        String type) { }