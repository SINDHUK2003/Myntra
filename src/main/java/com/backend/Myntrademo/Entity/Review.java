package com.backend.Myntrademo.Entity;

import com.backend.Myntrademo.Enum.Rating;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewId")
    private Integer reviewid;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rating")
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "Profile")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "Product")
    private Product product;

}
