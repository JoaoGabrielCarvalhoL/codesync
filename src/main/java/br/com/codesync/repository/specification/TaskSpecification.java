package br.com.codesync.repository.specification;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectMember;
import br.com.codesync.model.entity.Task;
import br.com.codesync.model.enumerations.ApprovalStatus;
import br.com.codesync.model.enumerations.TaskPriority;
import br.com.codesync.model.enumerations.TaskStatus;
import br.com.codesync.model.enumerations.TaskType;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class TaskSpecification {

    private TaskSpecification() { }

    public static Specification<Task> hasProjectId(UUID projectId) {
        return (root, query, cb) -> {
            if (projectId == null) return cb.conjunction();
            Join<Task, Project> projectJoin = root.join("project", JoinType.INNER);
            return cb.equal(projectJoin.get("id"), projectId);
        };
    }

    public static Specification<Task> hasStatuses(Collection<TaskStatus> statuses) {
        return (root, query, cb) -> {
            if (statuses == null || statuses.isEmpty()) return cb.conjunction();
            return root.get("status").in(statuses);
        };
    }

    public static Specification<Task> hasPriorities(Collection<TaskPriority> priorities) {
        return (root, query, cb) -> {
            if (priorities == null || priorities.isEmpty()) return cb.conjunction();
            return root.get("priority").in(priorities);
        };
    }

    public static Specification<Task> hasTypes(Collection<TaskType> types) {
        return (root, query, cb) -> {
            if (types == null || types.isEmpty()) return cb.conjunction();
            return root.get("type").in(types);
        };
    }

    public static Specification<Task> hasApprovalStatus(ApprovalStatus approvalStatus) {
        return (root, query, cb) -> {
            if (approvalStatus == null) return cb.conjunction();
            return cb.equal(root.get("approvalStatus"), approvalStatus);
        };
    }

    public static Specification<Task> hasAssignedMemberId(UUID memberId) {
        return (root, query, cb) -> {
            if (memberId == null) return cb.conjunction();
            Join<Task, ProjectMember> assignedJoin = root.join("assigned", JoinType.LEFT);
            return cb.equal(assignedJoin.get("id"), memberId);
        };
    }

    public static Specification<Task> hasSprintId(UUID sprintId) {
        return (root, query, cb) -> {
            if (sprintId == null) return cb.conjunction();
            return cb.equal(root.get("sprint").get("id"), sprintId);
        };
    }

    public static Specification<Task> hasMilestoneId(UUID milestoneId) {
        return (root, query, cb) -> {
            if (milestoneId == null) return cb.conjunction();
            return cb.equal(root.get("milestone").get("id"), milestoneId);
        };
    }

    public static Specification<Task> titleOrCodeContains(String term) {
        return (root, query, cb) -> {
            if (term == null || term.isBlank()) return cb.conjunction();
            String pattern = "%" + term.trim().toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("title")), pattern),
                    cb.like(cb.lower(root.get("code")), pattern)
            );
        };
    }

    public static Specification<Task> dueDateBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, cb) -> {
            if (startDate == null && endDate == null) return cb.conjunction();
            if (startDate != null && endDate != null) {
                return cb.between(root.get("dueDate"), startDate, endDate);
            }
            if (startDate != null) {
                return cb.greaterThanOrEqualTo(root.get("dueDate"), startDate);
            }
            return cb.lessThanOrEqualTo(root.get("dueDate"), endDate);
        };
    }
}
