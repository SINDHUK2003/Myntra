package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProfileDTO {
    private Profile profile;
    private MobileNumber mobileNumber;
    private Location location;
}
