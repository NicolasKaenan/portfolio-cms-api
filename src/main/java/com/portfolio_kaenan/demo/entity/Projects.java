package com.portfolio_kaenan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projects")
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String shortened_description;
    @NonNull
    private String full_description;
    @NonNull
    private String project_url;
    @NonNull
    private String repository_url;
    @NonNull
    private Date posting_date;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Images> images;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("project")
    private List<PostTag> postTags;
}
