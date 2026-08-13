package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.ApprovalStatus;
import br.com.codesync.model.enumerations.TaskPriority;
import br.com.codesync.model.enumerations.TaskStatus;
import br.com.codesync.model.enumerations.TaskType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TaskBuilder {

    private Task task;

    private TaskBuilder() {
        this.task = new Task();
    }

    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public TaskBuilder id(UUID id) {
        this.task.setId(id);
        return this;
    }

    public TaskBuilder code(String code) {
        this.task.setCode(code);
        return this;
    }

    public TaskBuilder title(String title) {
        this.task.setTitle(title);
        return this;
    }

    public TaskBuilder description(String description) {
        this.task.setDescription(description);
        return this;
    }

    public TaskBuilder goal(String goal) {
        this.task.setGoal(goal);
        return this;
    }

    public TaskBuilder type(TaskType type) {
        this.task.setType(type);
        return this;
    }

    public TaskBuilder status(TaskStatus status) {
        this.task.setStatus(status);
        return this;
    }

    public TaskBuilder priority(TaskPriority priority) {
        this.task.setPriority(priority);
        return this;
    }

    public TaskBuilder approvalStatus(ApprovalStatus approvalStatus) {
        this.task.setApprovalStatus(approvalStatus);
        return this;
    }

    public TaskBuilder storyPoints(Integer storyPoints) {
        this.task.setStoryPoints(storyPoints);
        return this;
    }

    public TaskBuilder estimatedHours(BigDecimal estimatedHours) {
        this.task.setEstimatedHours(estimatedHours);
        return this;
    }

    public TaskBuilder assignedAt(LocalDateTime assignedAt) {
        this.task.setAssignedAt(assignedAt);
        return this;
    }

    public TaskBuilder dueDate(LocalDate dueDate) {
        this.task.setDueDate(dueDate);
        return this;
    }

    public TaskBuilder completedAt(LocalDateTime completedAt) {
        this.task.setCompletedAt(completedAt);
        return this;
    }

    public TaskBuilder project(Project project) {
        this.task.setProject(project);
        return this;
    }

    public TaskBuilder sprint(Sprint sprint) {
        this.task.setSprint(sprint);
        return this;
    }

    public TaskBuilder milestone(Milestone milestone) {
        this.task.setMilestone(milestone);
        return this;
    }

    public TaskBuilder reporter(User reporter) {
        this.task.setReporter(reporter);
        return this;
    }

    public TaskBuilder assigned(ProjectMember assigned) {
        this.task.setAssigned(assigned);
        return this;
    }

    public TaskBuilder acceptanceCriteria(List<AcceptanceCriteria> acceptanceCriteria) {
        this.task.setAcceptanceCriteria(acceptanceCriteria);
        return this;
    }

    public TaskBuilder attachments(List<Attachment> attachments) {
        this.task.setAttachments(attachments);
        return this;
    }

    public Task build() {
        Task result = this.task;
        this.task = new Task();
        return result;
    }
}
