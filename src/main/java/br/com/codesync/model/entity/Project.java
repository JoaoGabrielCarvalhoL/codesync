package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.BillingType;
import br.com.codesync.model.enumerations.Currency;
import br.com.codesync.model.enumerations.ProjectPriority;
import br.com.codesync.model.enumerations.ProjectStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_projects", indexes = {
        @Index(name = "idx_project_organization", columnList = "organization_id"),
        @Index(name = "idx_project_slug_org", columnList = "slug, organization_id", unique = true),
        @Index(name = "idx_project_contract_code", columnList = "contract_code")
})
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 60)
    private String slug;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjectStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjectPriority priority;

    @Column(name = "contract_code", length = 50)
    private String contractCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "billing_type", nullable = false, length = 30)
    private BillingType billingType;

    @Column(name = "repository_url", length = 255)
    private String repositoryUrl;

    @Column(name = "documentation_url", length = 255)
    private String documentationUrl;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "max_billable_hours")
    private Integer maxBillableHours;

    @Column(name = "hourly_rate", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "target_end_date")
    private LocalDate targetEndDate;

    @Column(name = "actual_end_date")
    private LocalDate actualEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProjectMember> members;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProjectRequiredSkill> requiredSkills = new HashSet<>();

    public Project() {}

    public Project(String name, String slug, String description, ProjectStatus status, ProjectPriority priority,
                   String contractCode, BillingType billingType, String repositoryUrl, String documentationUrl,
                   Integer estimatedHours, Integer maxBillableHours, BigDecimal hourlyRate, Currency currency,
                   LocalDate startDate, LocalDate targetEndDate, LocalDate actualEndDate, Organization organization,
                   Set<ProjectMember> members, Set<ProjectRequiredSkill> requiredSkills) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.contractCode = contractCode;
        this.billingType = billingType;
        this.repositoryUrl = repositoryUrl;
        this.documentationUrl = documentationUrl;
        this.estimatedHours = estimatedHours;
        this.maxBillableHours = maxBillableHours;
        this.hourlyRate = hourlyRate;
        this.currency = currency;
        this.startDate = startDate;
        this.targetEndDate = targetEndDate;
        this.actualEndDate = actualEndDate;
        this.organization = organization;
        this.members = members;
        this.requiredSkills = requiredSkills;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    public void setPriority(ProjectPriority priority) {
        this.priority = priority;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BillingType getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDocumentationUrl() {
        return documentationUrl;
    }

    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public Integer getMaxBillableHours() {
        return maxBillableHours;
    }

    public void setMaxBillableHours(Integer maxBillableHours) {
        this.maxBillableHours = maxBillableHours;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getTargetEndDate() {
        return targetEndDate;
    }

    public void setTargetEndDate(LocalDate targetEndDate) {
        this.targetEndDate = targetEndDate;
    }

    public LocalDate getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<ProjectMember> getMembers() {
        return members;
    }

    public void setMembers(Set<ProjectMember> members) {
        this.members = members;
    }

    public Set<ProjectRequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(Set<ProjectRequiredSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
