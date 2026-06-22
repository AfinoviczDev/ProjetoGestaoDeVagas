package dev.afinovicz.GestaoDeVagas.services;

import dev.afinovicz.GestaoDeVagas.database.model.CandidateEntity;
import dev.afinovicz.GestaoDeVagas.database.repository.CandidateRepository;
import dev.afinovicz.GestaoDeVagas.exception.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }

}
