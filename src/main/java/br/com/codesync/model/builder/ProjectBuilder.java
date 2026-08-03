package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.BillingType;
import br.com.codesync.model.enumerations.Currency;
import br.com.codesync.model.enumerations.ProjectPriority;
import br.com.codesync.model.enumerations.ProjectStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public final class ProjectBuilder {

    private Project project;

    private ProjectBuilder() {
        this.project = new Project();
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public ProjectBuilder id(UUID id) {
        this.project.setId(id);
        return this;
    }

    public ProjectBuilder name(String name) {
        this.project.setName(name);
        return this;
    }

    public ProjectBuilder slug(String slug) {
        this.project.setSlug(slug);
        return this;
    }

    public ProjectBuilder description(String description) {
        this.project.setDescription(description);
        return this;
    }

    public ProjectBuilder status(ProjectStatus status) {
        this.project.setStatus(status);
        return this;
    }

    public ProjectBuilder priority(ProjectPriority priority) {
        this.project.setPriority(priority);
        return this;
    }

    public ProjectBuilder contractCode(String contractCode) {
        this.project.setContractCode(contractCode);
        return this;
    }

    public ProjectBuilder billingType(BillingType billingType) {
        this.project.setBillingType(billingType);
        return this;
    }

    public ProjectBuilder estimatedHours(Integer estimatedHours) {
        this.project.setEstimatedHours(estimatedHours);
        return this;
    }

    public ProjectBuilder maxBillableHours(Integer maxBillableHours) {
        this.project.setMaxBillableHours(maxBillableHours);
        return this;
    }

    public ProjectBuilder hourlyRate(BigDecimal hourlyRate) {
        this.project.setHourlyRate(hourlyRate);
        return this;
    }

    public ProjectBuilder currency(Currency currency) {
        this.project.setCurrency(currency);
        return this;
    }

    public ProjectBuilder startDate(LocalDate startDate) {
        this.project.setStartDate(startDate);
        return this;
    }

    public ProjectBuilder targetEndDate(LocalDate targetEndDate) {
        this.project.setTargetEndDate(targetEndDate);
        return this;
    }

    public ProjectBuilder actualEndDate(LocalDate actualEndDate) {
        this.project.setActualEndDate(actualEndDate);
        return this;
    }

    public ProjectBuilder organization(Organization organization) {
        this.project.setOrganization(organization);
        return this;
    }

    public ProjectBuilder members(Set<ProjectMember> members) {
        this.project.setMembers(members);
        return this;
    }

    public ProjectBuilder requiredSkills(Set<ProjectRequiredSkill> requiredSkills) {
        this.project.setRequiredSkills(requiredSkills);
        return this;
    }

    public ProjectBuilder environments(Set<ProjectEnvironment> environments) {
        this.project.setEnvironments(environments);
        return this;
    }

    public Project build() {
        Project result = this.project;
        this.project = new Project();
        return result;
    }
}
