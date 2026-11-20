package br.com.codesync.repository;

import br.com.codesync.model.entity.ContractAddendum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractAddendumRepository extends JpaRepository<ContractAddendum, UUID> {
}
