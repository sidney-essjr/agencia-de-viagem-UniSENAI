package com.travel_agency.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Entity representing a destination Review.
 */

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @Column(nullable = false)
    private int rating;

    @Column(length = 500)
    private String description;

    @Column(name = "evaluate_date", nullable = false)
    private LocalDate evaluateDate;

    @PrePersist
    protected void prePersist() {
        this.evaluateDate = LocalDate.now();
    }

}
