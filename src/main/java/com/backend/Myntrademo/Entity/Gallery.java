package com.backend.Myntrademo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Gallery")
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GalleryId")
    private Integer galleryid;

    @Column(name = "Iamge1")
    private String image1;

    @Column(name = "Iamge2")
    private String image2;

    @Column(name = "Iamge3")
    private String image3;

    @Column(name = "Iamge4")
    private String image4;

    @Column(name = "Iamge5")
    private String image5;

    @Column(name = "Video1")
    private String video1;

    @Column(name = "Viedo2")
    private String video2;

    @Column(name = "Type")
    private String type;
}
