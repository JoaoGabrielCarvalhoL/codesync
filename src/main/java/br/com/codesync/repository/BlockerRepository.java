package br.com.codesync.repository;

import br.com.codesync.model.entity.Blocker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlockerRepository extends JpaRepository<Blocker, UUID> {
}
