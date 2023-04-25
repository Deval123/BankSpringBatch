package org.id.bankspringbatch;



import org.springframework.batch.core.*;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class jonRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private BankTransactionItemAnalyticsProcessor analyticsProcessor;

    //http://localhost:8080/h2-console POUR LA BD
    @GetMapping("/startJob") //http://localhost:8080/startJob
    public BatchStatus load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        //Comment lancer un job
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameterMap);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while (jobExecution.isRunning()){
            System.out.println("..................");
        }
        return jobExecution.getStatus();
    }


    @GetMapping("/analytics")
    public Map<String, Double>  analytics() {
        Map<String, Double> map = new HashMap<>();
        map.put("totalDebit", analyticsProcessor.getTotalDebit());
        map.put("totalCredit", analyticsProcessor.getTotalCredit());
        return map;
    }
}
