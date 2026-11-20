package br.com.codesync.repository;

import br.com.codesync.model.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MilestoneRepository extends JpaRepository<Milestone, UUID> {
}
