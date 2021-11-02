package com.bangaro.projectmanagement.controllers;

import com.bangaro.projectmanagement.dao.EmployeeRepository;
import com.bangaro.projectmanagement.dao.ProjectRepository;
import com.bangaro.projectmanagement.entities.Employee;
import com.bangaro.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        List<Project> projects   = projectRepository.findAll();

        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        return "main/home";
    }



}
