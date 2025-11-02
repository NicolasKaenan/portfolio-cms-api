package com.portfolio_kaenan.demo.service;
import com.portfolio_kaenan.demo.entity.Projects;
import com.portfolio_kaenan.demo.entity.PostTag;
import com.portfolio_kaenan.demo.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public List<Projects> findAll() {
        return projectsRepository.findAll();
    }

    public Optional<Projects> findById(Long id) {
        return projectsRepository.findById(id);
    }

    public Optional<List<PostTag>> findTagsByProjectId(Long id) {
        Optional<Projects> projectOptional = projectsRepository.findById(id);

        return projectOptional.map(Projects::getPostTags);
    }

    public Projects save(Projects projects) {
        return projectsRepository.save(projects);
    }

    public void deleteById(Long id) {

        if (!projectsRepository.existsById(id)) {
            throw new RuntimeException("Projeto com ID " + id + " não encontrado.");
        }

        projectsRepository.deleteById(id);
    }
}
