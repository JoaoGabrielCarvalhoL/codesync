package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.LanguageProficiency;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_profile_language")
public class ProfessionalLanguage extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "proficiency_level", nullable = false, length = 30)
    private LanguageProficiency proficiencyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private ProfessionalProfile professionalProfile;

    public ProfessionalLanguage() {}

    public ProfessionalLanguage(String name, LanguageProficiency proficiencyLevel,
                                ProfessionalProfile professionalProfile) {
        this.name = name;
        this.proficiencyLevel = proficiencyLevel;
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

    public LanguageProficiency getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(LanguageProficiency proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
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

        ProfessionalLanguage that = (ProfessionalLanguage) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
