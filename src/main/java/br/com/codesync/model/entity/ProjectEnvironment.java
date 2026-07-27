package br.com.codesync.model.entity;

import br.com.codesync.model.enumerations.EnvironmentType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_project_environments", indexes = {
        @Index(name = "idx_project_env_project", columnList = "project_id")
})
public class ProjectEnvironment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "environment_type", nullable = false, length = 30)
    private EnvironmentType environmentType;

    @Column(length = 255)
    private String url;

    @Column(nullable = false)
    private boolean active = true;

    @OneToMany(mappedBy = "environment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectAccessInstruction> instructions = new ArrayList<>();

    public ProjectEnvironment() {}

    public ProjectEnvironment(Project project, String name, EnvironmentType environmentType, String url, boolean active,
                              List<ProjectAccessInstruction> instructions) {
        this.project = project;
        this.name = name;
        this.environmentType = environmentType;
        this.url = url;
        this.active = active;
        this.instructions = instructions;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnvironmentType getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(EnvironmentType environmentType) {
        this.environmentType = environmentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ProjectAccessInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<ProjectAccessInstruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEnvironment that = (ProjectEnvironment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
