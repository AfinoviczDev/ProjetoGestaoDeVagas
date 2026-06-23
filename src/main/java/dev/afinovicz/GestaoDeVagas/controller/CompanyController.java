package dev.afinovicz.GestaoDeVagas.controller;

import dev.afinovicz.GestaoDeVagas.database.model.CompanyEntity;
import dev.afinovicz.GestaoDeVagas.exception.UserFoundException;
import dev.afinovicz.GestaoDeVagas.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@RequestBody CompanyEntity companyEntity) {
        try {
            var result = companyService.createCompany(companyEntity);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
