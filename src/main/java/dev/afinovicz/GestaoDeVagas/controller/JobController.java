package dev.afinovicz.GestaoDeVagas.controller;

import dev.afinovicz.GestaoDeVagas.database.model.JobEntity;
import dev.afinovicz.GestaoDeVagas.services.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public JobEntity createJob(@Valid @RequestBody JobEntity jobEntity) {
        return this.jobService.createJob(jobEntity);
    }

}
