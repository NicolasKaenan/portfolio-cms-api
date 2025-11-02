package com.portfolio_kaenan.demo.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "certificates")
@RequiredArgsConstructor
@NoArgsConstructor
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificates")
    private Long id;

    @NonNull
    private String title;
    @NonNull
    private String institution;
    @NonNull
    private String shortenedDescription;
    @NonNull
    private String fullDescription;
    @NonNull
    private LocalDate completionDate;

    @NonNull
    @Column(unique = true)
    private String linkValidation;

    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Images> images;
}
