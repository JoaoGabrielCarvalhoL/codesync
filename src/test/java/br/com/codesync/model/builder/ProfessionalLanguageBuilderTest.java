package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProfessionalLanguage;
import br.com.codesync.model.entity.ProfessionalProfile;
import br.com.codesync.model.enumerations.LanguageProficiency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ProfessionalLanguageBuilderTest {

    @Test
    @DisplayName("Should create professional language with valid values")
    void shouldCreateProfessionalLanguageWithValidValues() {
        UUID id = UUID.randomUUID();
        ProfessionalProfile profile = new ProfessionalProfile();

        ProfessionalLanguage language = defaultProfessionalLanguageBuilder()
                .id(id)
                .professionalProfile(profile)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, language.getId()),
                () -> Assertions.assertEquals("English", language.getName()),
                () -> Assertions.assertEquals(LanguageProficiency.NATIVE_BILINGUAL, language.getLanguageProficiency()),
                () -> Assertions.assertSame(profile, language.getProfessionalProfile())
        );
    }

    @Test
    @DisplayName("Should create empty professional language when no values are provided")
    void shouldCreateEmptyProfessionalLanguageWhenNoValuesAreProvided() {
        ProfessionalLanguage language = ProfessionalLanguageBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(language.getId()),
                () -> Assertions.assertNull(language.getName()),
                () -> Assertions.assertNull(language.getLanguageProficiency()),
                () -> Assertions.assertNull(language.getProfessionalProfile())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        ProfessionalLanguageBuilder builder = ProfessionalLanguageBuilder.builder();

        ProfessionalLanguage first = builder
                .name("English")
                .proficiencyLevel(LanguageProficiency.NATIVE_BILINGUAL)
                .build();

        ProfessionalLanguage second = builder
                .name("Spanish")
                .proficiencyLevel(LanguageProficiency.ELEMENTARY)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("English", first.getName()),
                () -> Assertions.assertEquals("Spanish", second.getName()),
                () -> Assertions.assertEquals(LanguageProficiency.NATIVE_BILINGUAL, first.getLanguageProficiency()),
                () -> Assertions.assertEquals(LanguageProficiency.ELEMENTARY, second.getLanguageProficiency())
        );
    }

    private ProfessionalLanguageBuilder defaultProfessionalLanguageBuilder() {
        return ProfessionalLanguageBuilder.builder()
                .name("English")
                .proficiencyLevel(LanguageProficiency.NATIVE_BILINGUAL);
    }

}