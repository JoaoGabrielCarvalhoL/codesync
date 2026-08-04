package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectMember;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.ProjectRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class ProjectMemberBuilderTest {

    @Test
    @DisplayName("Should create a project member with valid values")
    void shouldCreateProjectMemberWithValidValues() {
        UUID id = UUID.randomUUID();

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(6);

        Project project = new Project();
        User user = new User();

        ProjectMember projectMember = ProjectMemberBuilder.builder()
                .id(id)
                .project(project)
                .user(user)
                .role(ProjectRole.DEVELOPER)
                .allocatedHoursPerWeek(40)
                .startDate(startDate)
                .endDate(endDate)
                .active(true)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, projectMember.getId()),
                () -> Assertions.assertEquals(project, projectMember.getProject()),
                () -> Assertions.assertEquals(user, projectMember.getUser()),
                () -> Assertions.assertEquals(ProjectRole.DEVELOPER, projectMember.getRole()),
                () -> Assertions.assertEquals(40, projectMember.getAllocatedHoursPerWeek()),
                () -> Assertions.assertEquals(startDate, projectMember.getStartDate()),
                () -> Assertions.assertEquals(endDate, projectMember.getEndDate()),
                () -> Assertions.assertTrue(projectMember.isActive())
        );
    }

    @Test
    @DisplayName("Should create an empty project member when no values are provided")
    void shouldCreateEmptyProjectMemberWhenNoValuesAreProvided() {
        ProjectMember projectMember = ProjectMemberBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(projectMember.getId()),
                () -> Assertions.assertNull(projectMember.getProject()),
                () -> Assertions.assertNull(projectMember.getUser()),
                () -> Assertions.assertNull(projectMember.getRole()),
                () -> Assertions.assertNull(projectMember.getAllocatedHoursPerWeek()),
                () -> Assertions.assertNull(projectMember.getStartDate()),
                () -> Assertions.assertNull(projectMember.getEndDate()),
                () -> Assertions.assertTrue(projectMember.isActive())
        );
    }
}