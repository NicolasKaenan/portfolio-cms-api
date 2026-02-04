package com.portfolio_kaenan.demo.controller;

import com.portfolio_kaenan.demo.entity.PostTag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.portfolio_kaenan.demo.entity.Projects;
import com.portfolio_kaenan.demo.service.ProjectsService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@CrossOrigin(
        originPatterns = {
                "http://localhost:*",
                "https://*.kaenan.dev"
        }
)

public class ProjectsController {

    private final ProjectsService projectsService;

    @GetMapping
    public ResponseEntity<List<Projects>> getAll() {
        return ResponseEntity.ok(projectsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> getById(@PathVariable Long id) {
        Optional<Projects> project = projectsService.findById(id);

        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/post_tags")
    public ResponseEntity<List<PostTag>> getTagsById(@PathVariable Long id) {

        Optional<List<PostTag>> tags = projectsService.findTagsByProjectId(id);

        if (tags.isPresent() && !tags.get().isEmpty()) {
            return ResponseEntity.ok(tags.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Projects> save(@RequestBody Projects projects) {
        Projects savedProject = projectsService.save(projects);

        return ResponseEntity.status(201).body(savedProject);
    }

    @PutMapping
    public ResponseEntity<Projects> update(@RequestBody Projects projects) {
        Projects updateProject = projectsService.save(projects);

        return  ResponseEntity.ok(updateProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectsService.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
