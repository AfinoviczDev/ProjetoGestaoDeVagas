package dev.afinovicz.GestaoDeVagas.database.repository;

import dev.afinovicz.GestaoDeVagas.database.model.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

}
