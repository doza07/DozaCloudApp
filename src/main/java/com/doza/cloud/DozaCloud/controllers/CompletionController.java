package com.doza.cloud.DozaCloud.controllers;


import com.doza.cloud.DozaCloud.models.Completion;
import com.doza.cloud.DozaCloud.repository.CompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/completions", produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class CompletionController {

    private CompletionRepository completionRepository;

    @Autowired
    public CompletionController(CompletionRepository completionRepository) {
        this.completionRepository = completionRepository;
    }

    @GetMapping
    public Iterable<Completion> allCompletions() {
        return completionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Completion saveCompletion(@RequestBody Completion completion) {
        return completionRepository.save(completion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompletion(@PathVariable("id") String completionId) {
        completionRepository.deleteById(completionId);
    }

}
