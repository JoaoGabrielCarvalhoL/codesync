package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Certification;
import br.com.codesync.model.entity.ProfessionalProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class CertificationBuilderTest {

    @Test
    @DisplayName("Should create a certification with valid values")
    void shouldCreateCertificationWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDate obtainedIn = LocalDate.of(2024, 1, 15);
        LocalDate validUntil = LocalDate.of(2027, 1, 15);

        ProfessionalProfile professionalProfile = new ProfessionalProfile();

        Certification certification = defaultCertificationBuilder()
                .id(id)
                .obtainedIn(obtainedIn)
                .validUntil(validUntil)
                .professionalProfile(professionalProfile)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, certification.getId()),
                () -> Assertions.assertEquals("AWS Certified Developer - Associate", certification.getName()),
                () -> Assertions.assertEquals("Amazon Web Services", certification.getIssuer()),
                () -> Assertions.assertEquals("https://www.credly.com/badges/example", certification.getCertificateUrl()),
                () -> Assertions.assertEquals("AWS-123456789", certification.getCredentialId()),
                () -> Assertions.assertEquals(obtainedIn, certification.getObtainedIn()),
                () -> Assertions.assertEquals(validUntil, certification.getValidUntil()),
                () -> Assertions.assertSame(professionalProfile, certification.getProfessionalProfile())
        );
    }

    @Test
    @DisplayName("Should create an empty certification when no values are provided")
    void shouldCreateEmptyCertificationWhenNoValuesAreProvided() {
        Certification certification = CertificationBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(certification.getId()),
                () -> Assertions.assertNull(certification.getName()),
                () -> Assertions.assertNull(certification.getIssuer()),
                () -> Assertions.assertNull(certification.getCertificateUrl()),
                () -> Assertions.assertNull(certification.getCredentialId()),
                () -> Assertions.assertNull(certification.getObtainedIn()),
                () -> Assertions.assertNull(certification.getValidUntil()),
                () -> Assertions.assertNull(certification.getProfessionalProfile())
        );
    }

    private CertificationBuilder defaultCertificationBuilder() {
        return CertificationBuilder.builder()
                .name("AWS Certified Developer - Associate")
                .issuer("Amazon Web Services")
                .certificateUrl("https://www.credly.com/badges/example")
                .credentialId("AWS-123456789");
    }

}