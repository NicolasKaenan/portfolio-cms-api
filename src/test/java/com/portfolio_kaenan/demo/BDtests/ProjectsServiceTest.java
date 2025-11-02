package com.portfolio_kaenan.demo.BDtests;

import com.portfolio_kaenan.demo.entity.PostTag;
import com.portfolio_kaenan.demo.entity.Projects;
import com.portfolio_kaenan.demo.repository.ProjectsRepository;
import com.portfolio_kaenan.demo.service.ProjectsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectsServiceTest {

    @Mock
    private ProjectsRepository projectsRepository;

    @InjectMocks
    private ProjectsService projectsService;

    private Projects projects;

    @BeforeEach
    void setUp() {
        projects = new Projects();
        projects.setId_projects(1L);
        projects.setTitle("Novo Projeto Teste");
    }

    @Test
    void save_shouldReturnSavedProject_whenSuccessful() {
        when(projectsRepository.save(projects)).thenReturn(projects);
        Projects savedProject = projectsService.save(projects);

        assertNotNull(savedProject, "O projeto salvo não deveria ser nulo.");
        assertEquals("Novo Projeto Teste", savedProject.getTitle(), "Os títulos devem ser idênticos.");

        verify(projectsRepository, times(1)).save(projects);
    }

    @Test
    void findById_shouldReturnEmptyOptional_whenIdDoesNotExist() {
        Long nonExistingId = 99L;

        when(projectsRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        Optional<Projects> result = projectsService.findById(nonExistingId);

        assertTrue(result.isEmpty(), "O resultado deve ser um Optional vazio.");
        verify(projectsRepository, times(1)).findById(nonExistingId);
    }

    @Test
    void findTagsByProjectId_shouldReturnTagsList_whenSuccessful() {
        Long existingId = 1L;

        PostTag postTag1 = new PostTag();
        postTag1.setValue("java");

        PostTag postTag2 = new PostTag();
        postTag2.setValue("spring boot");

        List<PostTag> mockPostTags = Arrays.asList(postTag1, postTag2);
        projects.setPostTags(mockPostTags);

        when(projectsRepository.findById(existingId)).thenReturn(Optional.of(projects));

        Optional<List<PostTag>> result = projectsService.findTagsByProjectId(existingId);

        assertTrue(result.isPresent(), "O resultado deveria conter uma lista de tags.");
    }
}