package com.blz.springbatch.batch;

import com.blz.springbatch.model.CandidateModel;
import com.blz.springbatch.repository.CandidateRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<CandidateModel> {

    private CandidateRepository candidateRepository;

    @Autowired
    public DBWriter (CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void write(List<? extends CandidateModel> candidateModels) throws Exception {
        System.out.println("Data Saved for Candidates: " + candidateModels);
        candidateRepository.saveAll(candidateModels);
    }
}
