package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.ProfessionalStatus;
import br.com.codesync.model.enumerations.SeniorityLevel;
import br.com.codesync.model.enumerations.WorkMode;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_professional_profiles")
public class ProfessionalProfile extends Auditable {

    @Id
    private UUID id;

    @Column(nullable = false, length = 100)
    private String jobTitle;

    @Column(length = 100)
    private String graduation;

    @Enumerated(EnumType.STRING)
    @Column(name = "seniority_level", nullable = false, length = 20)
    private SeniorityLevel seniorityLevel;

    @Column(length = 500)
    private String professionalSummary;

    @Column(name = "years_experience")
    private Integer yearsOfExperience;

    @OneToMany(mappedBy = "professionalProfile", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Certification> certifications = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProfessionalStatus professionalStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkMode workMode;

    @Column(name = "weekly_capacity")
    private Integer capacityHoursPerWeek;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "professionalProfile", orphanRemoval = true)
    private Set<ProfessionalSkill> skills = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "professionalProfile", orphanRemoval = true)
    private Set<ProfessionalLanguage> professionalLanguages = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ProfessionalProfile() {}

    public ProfessionalProfile(String jobTitle, String graduation, SeniorityLevel seniorityLevel,
                               String professionalSummary, Integer yearsOfExperience, Set<Certification> certifications,
                               ProfessionalStatus professionalStatus, WorkMode workMode, Integer capacityHoursPerWeek,
                               Set<ProfessionalSkill> skills, Set<ProfessionalLanguage> professionalLanguages, User user) {
        this.jobTitle = jobTitle;
        this.graduation = graduation;
        this.seniorityLevel = seniorityLevel;
        this.professionalSummary = professionalSummary;
        this.yearsOfExperience = yearsOfExperience;
        this.certifications = certifications;
        this.professionalStatus = professionalStatus;
        this.workMode = workMode;
        this.capacityHoursPerWeek = capacityHoursPerWeek;
        this.skills = skills;
        this.professionalLanguages = professionalLanguages;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public SeniorityLevel getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(SeniorityLevel seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public ProfessionalStatus getProfessionalStatus() {
        return professionalStatus;
    }

    public void setProfessionalStatus(ProfessionalStatus professionalStatus) {
        this.professionalStatus = professionalStatus;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public Integer getCapacityHoursPerWeek() {
        return capacityHoursPerWeek;
    }

    public void setCapacityHoursPerWeek(Integer capacityHoursPerWeek) {
        this.capacityHoursPerWeek = capacityHoursPerWeek;
    }

    public Set<ProfessionalSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<ProfessionalSkill> skills) {
        this.skills = skills;
    }

    public Set<ProfessionalLanguage> getProfessionalLanguages() {
        return professionalLanguages;
    }

    public void setProfessionalLanguages(Set<ProfessionalLanguage> professionalLanguages) {
        this.professionalLanguages = professionalLanguages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ProfessionalProfile that = (ProfessionalProfile) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
