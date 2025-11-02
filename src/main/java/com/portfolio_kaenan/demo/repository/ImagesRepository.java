package com.portfolio_kaenan.demo.repository;

import com.portfolio_kaenan.demo.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images,Long> {
    List<Images> findByProject_Id(Long projectId);
    List<Images> findByCertificate_Id(Long certificateId);
}
