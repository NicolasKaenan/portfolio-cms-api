package com.portfolio_kaenan.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post_tags")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post_tag;

    @NonNull
    private String value;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_projects", nullable = false)
    private Projects project;
}