/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arun G K
 */
@RestController
@RequestMapping("question")
public class Sample1Controller {
    
    private final FeignInterface feignInterface;
    
     public Sample1Controller(FeignInterface feignInterface) {
        this.feignInterface = feignInterface;
    }

    @GetMapping("allQuestionFromService2")
    public String getQuestions() {
        return feignInterface.getQuestions();
    }

}
