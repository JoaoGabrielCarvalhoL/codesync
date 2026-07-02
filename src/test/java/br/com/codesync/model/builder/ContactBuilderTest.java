package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Contact;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.ContactType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ContactBuilderTest {

    @Test
    @DisplayName("Should create a contact with valid values")
    void shouldCreateContactWithValidValues() {
        UUID id = UUID.randomUUID();
        User user = new User();

        Contact contact = defaultContactBuilder()
                .id(id)
                .user(user)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, contact.getId()),
                () -> Assertions.assertEquals(ContactType.PERSONAL, contact.getType()),
                () -> Assertions.assertEquals("14 999999999", contact.getContactValue()),
                () -> Assertions.assertEquals("Primary professional contact", contact.getNotes()),
                () -> Assertions.assertSame(user, contact.getUser())
        );
    }

    @Test
    @DisplayName("Should create an empty contact when no values are provided")
    void shouldCreateEmptyContactWhenNoValuesAreProvided() {
        Contact contact = ContactBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(contact.getId()),
                () -> Assertions.assertNull(contact.getType()),
                () -> Assertions.assertNull(contact.getContactValue()),
                () -> Assertions.assertNull(contact.getNotes()),
                () -> Assertions.assertNull(contact.getUrl()),
                () -> Assertions.assertNull(contact.getUser())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        ContactBuilder builder = ContactBuilder.builder();

        Contact first = builder
                .type(ContactType.PERSONAL)
                .contactValue("@first")
                .build();

        Contact second = builder
                .type(ContactType.WORK)
                .contactValue("@second")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(ContactType.PERSONAL, first.getType()),
                () -> Assertions.assertEquals(ContactType.WORK, second.getType()),
                () -> Assertions.assertEquals("@first", first.getContactValue()),
                () -> Assertions.assertEquals("@second", second.getContactValue())
        );
    }

    private ContactBuilder defaultContactBuilder() {
        return ContactBuilder.builder()
                .type(ContactType.PERSONAL)
                .contactValue("14 999999999")
                .notes("Primary professional contact")
                .url("https://github.com/JoaoGabrielCarvalhoL/codesync");
    }

}