package com.backend.Myntrademo.Entity;

import com.backend.Myntrademo.Enum.ProfileType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProfileId", unique = true)
    private Integer profileid;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "DateOfBirth")
    private Date dateofbirth;

    @ManyToOne
    @JoinColumn(name = "mobilenumberid")
    private MobileNumber mobileNumber;

    @ManyToOne
    @JoinColumn(name = "locationid")
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(name = "profiletype")
    private ProfileType profileType;
}
