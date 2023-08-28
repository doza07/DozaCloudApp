package com.doza.cloud.DozaCloud.util;

import com.doza.cloud.DozaCloud.models.Completion;
import com.doza.cloud.DozaCloud.repository.CompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompletionByIdConverter implements Converter<String, Completion> {

    private CompletionRepository completionRepository;

    @Autowired
    public CompletionByIdConverter(CompletionRepository completionRepository) {
        this.completionRepository = completionRepository;
    }

    @Override
    public Completion convert(String id) {
        return completionRepository.findById(id).orElse(null);
    }
}
