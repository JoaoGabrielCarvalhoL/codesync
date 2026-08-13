package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.ApprovalStatus;
import br.com.codesync.model.enumerations.TaskPriority;
import br.com.codesync.model.enumerations.TaskStatus;
import br.com.codesync.model.enumerations.TaskType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class TaskBuilderTest {

    @Test
    @DisplayName("Should create a task with valid values")
    void shouldCreateTaskWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDateTime assignedAt = LocalDateTime.now();
        LocalDate dueDate = LocalDate.now().plusDays(7);
        LocalDateTime completedAt = LocalDateTime.now().plusDays(5);
        BigDecimal estimatedHours = new BigDecimal("8.50");

        Project project = new Project();
        Sprint sprint = new Sprint();
        Milestone milestone = new Milestone();
        User reporter = new User();
        ProjectMember assigned = new ProjectMember();

        AcceptanceCriteria acceptanceCriteria = new AcceptanceCriteria();
        Attachment attachment = new Attachment();

        List<AcceptanceCriteria> acceptanceCriteriaList = List.of(acceptanceCriteria);
        List<Attachment> attachments = List.of(attachment);

        TaskType type = TaskType.FEATURE;
        TaskStatus status = TaskStatus.OPEN;
        TaskPriority priority = TaskPriority.MEDIUM;
        ApprovalStatus approvalStatus = ApprovalStatus.NONE;

        Task task = TaskBuilder.builder()
                .id(id)
                .code("TASK-001")
                .title("Implement task builder")
                .description("Create a builder for the Task entity")
                .goal("Allow fluent creation of Task instances")
                .type(type)
                .status(status)
                .priority(priority)
                .approvalStatus(approvalStatus)
                .storyPoints(5)
                .estimatedHours(estimatedHours)
                .assignedAt(assignedAt)
                .dueDate(dueDate)
                .completedAt(completedAt)
                .project(project)
                .sprint(sprint)
                .milestone(milestone)
                .reporter(reporter)
                .assigned(assigned)
                .acceptanceCriteria(acceptanceCriteriaList)
                .attachments(attachments)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, task.getId()),
                () -> Assertions.assertEquals("TASK-001", task.getCode()),
                () -> Assertions.assertEquals("Implement task builder", task.getTitle()),
                () -> Assertions.assertEquals("Create a builder for the Task entity", task.getDescription()),
                () -> Assertions.assertEquals("Allow fluent creation of Task instances", task.getGoal()),
                () -> Assertions.assertEquals(type, task.getType()),
                () -> Assertions.assertEquals(status, task.getStatus()),
                () -> Assertions.assertEquals(priority, task.getPriority()),
                () -> Assertions.assertEquals(approvalStatus, task.getApprovalStatus()),
                () -> Assertions.assertEquals(5, task.getStoryPoints()),
                () -> Assertions.assertEquals(estimatedHours, task.getEstimatedHours()),
                () -> Assertions.assertEquals(assignedAt, task.getAssignedAt()),
                () -> Assertions.assertEquals(dueDate, task.getDueDate()),
                () -> Assertions.assertEquals(completedAt, task.getCompletedAt()),
                () -> Assertions.assertEquals(project, task.getProject()),
                () -> Assertions.assertEquals(sprint, task.getSprint()),
                () -> Assertions.assertEquals(milestone, task.getMilestone()),
                () -> Assertions.assertEquals(reporter, task.getReporter()),
                () -> Assertions.assertEquals(assigned, task.getAssigned()),
                () -> Assertions.assertEquals(acceptanceCriteriaList, task.getAcceptanceCriteria()),
                () -> Assertions.assertEquals(attachments, task.getAttachments())
        );
    }

    @Test
    @DisplayName("Should create an empty task when no values are provided")
    void shouldCreateEmptyTaskWhenNoValuesAreProvided() {
        Task task = TaskBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(task.getId()),
                () -> Assertions.assertNull(task.getCode()),
                () -> Assertions.assertNull(task.getTitle()),
                () -> Assertions.assertNull(task.getDescription()),
                () -> Assertions.assertNull(task.getGoal()),
                () -> Assertions.assertNull(task.getType()),
                () -> Assertions.assertNull(task.getStatus()),
                () -> Assertions.assertNull(task.getPriority()),
                () -> Assertions.assertNull(task.getApprovalStatus()),
                () -> Assertions.assertNull(task.getStoryPoints()),
                () -> Assertions.assertNull(task.getEstimatedHours()),
                () -> Assertions.assertNull(task.getAssignedAt()),
                () -> Assertions.assertNull(task.getDueDate()),
                () -> Assertions.assertNull(task.getCompletedAt()),
                () -> Assertions.assertNull(task.getProject()),
                () -> Assertions.assertNull(task.getSprint()),
                () -> Assertions.assertNull(task.getMilestone()),
                () -> Assertions.assertNull(task.getReporter()),
                () -> Assertions.assertNull(task.getAssigned()),
                () -> Assertions.assertNotNull(task.getAcceptanceCriteria()),
                () -> Assertions.assertTrue(task.getAcceptanceCriteria().isEmpty()),
                () -> Assertions.assertNotNull(task.getAttachments()),
                () -> Assertions.assertTrue(task.getAttachments().isEmpty())
        );
    }
}