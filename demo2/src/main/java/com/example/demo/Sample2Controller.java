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
@RequestMapping("question2")
public class Sample2Controller {

    @GetMapping("allQuestion2")
    public String getQuestions() {
        return "hai from service 2 demo by arun gk new build";
    }

}
