package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectMember;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.ProjectRole;

import java.time.LocalDate;
import java.util.UUID;

public final class ProjectMemberBuilder {

    private ProjectMember projectMember;

    private ProjectMemberBuilder() {
        this.projectMember = new ProjectMember();
    }

    public static ProjectMemberBuilder builder() {
        return new ProjectMemberBuilder();
    }

    public ProjectMemberBuilder id(UUID id) {
        this.projectMember.setId(id);
        return this;
    }

    public ProjectMemberBuilder project(Project project) {
        this.projectMember.setProject(project);
        return this;
    }

    public ProjectMemberBuilder user(User user) {
        this.projectMember.setUser(user);
        return this;
    }

    public ProjectMemberBuilder role(ProjectRole role) {
        this.projectMember.setRole(role);
        return this;
    }

    public ProjectMemberBuilder allocatedHoursPerWeek(Integer allocatedHoursPerWeek) {
        this.projectMember.setAllocatedHoursPerWeek(allocatedHoursPerWeek);
        return this;
    }

    public ProjectMemberBuilder startDate(LocalDate startDate) {
        this.projectMember.setStartDate(startDate);
        return this;
    }

    public ProjectMemberBuilder endDate(LocalDate endDate) {
        this.projectMember.setEndDate(endDate);
        return this;
    }

    public ProjectMemberBuilder active(boolean active) {
        this.projectMember.setActive(active);
        return this;
    }

    public ProjectMember build() {
        ProjectMember result = this.projectMember;
        this.projectMember = new ProjectMember();
        return result;
    }
}
