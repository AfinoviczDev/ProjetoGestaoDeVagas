package dev.afinovicz.GestaoDeVagas.database.repository;

import dev.afinovicz.GestaoDeVagas.database.model.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
