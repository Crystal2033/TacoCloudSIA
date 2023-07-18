package com.crystal2033.tacocloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 08/07/2023
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
