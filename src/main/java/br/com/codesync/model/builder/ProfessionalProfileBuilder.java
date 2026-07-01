package br.com.codesync.model.builder;

import br.com.codesync.model.entity.*;
import br.com.codesync.model.enumerations.ProfessionalStatus;
import br.com.codesync.model.enumerations.SeniorityLevel;
import br.com.codesync.model.enumerations.WorkMode;

import java.util.Set;
import java.util.UUID;

public final class ProfessionalProfileBuilder {

    private final ProfessionalProfile professionalProfile;

    private ProfessionalProfileBuilder() {
        this.professionalProfile = new ProfessionalProfile();
    }

    public static ProfessionalProfileBuilder builder() {
        return new ProfessionalProfileBuilder();
    }

    public ProfessionalProfileBuilder id(UUID id) {
        this.professionalProfile.setId(id);
        return this;
    }

    public ProfessionalProfileBuilder jobTitle(String jobTitle) {
        this.professionalProfile.setJobTitle(jobTitle);
        return this;
    }

    public ProfessionalProfileBuilder graduation(String graduation) {
        this.professionalProfile.setGraduation(graduation);
        return this;
    }

    public ProfessionalProfileBuilder seniorityLevel(SeniorityLevel seniorityLevel) {
        this.professionalProfile.setSeniorityLevel(seniorityLevel);
        return this;
    }

    public ProfessionalProfileBuilder professionalSummary(String professionalSummary) {
        this.professionalProfile.setProfessionalSummary(professionalSummary);
        return this;
    }

    public ProfessionalProfileBuilder yearsOfExperience(Integer yearsOfExperience) {
        this.professionalProfile.setYearsOfExperience(yearsOfExperience);
        return this;
    }

    public ProfessionalProfileBuilder certifications(Set<Certification> certifications) {
        this.professionalProfile.setCertifications(certifications);
        return this;
    }

    public ProfessionalProfileBuilder professionalStatus(ProfessionalStatus professionalStatus) {
        this.professionalProfile.setProfessionalStatus(professionalStatus);
        return this;
    }

    public ProfessionalProfileBuilder workMode(WorkMode workMode) {
        this.professionalProfile.setWorkMode(workMode);
        return this;
    }

    public ProfessionalProfileBuilder capacityHoursPerWeek(Integer capacityHoursPerWeek) {
        this.professionalProfile.setCapacityHoursPerWeek(capacityHoursPerWeek);
        return this;
    }

    public ProfessionalProfileBuilder skills(Set<ProfessionalSkill> skills) {
        this.professionalProfile.setProfessionalSkills(skills);
        return this;
    }

    public ProfessionalProfileBuilder professionalLanguages(Set<ProfessionalLanguage> professionalLanguages) {
        this.professionalProfile.setProfessionalLanguages(professionalLanguages);
        return this;
    }

    public ProfessionalProfileBuilder user(User user) {
        this.professionalProfile.setUser(user);
        return this;
    }

    public ProfessionalProfile build() {
        return this.professionalProfile;
    }
}
