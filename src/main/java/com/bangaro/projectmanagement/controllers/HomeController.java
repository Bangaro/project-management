package com.bangaro.projectmanagement.controllers;

import com.bangaro.projectmanagement.dao.EmployeeRepository;
import com.bangaro.projectmanagement.dao.ProjectRepository;
import com.bangaro.projectmanagement.dto.ChartData;
import com.bangaro.projectmanagement.dto.EmployeeProject;
import com.bangaro.projectmanagement.entities.Employee;
import com.bangaro.projectmanagement.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectsList", projects);

        List<ChartData> projectData = projectRepository.getProjectStatus();

        //lets convert the projectData to json
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCount", jsonString);

        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);

        return "main/home";
    }


}
