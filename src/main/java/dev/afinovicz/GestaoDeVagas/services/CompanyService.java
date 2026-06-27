package dev.afinovicz.GestaoDeVagas.services;

import dev.afinovicz.GestaoDeVagas.database.model.CompanyEntity;
import dev.afinovicz.GestaoDeVagas.database.repository.CompanyRepository;
import dev.afinovicz.GestaoDeVagas.exception.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity createCompany(CompanyEntity companyEntity) {

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

                var password = passwordEncoder.encode(companyEntity.getPassword());
                companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }


}
