package br.com.codesync.repository;

import br.com.codesync.model.entity.AccessRevocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccessRevocationRepository extends JpaRepository<AccessRevocation, UUID> {
}
