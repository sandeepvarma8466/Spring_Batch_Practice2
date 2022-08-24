package com.blz.springbatch.batch;

import com.blz.springbatch.model.CandidateModel;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<CandidateModel, CandidateModel> {

    private static final Map<String, String> DEGREE_NAMES = new HashMap<>();

    public Processor() {
        DEGREE_NAMES.put("1","B.Tech");
        DEGREE_NAMES.put("2","B.Sc");
        DEGREE_NAMES.put("3","B.com");
    }
    @Override
    public CandidateModel process(CandidateModel candidateModel) throws Exception {
        String degree = candidateModel.getDegree();
        String dept = DEGREE_NAMES.get(degree);

        candidateModel.setDegree(dept);
        return candidateModel;
    }
}
