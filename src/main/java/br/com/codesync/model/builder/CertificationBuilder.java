package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Certification;
import br.com.codesync.model.entity.ProfessionalProfile;

import java.time.LocalDate;
import java.util.UUID;

public final class CertificationBuilder {

    private Certification certification;

    private CertificationBuilder() {
        this.certification = new Certification();
    }

    public static CertificationBuilder builder() {
        return new CertificationBuilder();
    }

    public CertificationBuilder id(UUID id) {
        this.certification.setId(id);
        return this;
    }

    public CertificationBuilder name(String name) {
        this.certification.setName(name);
        return this;
    }

    public CertificationBuilder issuer(String issuer) {
        this.certification.setIssuer(issuer);
        return this;
    }

    public CertificationBuilder certificateUrl(String certificateUrl) {
        this.certification.setCertificateUrl(certificateUrl);
        return this;
    }

    public CertificationBuilder credentialId(String credentialId) {
        this.certification.setCredentialId(credentialId);
        return this;
    }

    public CertificationBuilder obtainedIn(LocalDate obtainedIn) {
        this.certification.setObtainedIn(obtainedIn);
        return this;
    }

    public CertificationBuilder validUntil(LocalDate validUntil) {
        this.certification.setValidUntil(validUntil);
        return this;
    }

    public CertificationBuilder professionalProfile(ProfessionalProfile professionalProfile) {
        this.certification.setProfessionalProfile(professionalProfile);
        return this;
    }

    public Certification build() {
        Certification result = this.certification;
        this.certification = new Certification();
        return result;
    }
}
