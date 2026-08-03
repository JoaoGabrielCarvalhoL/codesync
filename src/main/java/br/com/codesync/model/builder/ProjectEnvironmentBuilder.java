package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.ProjectAccessInstruction;
import br.com.codesync.model.entity.ProjectEnvironment;
import br.com.codesync.model.enumerations.EnvironmentType;

import java.util.List;
import java.util.UUID;

public final class ProjectEnvironmentBuilder {

    private ProjectEnvironment projectEnvironment;

    private ProjectEnvironmentBuilder() {
        this.projectEnvironment = new ProjectEnvironment();
    }

    public static ProjectEnvironmentBuilder builder() {
        return new ProjectEnvironmentBuilder();
    }

    public ProjectEnvironmentBuilder id(UUID id) {
        this.projectEnvironment.setId(id);
        return this;
    }

    public ProjectEnvironmentBuilder project(Project project) {
        this.projectEnvironment.setProject(project);
        return this;
    }

    public ProjectEnvironmentBuilder name(String name) {
        this.projectEnvironment.setName(name);
        return this;
    }

    public ProjectEnvironmentBuilder environmentType(EnvironmentType environmentType) {
        this.projectEnvironment.setEnvironmentType(environmentType);
        return this;
    }

    public ProjectEnvironmentBuilder url(String url) {
        this.projectEnvironment.setUrl(url);
        return this;
    }

    public ProjectEnvironmentBuilder active(boolean active) {
        this.projectEnvironment.setActive(active);
        return this;
    }

    public ProjectEnvironmentBuilder instructions(List<ProjectAccessInstruction> instructions) {
        this.projectEnvironment.setInstructions(instructions);
        return this;
    }

    public ProjectEnvironment build() {
        ProjectEnvironment result =  this.projectEnvironment;
        this.projectEnvironment = new ProjectEnvironment();
        return result;
    }
}
