package com.sabrosaic.platox.platform.profiles.domain.model.aggregates;

import com.sabrosaic.platox.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.PerfilType;
import com.sabrosaic.platox.platform.profiles.domain.model.valueobjects.PersonName;
import com.sabrosaic.platox.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    @Embedded
    private PersonName name;

    @Embedded
    private EmailAddress email;

    private PerfilType type;


    public Profile(String firstName, String lastName, String email, String type) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.type = PerfilType.valueOf(type);
    }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.type = PerfilType.valueOf(command.type());
    }
    public Profile() {

    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }


    public String getFullName() { return name.getFullName(); }

    public String getEmailAddress() { return email.address(); }
    public String getType(){ return type.toString(); }

}
