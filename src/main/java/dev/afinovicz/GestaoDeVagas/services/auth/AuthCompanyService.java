package dev.afinovicz.GestaoDeVagas.services.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.afinovicz.GestaoDeVagas.database.repository.CompanyRepository;
import dev.afinovicz.GestaoDeVagas.dtos.AuthCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyService {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("Username/Password incorrect");
                });

        // Verificar se as senhas são iguais
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // Se não for igual -> ERRO
        if (!passwordMatches) {
            throw new AuthenticationException();
            }
            // Se for igual -> Gerar Token
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            var token = JWT.create().withIssuer("javagas")
                    .withSubject(company.getUuid().toString())
                    .sign(algorithm);
            return token;
        }
    }

