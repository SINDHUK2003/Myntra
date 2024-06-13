package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import lombok.Data;

@Data
public class CreateSellerDTO {
    private int adminProfileId;
    private Profile sellerProfile;
    private MobileNumber mobileNumber;
    private Location location;
}
