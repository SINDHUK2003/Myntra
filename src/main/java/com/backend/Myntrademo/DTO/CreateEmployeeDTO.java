package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import lombok.Data;

@Data
public class CreateEmployeeDTO {
    private int adminProfileId;
    private Profile employeeProfile;
    private MobileNumber mobileNumber;
    private Location location;
}
