package br.com.codesync.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_organizations", indexes = {
        @Index(name = "idx_org_document", columnList = "document", unique = true),
        @Index(name = "idx_org_slug", columnList = "slug", unique = true)
})
public class Organization extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String legalName;

    @Column(nullable = false, length = 200)
    private String fantasyName;

    @Column(nullable = false, length = 50, unique = true)
    private String slug;

    @Column(nullable = false, length = 100)
    private String economicActivity;

    @Column(nullable = false, length = 20, unique = true)
    private String document;

    @Column(length = 30)
    private String stateRegistration;

    @Column(nullable = false, length = 30)
    private String municipalRegistration;

    @Column(nullable = false)
    private boolean active = true;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "organization_id")
    private Set<Contact> contacts = new HashSet<>();

    public Organization() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getEconomicActivity() {
        return economicActivity;
    }

    public void setEconomicActivity(String economicActivity) {
        this.economicActivity = economicActivity;
    }

    public String getDocument() {
        return document;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getMunicipalRegistration() {
        return municipalRegistration;
    }

    public void setMunicipalRegistration(String municipalRegistration) {
        this.municipalRegistration = municipalRegistration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
