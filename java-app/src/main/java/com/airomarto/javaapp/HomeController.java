package com.airomarto.javaapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                Welcome to Martins Airende's DevOps Final Project!

                Technologies Used:
                - Spring Boot
                - Docker
                - Terraform
                - Ansible
                - GitHub Actions
                - AWS
                """;
    }
}
