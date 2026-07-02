package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.ProfessionalStatus;
import br.com.codesync.model.enumerations.SeniorityLevel;
import br.com.codesync.model.enumerations.WorkMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

class ProfessionalProfileBuilderTest {

    @Test
    @DisplayName("Should create professional profile with valid values")
    void shouldCreateProfessionalProfileWithValidValues() {
        UUID id = UUID.randomUUID();

        Certification certification = new Certification();
        ProfessionalSkill skill = new ProfessionalSkill();
        ProfessionalLanguage language = new ProfessionalLanguage();
        User user = new User();

        ProfessionalProfile profile = defaultProfessionalProfileBuilder()
                .id(id)
                .certifications(Set.of(certification))
                .skills(Set.of(skill))
                .professionalLanguages(Set.of(language))
                .user(user)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, profile.getId()),
                () -> Assertions.assertEquals("Backend Engineer", profile.getJobTitle()),
                () -> Assertions.assertEquals("Computer Science", profile.getGraduation()),
                () -> Assertions.assertEquals(SeniorityLevel.SENIOR, profile.getSeniorityLevel()),
                () -> Assertions.assertEquals("Experienced backend developer", profile.getProfessionalSummary()),
                () -> Assertions.assertEquals(8, profile.getYearsOfExperience()),
                () -> Assertions.assertEquals(ProfessionalStatus.ACTIVE, profile.getProfessionalStatus()),
                () -> Assertions.assertEquals(WorkMode.REMOTE, profile.getWorkMode()),
                () -> Assertions.assertEquals(40, profile.getCapacityHoursPerWeek()),
                () -> Assertions.assertSame(user, profile.getUser()),
                () -> Assertions.assertEquals(1, profile.getProfessionalSkills().size()),
                () -> Assertions.assertEquals(1, profile.getProfessionalLanguages().size()),
                () -> Assertions.assertEquals(1, profile.getCertifications().size())
        );
    }

    @Test
    @DisplayName("Should create empty professional profile when no values are provided")
    void shouldCreateEmptyProfessionalProfileWhenNoValuesAreProvided() {
        ProfessionalProfile profile = ProfessionalProfileBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(profile.getId()),
                () -> Assertions.assertNull(profile.getJobTitle()),
                () -> Assertions.assertNull(profile.getGraduation()),
                () -> Assertions.assertNull(profile.getSeniorityLevel()),
                () -> Assertions.assertNull(profile.getProfessionalSummary()),
                () -> Assertions.assertNull(profile.getYearsOfExperience()),
                () -> Assertions.assertTrue(profile.getCertifications().isEmpty()),
                () -> Assertions.assertNull(profile.getProfessionalStatus()),
                () -> Assertions.assertNull(profile.getWorkMode()),
                () -> Assertions.assertNull(profile.getCapacityHoursPerWeek()),
                () -> Assertions.assertTrue(profile.getProfessionalSkills().isEmpty()),
                () -> Assertions.assertTrue(profile.getProfessionalLanguages().isEmpty()),
                () -> Assertions.assertNull(profile.getUser())
        );
    }

    @Test
    @DisplayName("Should not share state between multiple builds")
    void shouldNotShareStateBetweenMultipleBuilds() {
        ProfessionalProfileBuilder builder = ProfessionalProfileBuilder.builder();

        ProfessionalProfile first = builder
                .jobTitle("Backend Engineer")
                .build();

        ProfessionalProfile second = builder
                .jobTitle("Frontend Engineer")
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals("Backend Engineer", first.getJobTitle()),
                () -> Assertions.assertEquals("Frontend Engineer", second.getJobTitle())
        );
    }

    private ProfessionalProfileBuilder defaultProfessionalProfileBuilder() {
        return ProfessionalProfileBuilder.builder()
                .jobTitle("Backend Engineer")
                .graduation("Computer Science")
                .seniorityLevel(SeniorityLevel.SENIOR)
                .professionalSummary("Experienced backend developer")
                .yearsOfExperience(8)
                .professionalStatus(ProfessionalStatus.ACTIVE)
                .workMode(WorkMode.REMOTE)
                .capacityHoursPerWeek(40);
    }

}