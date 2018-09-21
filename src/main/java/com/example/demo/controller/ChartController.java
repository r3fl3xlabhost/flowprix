package com.example.demo.controller;


import com.example.demo.service.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {

    @Autowired
    Factory factory;

    @GetMapping("/produit")
    public String getProduit() {
        return factory.createService();
    }

}
