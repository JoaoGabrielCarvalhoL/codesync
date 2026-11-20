package br.com.codesync.repository;

import br.com.codesync.model.entity.AcceptanceCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcceptanceCriteriaRepository extends JpaRepository<AcceptanceCriteria, UUID> {
}
