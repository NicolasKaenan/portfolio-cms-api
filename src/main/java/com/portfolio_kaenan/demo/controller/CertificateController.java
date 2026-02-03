package com.portfolio_kaenan.demo.controller;

import com.portfolio_kaenan.demo.entity.Certificate;
import com.portfolio_kaenan.demo.entity.Images;
import com.portfolio_kaenan.demo.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/certificates") // URL base
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CertificateController {
    private final CertificateService certificateService;


    @GetMapping
    public ResponseEntity<List<Certificate>> findAll() {
        return ResponseEntity.ok(certificateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> findById(@PathVariable Long id) {
        Optional<Certificate> certificate = certificateService.findById(id);

        return certificate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Certificate> save(@RequestBody Certificate certificate) {
        Certificate savedCertificate = certificateService.save(certificate);
        return ResponseEntity.status(201).body(savedCertificate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certificate> update(@PathVariable Long id, @RequestBody Certificate certificate) {
        Certificate updatedCertificate = certificateService.save(certificate);
        return ResponseEntity.ok(updatedCertificate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        certificateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<List<Images>> findImagesByCertificateId(@PathVariable Long id) {
        List<Images> images = certificateService.findImagesByCertificateId(id);

        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }
}
