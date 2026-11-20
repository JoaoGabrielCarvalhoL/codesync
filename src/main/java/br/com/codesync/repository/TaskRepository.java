package br.com.codesync.repository;

import br.com.codesync.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> , JpaSpecificationExecutor<Task> {

    Optional<Task> findByCode(String code);

    boolean existsByCode(String code);
}
