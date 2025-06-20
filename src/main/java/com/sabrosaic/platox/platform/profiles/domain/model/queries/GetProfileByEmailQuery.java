package com.sabrosaic.platox.platform.profiles.domain.model.queries;

import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
