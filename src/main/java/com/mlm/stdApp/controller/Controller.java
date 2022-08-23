package com.mlm.stdApp.controller;

import com.mlm.stdApp.model.Student;
import com.mlm.stdApp.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("studentApp")
public class Controller {
    @Autowired
    private StudentRepository repo;

    @GetMapping(path = "home")
    public ModelAndView getAllStudents() {
        ModelAndView modelAndView = new ModelAndView("home-page");
        List<Student> studentList = repo.findAll();
        modelAndView.addObject("studentList", studentList);

        return modelAndView;
    }

    @GetMapping(path = "add")
    public ModelAndView addStudent() {
        ModelAndView modelAndView = new ModelAndView("student-add");
        Student student = new Student();

        modelAndView.addObject("newStudent", student);
        return modelAndView;
    }

    @PostMapping(path = "add")
    public String studentSubmit(@ModelAttribute(name = "newStudent") @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student-add";
        }
        repo.save(student);
        return "redirect:/studentApp/home";

    }

    @GetMapping(path = "/{id}")
    public ModelAndView getStudentPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("student-view");
        Student student = repo.findById((long) Math.toIntExact(id)).get();
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteRecipe(@RequestParam(name = "id") Long id) {
        repo.deleteById(id);
        return "redirect:/studentApp/home";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView getEditPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-student");
        Student student = repo.findById((long) Math.toIntExact(id)).get();
        modelAndView.addObject("student", student);
        return modelAndView;

    }

    @PostMapping(path = "/{id}/edit")
    public String editStudent(@ModelAttribute(name = "student") @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-student";
        }
        repo.save(student);
        return "redirect:/studentApp/{id}";
    }
}
