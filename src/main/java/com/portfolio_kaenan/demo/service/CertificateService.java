package com.portfolio_kaenan.demo.service;

import com.portfolio_kaenan.demo.entity.Certificate;
import com.portfolio_kaenan.demo.entity.Images;
import com.portfolio_kaenan.demo.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final ImagesService imagesService;

    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> findById(Long id) {
        return certificateRepository.findById(id);
    }

    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public void deleteById(Long id) {
        if (!certificateRepository.existsById(id)) {
            throw new RuntimeException("Certificado com ID " + id + " não encontrado.");
        }
        certificateRepository.deleteById(id);
    }

    public List<Images> findImagesByCertificateId(Long certificateId) {
        return imagesService.findByCertificate_Id(certificateId);
    }
}
