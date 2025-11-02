package com.portfolio_kaenan.demo.repository;

import com.portfolio_kaenan.demo.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

}
