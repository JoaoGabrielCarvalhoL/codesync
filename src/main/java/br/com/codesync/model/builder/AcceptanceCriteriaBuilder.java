package br.com.codesync.model.builder;

import br.com.codesync.model.entity.AcceptanceCriteria;
import br.com.codesync.model.entity.Task;

import java.util.UUID;

public class AcceptanceCriteriaBuilder {

    private AcceptanceCriteria acceptanceCriteria;

    private AcceptanceCriteriaBuilder() {
        this.acceptanceCriteria = new AcceptanceCriteria();
    }

    public static AcceptanceCriteriaBuilder builder() {
        return new AcceptanceCriteriaBuilder();
    }

    public AcceptanceCriteriaBuilder id(UUID id) {
        this.acceptanceCriteria.setId(id);
        return this;
    }

    public AcceptanceCriteriaBuilder task(Task task) {
        this.acceptanceCriteria.setTask(task);
        return this;
    }

    public AcceptanceCriteriaBuilder description(String description) {
        this.acceptanceCriteria.setDescription(description);
        return this;
    }

    public AcceptanceCriteriaBuilder notes(String notes) {
        this.acceptanceCriteria.setNotes(notes);
        return this;
    }

    public AcceptanceCriteria build() {
        AcceptanceCriteria result = this.acceptanceCriteria;
        this.acceptanceCriteria = new AcceptanceCriteria();
        return result;
    }
}
