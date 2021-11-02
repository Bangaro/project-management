package com.bangaro.projectmanagement.controllers;

import com.bangaro.projectmanagement.dao.EmployeeRepository;
import com.bangaro.projectmanagement.dao.ProjectRepository;
import com.bangaro.projectmanagement.entities.Employee;
import com.bangaro.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();

        List<Employee> employees = empRepo.findAll();
        model.addAttribute("allEmployees", employees);

        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees, Model model) {

        proRepo.save(project);

        return "redirect:/projects";
    }

}
