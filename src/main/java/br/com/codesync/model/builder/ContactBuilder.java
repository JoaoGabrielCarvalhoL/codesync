package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Contact;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.ContactType;

import java.util.UUID;

public final class ContactBuilder {

    private final Contact contact;

    private ContactBuilder() {
        this.contact = new Contact();
    }

    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    public ContactBuilder id(UUID id) {
        this.contact.setId(id);
        return this;
    }

    public ContactBuilder type(ContactType type) {
        this.contact.setType(type);
        return this;
    }

    public ContactBuilder contactValue(String contactValue) {
        this.contact.setContactValue(contactValue);
        return this;
    }

    public ContactBuilder notes(String notes) {
        this.contact.setNotes(notes);
        return this;
    }

    public ContactBuilder url(String url) {
        this.contact.setUrl(url);
        return this;
    }

    public ContactBuilder user(User user) {
        this.contact.setUser(user);
        return this;
    }

    public Contact build() {
        return this.contact;
    }
}
