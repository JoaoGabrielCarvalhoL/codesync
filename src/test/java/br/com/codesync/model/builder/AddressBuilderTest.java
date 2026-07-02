package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Address;
import br.com.codesync.model.enumerations.AddressType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class AddressBuilderTest {

    @Test
    @DisplayName("Should create a commercial address with valid values")
    void shouldCreateCommercialAddressWithValidValues() {
        UUID id = UUID.randomUUID();

        Address address = AddressBuilder.builder()
                .id(id)
                .zipCode("01310-100")
                .street("Avenida Paulista")
                .number("1578")
                .complement("Conjunto 101")
                .neighborhood("Bela Vista")
                .city("São Paulo")
                .state("SP")
                .country("Brasil")
                .type(AddressType.COMMERCIAL)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, address.getId()),
                () -> Assertions.assertEquals("01310-100", address.getZipCode()),
                () -> Assertions.assertEquals("Avenida Paulista", address.getStreet()),
                () -> Assertions.assertEquals("1578", address.getNumber()),
                () -> Assertions.assertEquals("Conjunto 101", address.getComplement()),
                () -> Assertions.assertEquals("Bela Vista", address.getNeighborhood()),
                () -> Assertions.assertEquals("São Paulo", address.getCity()),
                () -> Assertions.assertEquals("SP", address.getState()),
                () -> Assertions.assertEquals("Brasil", address.getCountry()),
                () -> Assertions.assertEquals(AddressType.COMMERCIAL, address.getType()));
    }

    @Test
    @DisplayName("Should create an empty address when no values are provided")
    void shouldCreateEmptyAddressWhenNoValuesAreProvided() {
        Address address = AddressBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(address.getId()),
                () -> Assertions.assertNull(address.getZipCode()),
                () -> Assertions.assertNull(address.getStreet()),
                () -> Assertions.assertNull(address.getNumber()),
                () -> Assertions.assertNull(address.getComplement()),
                () -> Assertions.assertNull(address.getNeighborhood()),
                () -> Assertions.assertNull(address.getCity()),
                () -> Assertions.assertNull(address.getState()),
                () -> Assertions.assertNull(address.getCountry()),
                () -> Assertions.assertNull(address.getType()));
    }

}