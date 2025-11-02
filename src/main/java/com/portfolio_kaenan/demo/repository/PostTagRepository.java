package com.portfolio_kaenan.demo.repository;


import com.portfolio_kaenan.demo.entity.PostTag;
import com.portfolio_kaenan.demo.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    Optional<PostTag> findByProjectAndValue(Projects project, String value);
    List<PostTag> findByProjectId(Long projectId);
}
