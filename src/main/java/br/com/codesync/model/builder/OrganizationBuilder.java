package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Address;
import br.com.codesync.model.entity.Contact;
import br.com.codesync.model.entity.Organization;
import br.com.codesync.model.entity.Project;

import java.util.Set;
import java.util.UUID;

public final class OrganizationBuilder {

    private Organization organization;

    private OrganizationBuilder() {
        this.organization = new Organization();
    }

    public static OrganizationBuilder builder() {
        return new OrganizationBuilder();
    }

    public OrganizationBuilder id(UUID id) {
        this.organization.setId(id);
        return this;
    }

    public OrganizationBuilder legalName(String legalName) {
        this.organization.setLegalName(legalName);
        return this;
    }

    public OrganizationBuilder fantasyName(String fantasyName) {
        this.organization.setFantasyName(fantasyName);
        return this;
    }

    public OrganizationBuilder slug(String slug) {
        this.organization.setSlug(slug);
        return this;
    }

    public OrganizationBuilder economicActivity(String economicActivity) {
        this.organization.setEconomicActivity(economicActivity);
        return this;
    }

    public OrganizationBuilder document(String document) {
        this.organization.setDocument(document);
        return this;
    }

    public OrganizationBuilder stateRegistration(String stateRegistration) {
        this.organization.setStateRegistration(stateRegistration);
        return this;
    }

    public OrganizationBuilder municipalRegistration(String municipalRegistration) {
        this.organization.setMunicipalRegistration(municipalRegistration);
        return this;
    }

    public OrganizationBuilder active(boolean active) {
        this.organization.setActive(active);
        return this;
    }

    public OrganizationBuilder projects(Set<Project> projects) {
        this.organization.setProjects(projects);
        return this;
    }

    public OrganizationBuilder address(Address address) {
        this.organization.setAddress(address);
        return this;
    }

    public OrganizationBuilder contacts(Set<Contact> contacts) {
        this.organization.setContacts(contacts);
        return this;
    }

    public Organization build() {
        final Organization result = this.organization;
        this.organization = new Organization();
        return result;
    }
}
