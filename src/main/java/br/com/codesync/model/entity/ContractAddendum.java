package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.AddendumStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_contract_addendums")
public class ContractAddendum extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Project project;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(name = "additional_hours", precision = 10, scale = 2)
    private BigDecimal additionalHours;

    @Column(name = "additional_amount", precision = 12, scale = 2)
    private BigDecimal additionalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AddendumStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private User requestedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User approvedBy;

    private LocalDateTime approvedAt;

    public ContractAddendum() {}

    public ContractAddendum(Project project, String title, String description, BigDecimal additionalHours,
                            BigDecimal additionalAmount, AddendumStatus status, User requestedBy, User approvedBy,
                            LocalDateTime approvedAt) {
        this.project = project;
        this.title = title;
        this.description = description;
        this.additionalHours = additionalHours;
        this.additionalAmount = additionalAmount;
        this.status = status;
        this.requestedBy = requestedBy;
        this.approvedBy = approvedBy;
        this.approvedAt = approvedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAdditionalHours() {
        return additionalHours;
    }

    public void setAdditionalHours(BigDecimal additionalHours) {
        this.additionalHours = additionalHours;
    }

    public BigDecimal getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(BigDecimal additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    public AddendumStatus getStatus() {
        return status;
    }

    public void setStatus(AddendumStatus status) {
        this.status = status;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ContractAddendum that = (ContractAddendum) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
