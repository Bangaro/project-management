package com.bangaro.projectmanagement.dao;

import com.bangaro.projectmanagement.ProjectManagementApplication;
import com.bangaro.projectmanagement.dao.ProjectRepository;
import com.bangaro.projectmanagement.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project project = new Project("New test project", "COMPLETED", "Test project description");
        projectRepository.save(project);

        assertEquals(1, projectRepository.findAll().size());
    }
}
