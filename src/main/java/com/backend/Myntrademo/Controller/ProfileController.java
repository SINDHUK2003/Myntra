package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.*;
import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/createProfile")
    public Profile createProfile(@RequestBody CreateProfileDTO createProfileDTO)
    {
        Profile profile = createProfileDTO.getProfile();
        MobileNumber mobileNumber = createProfileDTO.getMobileNumber();
        Location location = createProfileDTO.getLocation();
        return profileService.createProfile(profile, mobileNumber, location);
    }

    @PostMapping("/createAdmin")
    public Profile createAdmin(@RequestBody CreateAdminDTO createAdminDTO) {
        Profile adminProfile = createAdminDTO.getAdminProfile();
        MobileNumber mobileNumber = createAdminDTO.getMobileNumber();
        Location location = createAdminDTO.getLocation();
        return profileService.createAdmin(adminProfile, mobileNumber, location);
    }

    @PostMapping("/createEmployee")
    public Profile createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO)
    {
        int adminProfileId = createEmployeeDTO.getAdminProfileId();
        Profile employeeProfile = createEmployeeDTO.getEmployeeProfile();
        MobileNumber mobileNumber = createEmployeeDTO.getMobileNumber();
        Location location = createEmployeeDTO.getLocation();
        return profileService.createEmployee(adminProfileId, employeeProfile, mobileNumber, location);
    }

    @PostMapping("/createSeller")
    public Profile createSeller(@RequestBody CreateSellerDTO createSellerDTO)
    {
        int adminProfileId = createSellerDTO.getAdminProfileId();
        Profile sellerProfile = createSellerDTO.getSellerProfile();
        MobileNumber mobileNumber = createSellerDTO.getMobileNumber();
        Location location = createSellerDTO.getLocation();
        return profileService.createSeller(adminProfileId, sellerProfile, mobileNumber, location);
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestBody Profile loginUser)
    {
        return profileService.login(loginUser.getEmail(), loginUser.getPassword());
    }

    @PostMapping("/otherLogin")
    public String otherLogin(@RequestBody Profile loginUser)
    {
        return profileService.otherLogin(loginUser.getEmail(), loginUser.getPassword());
    }


    @PostMapping("/logout")
    public String logout(@RequestBody Profile logoutUser) {
        return profileService.logout(logoutUser.getProfileid());
    }

//    @PostMapping("/login")
//    public String login(@RequestBody LoginDTO loginDTO)
//    {
//        String email = loginDTO.getEmail();
//        String password = loginDTO.getPassword();
//
//        return profileService.login(email, password);
//    }
//
//    @PostMapping("/logout")
//    public String logout(@RequestBody Map<String, Integer> logoutData)
//    {
//        int profileId = logoutData.get("profileId");
//        return profileService.logout(profileId);
//    }

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

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        String email = resetPasswordRequest.getEmail();
        String newPassword = resetPasswordRequest.getNewPassword();
        return profileService.resetPassword(email, newPassword);
    }

    @GetMapping("/getLoggedInUsers")
    public Map<Integer, String> getLoggedInUsers()
    {
        return profileService.getLoggedInUsers();
    }

    @GetMapping("/getLoggedInAdmins")
    public Map<Integer, String> getLoggedInAdmins() {
        return profileService.getAdminLoggedInUsers();
    }

    @GetMapping("/getLoggedInEmployees")
    public Map<Integer, String> getLoggedInEmployees() {
        return profileService.getEmployeeLoggedInUsers();
    }

    @GetMapping("/getLoggedInSellers")
    public Map<Integer, String> getLoggedInSellers() {
        return profileService.getSellerLoggedInUsers();
    }

    @GetMapping("/getAdminEmployeeMap")
    public Map<Integer, Integer> getAdminEmployeeMap()
    {
        return profileService.getAdminEmployeeMap();
    }

    @GetMapping("/getAdminSellerMap")
    public Map<Integer, Integer> getAdminSellerMap()
    {
        return profileService.getAdminSellerMap();
    }


}

