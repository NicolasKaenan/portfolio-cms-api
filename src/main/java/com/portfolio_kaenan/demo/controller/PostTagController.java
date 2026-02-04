package com.portfolio_kaenan.demo.controller;

import com.portfolio_kaenan.demo.dto.TagRequest;
import com.portfolio_kaenan.demo.entity.PostTag;
import com.portfolio_kaenan.demo.service.PostTagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
@CrossOrigin(
        originPatterns = {
                "http://localhost:*",
                "https://*.kaenan.dev",
                "https://kaenan.dev"
        }
)

public class PostTagController {
    private final PostTagService postTagService;

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<PostTag>> getAll(@PathVariable("projectId") Long projectId) {

        List<PostTag> tags = postTagService.getByProjectId(projectId);

        if (tags.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tags);
    }

    @PostMapping("/projects/{projectId}")
    public ResponseEntity<PostTag> addTagToProject(
            @PathVariable Long projectId,
            @RequestBody @Valid TagRequest request) {

        String tagValue = request.value();
        PostTag savedTag = postTagService.addTagToProject(projectId, tagValue);

        return ResponseEntity.status(201).body(savedTag);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long tagId) {
        postTagService.deleteTag(tagId);

        return ResponseEntity.noContent().build();
    }
}
