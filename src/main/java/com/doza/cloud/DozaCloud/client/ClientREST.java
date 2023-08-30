package com.doza.cloud.DozaCloud.client;

import com.doza.cloud.DozaCloud.models.Completion;
import org.springframework.web.client.RestTemplate;

public class ClientREST {

    RestTemplate rest = new RestTemplate();

    public Completion getCompletionById(String completionId) {
        return rest.getForObject("http://localhost:8080/completions/{id}",
                Completion.class, completionId);
    }

    public void updateCompletion(Completion completion) {
        rest.put("http://localhost:8080/completions/{id}",
                completion, completion.getId());
    }

    public void deleteCompletion(Completion completion) {
        rest.delete("http://localhost:8080/completions/{id}",
                completion.getId());
    }

    public Completion createCompletion(Completion completion) {
        return rest.postForObject("http://localhost:8080/completions",
                completion, Completion.class);
    }
}
