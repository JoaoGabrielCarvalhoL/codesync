package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ContractAddendum;
import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.AddendumStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public final class ContractAddendumBuilder {

    private ContractAddendum contractAddendum;

    private ContractAddendumBuilder() {
        this.contractAddendum = new ContractAddendum();
    }

    public static ContractAddendumBuilder builder() {
        return new ContractAddendumBuilder();
    }

    public ContractAddendumBuilder id(UUID id) {
        this.contractAddendum.setId(id);
        return this;
    }

    public ContractAddendumBuilder project(Project project) {
        this.contractAddendum.setProject(project);
        return this;
    }

    public ContractAddendumBuilder title(String title) {
        this.contractAddendum.setTitle(title);
        return this;
    }

    public ContractAddendumBuilder description(String description) {
        this.contractAddendum.setDescription(description);
        return this;
    }

    public ContractAddendumBuilder additionalHours(BigDecimal additionalHours) {
        this.contractAddendum.setAdditionalHours(additionalHours);
        return this;
    }

    public ContractAddendumBuilder additionalAmount(BigDecimal additionalAmount) {
        this.contractAddendum.setAdditionalAmount(additionalAmount);
        return this;
    }

    public ContractAddendumBuilder status(AddendumStatus addendumStatus) {
        this.contractAddendum.setStatus(addendumStatus);
        return this;
    }

    public ContractAddendumBuilder requestedBy(User requestedBy) {
        this.contractAddendum.setRequestedBy(requestedBy);
        return this;
    }

    public ContractAddendumBuilder approvedBy(User approvedBy) {
        this.contractAddendum.setApprovedBy(approvedBy);
        return this;
    }

    public ContractAddendumBuilder approvedAt(LocalDateTime approvedAt) {
        this.contractAddendum.setApprovedAt(approvedAt);
        return this;
    }

    public ContractAddendum build() {
        final ContractAddendum result = this.contractAddendum;
        this.contractAddendum = new ContractAddendum();
        return result;
    }
}
