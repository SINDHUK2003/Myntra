package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Repository.LocationRepo;
import com.backend.Myntrademo.Repository.MobileNumberRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private MobileNumberRepo mobileNumberRepo;


    public Profile createProfile(Profile profile, MobileNumber mobileNumber, Location location) {

        System.out.println("Profile received: " + profile);
        System.out.println("MobileNumber received: " + mobileNumber);
        System.out.println("Location received: " + location);

        profile.setMobileNumber(mobileNumber);
        profile.setLocation(location);

        if (mobileNumber != null) {
            mobileNumberRepo.save(mobileNumber);
            System.out.println("MobileNumber saved: " + mobileNumber);
        }
        if (location != null) {
            locationRepo.save(location);
            System.out.println("Location saved: " + location);
        }

        Profile savedProfile = profileRepo.save(profile);
        System.out.println("Profile saved: " + savedProfile);

        return savedProfile;
    }


    public void deleteProfile(int profileid)
    {
        profileRepo.deleteById(profileid);

    }

    public Profile getProfile(int profileid)
    {
        Optional<Profile> dispProfile = profileRepo.findById(profileid);
        return dispProfile.orElse(null);
    }

    public Profile updateProfile(int profileid, Profile profile)
    {
        Profile profile1 = profileRepo.findById(profileid).orElseThrow(() -> new RuntimeException("Profile not found with profileid:" + profileid));
        profile1.setUsername(profile.getUsername());
        profile1.setEmail(profile.getEmail());
        profile1.setGender(profile.getGender());
        profile1.setDateofbirth(profile.getDateofbirth());

        return profileRepo.save(profile1);
    }

}

