package dev.afinovicz.GestaoDeVagas.controller;

import dev.afinovicz.GestaoDeVagas.database.model.CandidateEntity;
import dev.afinovicz.GestaoDeVagas.database.repository.CandidateRepository;
import dev.afinovicz.GestaoDeVagas.exception.UserFoundException;
import dev.afinovicz.GestaoDeVagas.useCases.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = candidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
