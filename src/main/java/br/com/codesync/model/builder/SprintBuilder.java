package br.com.codesync.model.builder;

import br.com.codesync.model.entity.Project;
import br.com.codesync.model.entity.Sprint;
import br.com.codesync.model.enumerations.SprintStatus;

import java.time.LocalDate;
import java.util.UUID;

public final class SprintBuilder {

    private Sprint sprint;

    private SprintBuilder() {
        this.sprint = new Sprint();
    }

    public static SprintBuilder builder() {
        return new SprintBuilder();
    }

    public SprintBuilder id(UUID id) {
        this.sprint.setId(id);
        return this;
    }

    public SprintBuilder project(Project project) {
        this.sprint.setProject(project);
        return this;
    }

    public SprintBuilder goal(String goal) {
        this.sprint.setGoal(goal);
        return this;
    }

    public SprintBuilder startDate(LocalDate startDate) {
        this.sprint.setStartDate(startDate);
        return this;
    }

    public SprintBuilder endDate(LocalDate endData) {
        this.sprint.setEndDate(endData);
        return this;
    }

    public SprintBuilder status(SprintStatus status) {
        this.sprint.setStatus(status);
        return this;
    }

    public Sprint build() {
        final Sprint result = this.sprint;
        this.sprint = new Sprint();
        return result;
    }
}
