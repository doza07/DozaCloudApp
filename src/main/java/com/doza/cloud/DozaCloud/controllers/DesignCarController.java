package com.doza.cloud.DozaCloud.controllers;

import com.doza.cloud.DozaCloud.models.Car;
import com.doza.cloud.DozaCloud.models.Completion;
import com.doza.cloud.DozaCloud.repository.CompletionRepository;
import com.doza.cloud.DozaCloud.models.CarOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("carOrder")
public class DesignCarController {

    private final CompletionRepository completionRepository;

    @Autowired
    public DesignCarController(CompletionRepository completionRepository) {
        this.completionRepository = completionRepository;
    }

        @ModelAttribute
    public void addIngredientsToModel(Model model) {
            Iterable<Completion> completions = completionRepository.findAll();
            Completion.Type[] types = Completion.Type.values();
            for (Completion.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(),
                        filterByType((List<Completion>) completions, type));
            } }

    @ModelAttribute(name = "carOrder")
    public CarOrder order() {
        return new CarOrder(); }

    @ModelAttribute(name = "car")
    public Car car() {
        return new Car(); }

    @GetMapping
    public String showDesignForm() {
        return "design"; }
    private Iterable<Completion> filterByType(List<Completion> completions, Completion.Type type) {
        return completions.stream()
                .filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    public String processCar(@Valid Car car, Errors errors,
                             @ModelAttribute CarOrder carOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        carOrder.addCar(car);
        log.info("Processing car: {}", car);
        return "redirect:/orders/current"; }

}
