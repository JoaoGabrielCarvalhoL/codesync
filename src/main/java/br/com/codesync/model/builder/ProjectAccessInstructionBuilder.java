package br.com.codesync.model.builder;

import br.com.codesync.model.entity.ProjectAccessInstruction;
import br.com.codesync.model.entity.ProjectEnvironment;

import java.util.UUID;

public final class ProjectAccessInstructionBuilder {

    private ProjectAccessInstruction projectAccessInstruction;

    private ProjectAccessInstructionBuilder() {
        this.projectAccessInstruction = new ProjectAccessInstruction();
    }

    public static ProjectAccessInstructionBuilder create() {
        return new ProjectAccessInstructionBuilder();
    }

    public ProjectAccessInstructionBuilder id(UUID id) {
        this.projectAccessInstruction.setId(id);
        return this;
    }

    public ProjectAccessInstructionBuilder environment(ProjectEnvironment environment) {
        this.projectAccessInstruction.setEnvironment(environment);
        return this;
    }

    public ProjectAccessInstructionBuilder title(String title) {
        this.projectAccessInstruction.setTitle(title);
        return this;
    }

    public ProjectAccessInstructionBuilder instructions(String instructions) {
        this.projectAccessInstruction.setInstructions(instructions);
        return this;
    }

    public ProjectAccessInstructionBuilder externalDocUrl(String externalDocUrl) {
        this.projectAccessInstruction.setExternalDocUrl(externalDocUrl);
        return this;
    }

    public ProjectAccessInstruction build() {
        ProjectAccessInstruction result = this.projectAccessInstruction;
        this.projectAccessInstruction = new ProjectAccessInstruction();
        return result;
    }
}
