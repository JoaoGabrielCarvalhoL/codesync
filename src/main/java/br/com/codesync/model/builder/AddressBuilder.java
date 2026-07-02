package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Address;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.AddressType;

import java.util.UUID;

public final class AddressBuilder {

    private Address address;

    private  AddressBuilder() {
        this.address = new Address();
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public AddressBuilder id(UUID id) {
        this.address.setId(id);
        return this;
    }

    public AddressBuilder zipCode(String zipCode) {
        this.address.setZipCode(zipCode);
        return this;
    }

    public AddressBuilder street(String street) {
        this.address.setStreet(street);
        return this;
    }

    public AddressBuilder user(User user) {
        this.address.setUser(user);
        return this;
    }

    public AddressBuilder number(String number) {
        this.address.setNumber(number);
        return this;
    }

    public AddressBuilder complement(String complement) {
        this.address.setComplement(complement);
        return this;
    }

    public AddressBuilder neighborhood(String neighborhood) {
        this.address.setNeighborhood(neighborhood);
        return this;
    }

    public AddressBuilder city(String city) {
        this.address.setCity(city);
        return this;
    }

    public AddressBuilder state(String state) {
        this.address.setState(state);
        return this;
    }

    public AddressBuilder country(String country) {
        this.address.setCountry(country);
        return this;
    }

    public AddressBuilder type(AddressType type) {
        this.address.setType(type);
        return this;
    }

    public Address build() {
        Address response = this.address;
        this.address = new Address();
        return response;
    }
}
