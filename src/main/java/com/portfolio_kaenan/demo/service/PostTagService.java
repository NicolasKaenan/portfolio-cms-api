package com.portfolio_kaenan.demo.service;

import com.portfolio_kaenan.demo.entity.PostTag;
import com.portfolio_kaenan.demo.entity.Projects;
import com.portfolio_kaenan.demo.repository.PostTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostTagService {
    private final PostTagRepository postTagRepository;
    private final ProjectsService projectsService;

    public PostTag getById(Long id) {
        return postTagRepository.findById(id).orElse(null);
    }

    public List<PostTag> getByProjectId(Long projectId) {
        return postTagRepository.findByProjectId(projectId);
    }

    public PostTag save(PostTag postTag) {
        return postTagRepository.save(postTag);
    }

    public PostTag addTagToProject(Long projectId, String tagValue) {
        Projects project = projectsService.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + projectId));

        if (postTagRepository.findByProjectAndValue(project, tagValue).isPresent()) {
            throw new RuntimeException("A tag '" + tagValue + "' já existe para este projeto.");
        }

        PostTag newPostTag = new PostTag();
        newPostTag.setProject(project);
        newPostTag.setValue(tagValue);

        return postTagRepository.save(newPostTag);
    }

    public void deleteTagFromProject(Long projectId, String tagValue) {
        Projects project = projectsService.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + projectId));
        PostTag postTag = postTagRepository.findByProjectAndValue(project, tagValue)
                .orElseThrow(() -> new RuntimeException("Tag '" + tagValue + "' não encontrada no projeto."));

        postTagRepository.delete(postTag);
    }

    public void deleteTag(Long postTagId) {
        if (!postTagRepository.existsById(postTagId)) {
            throw new RuntimeException("Registro PostTag com ID " + postTagId + " não encontrado.");
        }
        postTagRepository.deleteById(postTagId);
    }
}
