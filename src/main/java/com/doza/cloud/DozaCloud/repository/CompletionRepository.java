package com.doza.cloud.DozaCloud.repository;

import com.doza.cloud.DozaCloud.models.Completion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompletionRepository extends CrudRepository<Completion, String> {
}
