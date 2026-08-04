package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ContractAddendum;
import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.User;
import br.com.codesync.model.enumerations.AddendumStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

class ContractAddendumBuilderTest {

    @Test
    @DisplayName("Should create a contract addendum with valid values")
    void shouldCreateContractAddendumWithValidValues() {
        UUID id = UUID.randomUUID();
        LocalDateTime approvedAt = LocalDateTime.now();

        Project project = new Project();
        User requestedBy = new User();
        User approvedBy = new User();

        ContractAddendum contractAddendum = ContractAddendumBuilder.builder()
                .id(id)
                .project(project)
                .title("Scope Expansion")
                .description("Additional backend development")
                .additionalHours(BigDecimal.valueOf(40))
                .additionalAmount(BigDecimal.valueOf(8000))
                .status(AddendumStatus.APPROVED)
                .requestedBy(requestedBy)
                .approvedBy(approvedBy)
                .approvedAt(approvedAt)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(id, contractAddendum.getId()),
                () -> Assertions.assertEquals(project, contractAddendum.getProject()),
                () -> Assertions.assertEquals("Scope Expansion", contractAddendum.getTitle()),
                () -> Assertions.assertEquals("Additional backend development", contractAddendum.getDescription()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(40), contractAddendum.getAdditionalHours()),
                () -> Assertions.assertEquals(BigDecimal.valueOf(8000), contractAddendum.getAdditionalAmount()),
                () -> Assertions.assertEquals(AddendumStatus.APPROVED, contractAddendum.getStatus()),
                () -> Assertions.assertEquals(requestedBy, contractAddendum.getRequestedBy()),
                () -> Assertions.assertEquals(approvedBy, contractAddendum.getApprovedBy()),
                () -> Assertions.assertEquals(approvedAt, contractAddendum.getApprovedAt())
        );
    }

    @Test
    @DisplayName("Should create an empty contract addendum when no values are provided")
    void shouldCreateEmptyContractAddendumWhenNoValuesAreProvided() {
        ContractAddendum contractAddendum = ContractAddendumBuilder.builder().build();

        Assertions.assertAll(
                () -> Assertions.assertNull(contractAddendum.getId()),
                () -> Assertions.assertNull(contractAddendum.getProject()),
                () -> Assertions.assertNull(contractAddendum.getTitle()),
                () -> Assertions.assertNull(contractAddendum.getDescription()),
                () -> Assertions.assertNull(contractAddendum.getAdditionalHours()),
                () -> Assertions.assertNull(contractAddendum.getAdditionalAmount()),
                () -> Assertions.assertNull(contractAddendum.getStatus()),
                () -> Assertions.assertNull(contractAddendum.getRequestedBy()),
                () -> Assertions.assertNull(contractAddendum.getApprovedBy()),
                () -> Assertions.assertNull(contractAddendum.getApprovedAt())
        );
    }

}