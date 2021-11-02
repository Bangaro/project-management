package com.bangaro.projectmanagement;

import com.bangaro.projectmanagement.dao.EmployeeRepository;
import com.bangaro.projectmanagement.dao.ProjectRepository;
import com.bangaro.projectmanagement.entities.Employee;
import com.bangaro.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);
    }


//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//
//            Employee employee1 = new Employee("Esteban", "García", "ejgp@gmail.com");
//            Employee employee2 = new Employee("Andrea", "Lopez", "andrea1234@gmail.com");
//            Employee employee3 = new Employee("Luis", "Martinez", "mluis@gmail.com");
//            Employee employee4 = new Employee("Marcos", "Barrantes", "mbv6712@gmail.com");
//            Employee employee5 = new Employee("Maria", "Brenes", "brenesmaria@gmail.com");
//            Employee employee6 = new Employee("Carlos", "Fallas", "cafallas@gmail.com");
//
//
//            Project project1 = new Project("Issue Tracker", "INPROGRESS", "This is the first project");
//            Project project2 = new Project("Deployment Solutions", "NOTSTARTED", "This is the second project");
//            Project project3 = new Project("Docker Pusher", "INPROGRESS", "This is the third project");
//            Project project4 = new Project("Meta Landing Web", "COMPLETED", "This is the fourth project");
//            Project project5 = new Project("New Employee Budget", "NOTSTARTED", "This is the fifth project");
//            Project project6 = new Project("Office reconstruction", "INPROGRESS", "This is the sixth project");
//
//            project1.addEmployee(employee1);
//            project1.addEmployee(employee2);
//            project2.addEmployee(employee3);
//            project3.addEmployee(employee1);
//            project4.addEmployee(employee1);
//            project4.addEmployee(employee3);
//
//
//            employee1.setProjects(Arrays.asList(project1, project2, project3));
//            employee2.setProjects(Arrays.asList(project1));
//            employee3.setProjects(Arrays.asList(project2, project4));
//
//            employeeRepository.save(employee1);
//            employeeRepository.save(employee2);
//            employeeRepository.save(employee3);
//            employeeRepository.save(employee4);
//            employeeRepository.save(employee5);
//            employeeRepository.save(employee6);
//
//            projectRepository.save(project1);
//            projectRepository.save(project2);
//            projectRepository.save(project3);
//            projectRepository.save(project4);
//            projectRepository.save(project5);
//            projectRepository.save(project6);
//
//        };
//    }
}
