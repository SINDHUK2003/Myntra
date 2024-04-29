package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.CreateProfileDTO;
import com.backend.Myntrademo.DTO.LoginDTO;
import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Service.LocationService;
import com.backend.Myntrademo.Service.MobileNumberService;
import com.backend.Myntrademo.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private MobileNumberService mobileNumberService;

    @Autowired
    private LocationService locationService;



    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO)
    {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        return profileService.login(email, password);
    }

    @PostMapping("/createProfile")
    public Profile createProfile(@RequestBody CreateProfileDTO createProfileDTO)
    {
        Profile profile = createProfileDTO.getProfile();
        MobileNumber mobileNumber = createProfileDTO.getMobileNumber();
        Location location = createProfileDTO.getLocation();
        return profileService.createProfile(profile, mobileNumber, location);
    }

    @DeleteMapping("/deleteProfile/{profileid}")
    public String deleteProfile(@PathVariable("profileid") int profileid )
    {
        profileService.deleteProfile(profileid);
        return "Profile deleted !";
    }

    @GetMapping("getProfile/{profileid}")
    public Profile getProfile(@PathVariable("profileid") int profileid)
    {
        return profileService.getProfile(profileid);
    }

    @PutMapping("updateProfile/{profileid}")
    public Profile updateProfile (@PathVariable("profileid") int profileid, @RequestBody Profile profile)
    {
        return profileService.updateProfile(profileid, profile);
    }


}

