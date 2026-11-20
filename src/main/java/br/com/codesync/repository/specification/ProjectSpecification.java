package br.com.codesync.repository.specification;

import br.com.codesync.model.entity.Organization;
import br.com.codesync.model.entity.Project;
import br.com.codesync.model.enumerations.ProjectStatus;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class ProjectSpecification {

    private ProjectSpecification() { }

    public static Specification<Project> hasOrganizationId(UUID organizationId) {
        return (root, query, cb) -> {
            if (organizationId == null) return cb.conjunction();
            Join<Project, Organization> orgJoin = root.join("organization", JoinType.INNER);
            return cb.equal(orgJoin.get("id"), organizationId);
        };
    }

    public static Specification<Project> hasStatuses(Collection<ProjectStatus> statuses) {
        return (root, query, cb) -> {
            if (statuses == null || statuses.isEmpty()) return cb.conjunction();
            return root.get("status").in(statuses);
        };
    }

    public static Specification<Project> nameOrCodeContains(String term) {
        return (root, query, cb) -> {
            if (term == null || term.isBlank()) return cb.conjunction();
            String pattern = "%" + term.trim().toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("name")), pattern),
                    cb.like(cb.lower(root.get("code")), pattern)
            );
        };
    }

    public static Specification<Project> startDateAfterOrEqual(LocalDate startDate) {
        return (root, query, cb) -> {
            if (startDate == null) return cb.conjunction();
            return cb.greaterThanOrEqualTo(root.get("startDate"), startDate);
        };
    }

    public static Specification<Project> endDateBeforeOrEqual(LocalDate endDate) {
        return (root, query, cb) -> {
            if (endDate == null) return cb.conjunction();
            return cb.lessThanOrEqualTo(root.get("endDate"), endDate);
        };
    }
}
