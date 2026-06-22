package dev.afinovicz.GestaoDeVagas.database.repository;

import dev.afinovicz.GestaoDeVagas.database.model.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
