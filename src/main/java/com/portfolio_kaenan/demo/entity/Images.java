package com.portfolio_kaenan.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="images")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Projects project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;

    @NonNull
    private String link_images;
    @NonNull
    private String alt_images;
    @NonNull
    private boolean is_cover;
}
