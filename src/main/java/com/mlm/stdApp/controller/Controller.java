package com.mlm.stdApp.controller;

import com.mlm.stdApp.model.StudentRepository;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("studentApp")
public class Controller {
    @Autowired
    private StudentRepository repo;
    @GetMapping(path = "home")
    public ModelAndView getAllStudents(){
        ModelAndView modelAndView=new ModelAndView("home-page");

        return modelAndView;
    }

}
