package com.doza.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCloudController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
