package com.portfolio_kaenan.demo.controller;

import com.portfolio_kaenan.demo.entity.Images;
import com.portfolio_kaenan.demo.service.ImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
@CrossOrigin(
        originPatterns = {
                "http://localhost:*",
                "https://*.kaenan.dev"
        }
)

public class ImagesController {
    private final ImagesService imagesService;

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Images>> getImagesByProjectId(@PathVariable Long projectId) {

        List<Images> images = imagesService.findByProject_Id(projectId);

        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }

    @GetMapping("/certificate/{certificateId}")
    public ResponseEntity<List<Images>> getImagesByCertificateId(@PathVariable Long certificateId) {

        List<Images> images = imagesService.findByCertificate_Id(certificateId);

        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }

    @PostMapping
    public ResponseEntity<Images> saveImage(@RequestBody Images image) {
        Images savedImage = imagesService.save(image);

        return ResponseEntity.status(201).body(savedImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Images> updateImage(@PathVariable Long id, @RequestBody Images image) {
        Images updatedImage = imagesService.update(id, image);

        return  ResponseEntity.ok(updatedImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imagesService.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
