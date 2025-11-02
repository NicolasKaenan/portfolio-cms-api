package com.portfolio_kaenan.demo.repository;

import com.portfolio_kaenan.demo.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
