package com.portfolio_kaenan.demo.service;

import com.portfolio_kaenan.demo.entity.Images;
import com.portfolio_kaenan.demo.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

    public List<Images> findByProject_Id(Long projectId) {
        return imagesRepository.findByProject_Id(projectId);
    }

    public List<Images> findByCertificate_Id(Long certificateId) {
        return imagesRepository.findByCertificate_Id(certificateId);
    }

    public Images save(Images image) {
        return imagesRepository.save(image);
    }

    public Images update(Long id, Images imageDetails) {
        Images existingImage = imagesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagem não encontrada com ID: " + id)); // Use sua exceção
        imageDetails.setId_images(id);

        return imagesRepository.save(imageDetails);
    }

    public void deleteById(Long id) {

        if(!imagesRepository.existsById(id)){
            throw new RuntimeException("Imagem com ID " + id + " não encontrado.");
        }

        imagesRepository.deleteById(id);
    }
}
