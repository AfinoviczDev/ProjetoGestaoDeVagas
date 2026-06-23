package dev.afinovicz.GestaoDeVagas.services;

import dev.afinovicz.GestaoDeVagas.database.model.JobEntity;
import dev.afinovicz.GestaoDeVagas.database.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity createJob(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }

}
