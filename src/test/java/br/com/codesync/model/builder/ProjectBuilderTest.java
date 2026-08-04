package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.BillingType;
import br.com.codesync.model.enumerations.Currency;
import br.com.codesync.model.enumerations.ProjectPriority;
import br.com.codesync.model.enumerations.ProjectStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

class ProjectBuilderTest {

    @Test
    @DisplayName("Should create a project with valid values")
    void shouldCreateProjectWithValidValues() {
        UUID id = UUID.randomUUID();

        LocalDate startDate = LocalDate.now();
        LocalDate targetEndDate = startDate.plusMonths(6);
        LocalDate actualEndDate = targetEndDate.plusDays(5);

        Organization organization = new Organization();
        ProjectMember member = new ProjectMember();
        ProjectRequiredSkill requiredSkill = new ProjectRequiredSkill();
        ProjectEnvironment environment = new ProjectEnvironment();

        Set<ProjectMember> members = Set.of(member);
        Set<ProjectRequiredSkill> requiredSkills = Set.of(requiredSkill);
        Set<ProjectEnvironment> environments = Set.of(environment);

        Project project = ProjectBuilder.builder()
                .id(id)
                .name("CodeSync Platform")
                .slug("codesync-platform")
                .description("Development of the CodeSync platform")
                .status(ProjectStatus.IN_PROGRESS)
                .priority(ProjectPriority.HIGH)
                .contractCode("CTR-001")
                .billingType(BillingType.TIME_AND_MATERIALS)
                .estimatedHours(500)
                .maxBillableHours(550)
                .hourlyRate(BigDecimal.valueOf(250))
                .currency(Currency.BRL)
                .startDate(startDate)
                .targetEndDate(targetEndDate)
                .actualEndDate(actualEndDate)
                .organization(organization)
                .members(members)
                .requiredSkills(requiredSkills)
                .environments(environments)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, project.getId()),
                () -> Assertions.assertEquals("CodeSync Platform", project.getName()),
                () -> Assertions.assertEquals("codesync-platform", project.getSlug()),
                () -> Assertions.assertEquals("Development of the CodeSync platform", project.getDescription()),
                () -> Assertions.assertEquals(ProjectStatus.IN_PROGRESS, project.getStatus()),
                () -> Assertions.assertEquals(ProjectPriority.HIGH, project.getPriority()),
                () -> Assertions.assertEquals("CTR-001", project.getContractCode()),
                () -> Assertions.assertEquals(BillingType.TIME_AND_MATERIALS, project.getBillingType()),
                () -> Assertions.assertEquals(500, project.getEstimatedHours()),
                () -> Assertions.assertEquals(550, project.getMaxBillableHours()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(250), project.getHourlyRate()),
                () -> Assertions.assertEquals(Currency.BRL, project.getCurrency()),
                () -> Assertions.assertEquals(startDate, project.getStartDate()),
                () -> Assertions.assertEquals(targetEndDate, project.getTargetEndDate()),
                () -> Assertions.assertEquals(actualEndDate, project.getActualEndDate()),
                () -> Assertions.assertEquals(organization, project.getOrganization()),
                () -> Assertions.assertEquals(members, project.getMembers()),
                () -> Assertions.assertEquals(requiredSkills, project.getRequiredSkills()),
                () -> Assertions.assertEquals(environments, project.getEnvironments())
        );
    }

    @Test
    @DisplayName("Should create an empty project when no values are provided")
    void shouldCreateEmptyProjectWhenNoValuesAreProvided() {
        Project project = ProjectBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(project.getId()),
                () -> Assertions.assertNull(project.getName()),
                () -> Assertions.assertNull(project.getSlug()),
                () -> Assertions.assertNull(project.getDescription()),
                () -> Assertions.assertNull(project.getStatus()),
                () -> Assertions.assertNull(project.getPriority()),
                () -> Assertions.assertNull(project.getContractCode()),
                () -> Assertions.assertNull(project.getBillingType()),
                () -> Assertions.assertNull(project.getEstimatedHours()),
                () -> Assertions.assertNull(project.getMaxBillableHours()),
                () -> Assertions.assertNull(project.getHourlyRate()),
                () -> Assertions.assertNull(project.getCurrency()),
                () -> Assertions.assertNull(project.getStartDate()),
                () -> Assertions.assertNull(project.getTargetEndDate()),
                () -> Assertions.assertNull(project.getActualEndDate()),
                () -> Assertions.assertNull(project.getOrganization()),
                () -> Assertions.assertNull(project.getMembers()),
                () -> Assertions.assertTrue(project.getRequiredSkills().isEmpty()),
                () -> Assertions.assertTrue(project.getEnvironments().isEmpty())
        );
    }
}