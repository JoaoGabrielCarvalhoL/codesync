package br.com.codesync.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_certifications")
public class Certification extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String issuer;

    @Column(length = 255)
    private String certificateUrl;

    @Column(name = "credential_id", length = 100)
    private String credentialId;

    private LocalDate obtainedIn;

    private LocalDate validUntil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ProfessionalProfile professionalProfile;

    public Certification() {}

    public Certification(String name, String issuer, String certificateUrl, String credentialId,
                         LocalDate obtainedIn, LocalDate validUntil, ProfessionalProfile professionalProfile) {
        this.name = name;
        this.issuer = issuer;
        this.certificateUrl = certificateUrl;
        this.credentialId = credentialId;
        this.obtainedIn = obtainedIn;
        this.validUntil = validUntil;
        this.professionalProfile = professionalProfile;
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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public String getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(String credentialId) {
        this.credentialId = credentialId;
    }

    public LocalDate getObtainedIn() {
        return obtainedIn;
    }

    public void setObtainedIn(LocalDate obtainedIn) {
        this.obtainedIn = obtainedIn;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public ProfessionalProfile getProfessionalProfile() {
        return professionalProfile;
    }

    public void setProfessionalProfile(ProfessionalProfile professionalProfile) {
        this.professionalProfile = professionalProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Certification that = (Certification) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
