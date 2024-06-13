package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO {
    private Profile adminProfile;
    private MobileNumber mobileNumber;
    private Location location;
}
