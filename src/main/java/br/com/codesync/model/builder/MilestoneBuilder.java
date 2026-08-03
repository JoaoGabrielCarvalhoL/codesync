package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Milestone;
import br.com.codesync.model.entity.Project;
import br.com.codesync.model.enumerations.MilestoneStatus;

import java.time.LocalDate;
import java.util.UUID;

public final class MilestoneBuilder {

    private Milestone milestone;

    private MilestoneBuilder() {
        this.milestone = new Milestone();
    }

    public static MilestoneBuilder builder() {
        return new MilestoneBuilder();
    }

    public MilestoneBuilder id(UUID id) {
        this.milestone.setId(id);
        return this;
    }

    public MilestoneBuilder project(Project project) {
        this.milestone.setProject(project);
        return this;
    }

    public MilestoneBuilder title(String title) {
        this.milestone.setTitle(title);
        return this;
    }

    public MilestoneBuilder description(String description) {
        this.milestone.setDescription(description);
        return this;
    }

    public MilestoneBuilder dueDate(LocalDate dueDate) {
        this.milestone.setDueDate(dueDate);
        return this;
    }

    public MilestoneBuilder status(MilestoneStatus status) {
        this.milestone.setStatus(status);
        return this;
    }

    public Milestone build() {
        final Milestone result = this.milestone;
        this.milestone = new Milestone();
        return result;
    }

}
