package com.sabrosaic.platox.platform.profiles.interfaces.acl;

public interface ProfilesContextFacade {
    Long createProfile(String firstName, String lastName, String email, String type);
    Long fetchProfileIdByEmail(String email);
}