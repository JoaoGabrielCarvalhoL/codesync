package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Address;
import br.com.codesync.model.entity.Contact;
import br.com.codesync.model.entity.Organization;
import br.com.codesync.model.entity.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

class OrganizationBuilderTest {

    @Test
    @DisplayName("Should create an organization with valid values")
    void shouldCreateOrganizationWithValidValues() {
        UUID id = UUID.randomUUID();

        Address address = new Address();
        Contact contact = new Contact();
        Project project = new Project();

        Set<Contact> contacts = Set.of(contact);
        Set<Project> projects = Set.of(project);

        Organization organization = OrganizationBuilder.builder()
                .id(id)
                .legalName("CodeSync Tecnologia Ltda")
                .fantasyName("CodeSync")
                .slug("codesync")
                .economicActivity("Software Development")
                .document("12.345.678/0001-90")
                .stateRegistration("123456789")
                .municipalRegistration("987654321")
                .active(true)
                .projects(projects)
                .address(address)
                .contacts(contacts)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, organization.getId()),
                () -> Assertions.assertEquals("CodeSync Tecnologia Ltda", organization.getLegalName()),
                () -> Assertions.assertEquals("CodeSync", organization.getFantasyName()),
                () -> Assertions.assertEquals("codesync", organization.getSlug()),
                () -> Assertions.assertEquals("Software Development", organization.getEconomicActivity()),
                () -> Assertions.assertEquals("12.345.678/0001-90", organization.getDocument()),
                () -> Assertions.assertEquals("123456789", organization.getStateRegistration()),
                () -> Assertions.assertEquals("987654321", organization.getMunicipalRegistration()),
                () -> Assertions.assertTrue(organization.isActive()),
                () -> Assertions.assertEquals(projects, organization.getProjects()),
                () -> Assertions.assertEquals(address, organization.getAddress()),
                () -> Assertions.assertEquals(contacts, organization.getContacts())
        );
    }

    @Test
    @DisplayName("Should create an empty organization when no values are provided")
    void shouldCreateEmptyOrganizationWhenNoValuesAreProvided() {
        Organization organization = OrganizationBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(organization.getId()),
                () -> Assertions.assertNull(organization.getLegalName()),
                () -> Assertions.assertNull(organization.getFantasyName()),
                () -> Assertions.assertNull(organization.getSlug()),
                () -> Assertions.assertNull(organization.getEconomicActivity()),
                () -> Assertions.assertNull(organization.getDocument()),
                () -> Assertions.assertNull(organization.getStateRegistration()),
                () -> Assertions.assertNull(organization.getMunicipalRegistration()),
                () -> Assertions.assertTrue(organization.isActive()),
                () -> Assertions.assertTrue(organization.getProjects().isEmpty()),
                () -> Assertions.assertNull(organization.getAddress()),
                () -> Assertions.assertTrue(organization.getContacts().isEmpty())
        );
    }
}