package br.com.codesync.repository;

import br.com.codesync.model.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccessRepository extends JpaRepository<UserAccess, UUID> {
}
