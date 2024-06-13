package com.backend.Myntrademo.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Enum.ProfileType;
import com.backend.Myntrademo.Repository.LocationRepo;
import com.backend.Myntrademo.Repository.MobileNumberRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private MobileNumberRepo mobileNumberRepo;


    private Map<Integer, String> loggedInUsers = new HashMap<>();
    private Map<Integer, String> adminLoggedInUsers = new HashMap<>();
    private Map<Integer, Integer> adminEmployeeMap = new HashMap<>();
    private Map<Integer, Integer> adminSellerMap = new HashMap<>();
    private Map<Integer, String> employeeLoggedInUsers = new HashMap<>();
    private Map<Integer, String> sellerLoggedInUsers = new HashMap<>();

    public Profile createProfile(Profile profile, MobileNumber mobileNumber, Location location) {

        if (profile.getProfileType() == ProfileType.USER) {
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
        } else {
            throw new IllegalArgumentException("Profile creation is only allowed for ProfileType.USER");
        }
    }

    public Profile createAdmin(Profile adminProfile, MobileNumber mobileNumber, Location location) {
        if (adminProfile.getProfileType() == ProfileType.ADMIN) {
            adminProfile.setMobileNumber(mobileNumber);
            adminProfile.setLocation(location);

            if (mobileNumber != null) {
                mobileNumberRepo.save(mobileNumber);
                System.out.println("MobileNumber saved: " + mobileNumber);
            }
            if (location != null) {
                locationRepo.save(location);
                System.out.println("Location saved: " + location);
            }

            Profile savedAdminProfile = profileRepo.save(adminProfile);
            System.out.println("Admin Profile saved: " + savedAdminProfile);

            return savedAdminProfile;
        } else {
            throw new IllegalArgumentException("Admin Profile creation is only allowed for ProfileType.ADMIN");
        }
    }

    public Profile createEmployee(int adminProfileId, Profile employeeProfile, MobileNumber mobileNumber, Location location) {
        if (adminLoggedInUsers.containsKey(adminProfileId)) {
            employeeProfile.setProfileType(ProfileType.EMPLOYEE);
            employeeProfile.setMobileNumber(mobileNumber);
            employeeProfile.setLocation(location);

            if (mobileNumber != null) {
                mobileNumberRepo.save(mobileNumber);
                System.out.println("MobileNumber saved: " + mobileNumber);
            }

            if (location != null) {
                locationRepo.save(location);
                System.out.println("Location saved: " + location);
            }

            Profile savedEmployeeProfile = profileRepo.save(employeeProfile);
            adminEmployeeMap.put(adminProfileId, savedEmployeeProfile.getProfileid());
            System.out.println("Employee Profile saved: " + savedEmployeeProfile);

            return savedEmployeeProfile;
        } else {
            throw new IllegalArgumentException("Only logged-in admins can create employee profiles.");
        }
    }

    public Profile createSeller(int adminProfileId, Profile sellerProfile, MobileNumber mobileNumber, Location location) {
        if (adminLoggedInUsers.containsKey(adminProfileId)) {
            sellerProfile.setProfileType(ProfileType.SELLER);
            sellerProfile.setMobileNumber(mobileNumber);
            sellerProfile.setLocation(location);

            if (mobileNumber != null) {
                mobileNumberRepo.save(mobileNumber);
                System.out.println("MobileNumber saved: " + mobileNumber);
            }

            if (location != null) {
                locationRepo.save(location);
                System.out.println("Location saved: " + location);
            }

            Profile savedSellerProfile = profileRepo.save(sellerProfile);
            adminSellerMap.put(adminProfileId, savedSellerProfile.getProfileid());
            System.out.println("Seller Profile saved: " + savedSellerProfile);

            return savedSellerProfile;
        } else {
            throw new IllegalArgumentException("Only logged-in admins can create seller profiles.");
        }
    }

    public String login(String email, String password) {
        Profile profile = profileRepo.findByEmail(email);
        if (profile != null && profile.getPassword().equals(password) && profile.getProfileType() == ProfileType.USER) {
            int profileId = profile.getProfileid();
            loggedInUsers.put(profileId, email);
            return "Login successful!";
        } else {
            return "Only users can login , Check your data";
        }
    }

    public String otherLogin(String email, String password) {
        Profile profile = profileRepo.findByEmail(email);
        if (profile != null && profile.getPassword().equals(password)) {
            ProfileType profileType = profile.getProfileType();
            int profileId = profile.getProfileid();
            switch (profileType) {
                case ADMIN:
                    adminLoggedInUsers.put(profileId, email);
                    break;
                case EMPLOYEE:
                    employeeLoggedInUsers.put(profileId, email);
                    break;
                case SELLER:
                    sellerLoggedInUsers.put(profileId, email);
                    break;
                default:
                    return "Invalid profile type for this login";
            }
            loggedInUsers.put(profileId, email);
            return profileType + " login successful!";
        } else {
            return "Invalid email or password for other login";
        }
    }


    public String logout(int profileId) {
        if (loggedInUsers.containsKey(profileId)) {
            loggedInUsers.remove(profileId);
            adminLoggedInUsers.remove(profileId);
            employeeLoggedInUsers.remove(profileId);
            sellerLoggedInUsers.remove(profileId);
            return "Logout successful!";
        } else {
            return "User is not logged in";
        }
    }

//    public String login(String email, String password) {
//        Profile profile = profileRepo.findByEmail(email);
//        if (profile != null && profile.getPassword().equals(password))
//        {
//            loggedInUsers.put(profile.getProfileid(), email);
//
//            if (profile.getProfileType() == ProfileType.ADMIN)
//            {
//                adminLoggedInUsers.put(profile.getProfileid(), email);
//            }
//            return "Login successful!";
//        }
//        else
//        {
//            return "Invalid email or password";
//        }
//    }

//    public String logout(int profileId) {
//        if (loggedInUsers.containsKey(profileId)) {
//            loggedInUsers.remove(profileId);
//            adminLoggedInUsers.remove(profileId);
//            return "Logout successful!";
//        } else {
//            return "User is not logged in";
//        }
//    }

    public void deleteProfile(int profileid) {
        if (loggedInUsers.containsKey(profileid)) {
            profileRepo.deleteById(profileid);
        } else {
            throw new IllegalStateException("User not logged in");
        }
    }

//    public String login(String email, String password) {
//        Profile profile = profileRepo.findByEmail(email);
//        if (profile != null && profile.getPassword().equals(password)) {
//            loggedInUsers.put(profile.getProfileid(), email);
//            return "Login successful!";
//        } else {
//            return "Invalid email or password";
//        }
//    }
//    public String logout(int profileId) {
//        if (loggedInUsers.containsKey(profileId)) {
//            loggedInUsers.remove(profileId);
//            return "Logout successful!";
//        } else {
//            return "User is not logged in";
//        }
//    }

//    public String login(String email, String password) {
//        Profile profile = profileRepo.findByEmail(email);
//        if (profile != null && profile.getPassword().equals(password))
//        {
//            return "Login successful!";
//        }
//        else
//        {
//            return "Invalid email or password";
//        }
//    }

//    public Profile createProfile(Profile profile, MobileNumber mobileNumber, Location location) {
//
//        profile.setMobileNumber(mobileNumber);
//        profile.setLocation(location);
//
//        if (mobileNumber != null) {
//            mobileNumberRepo.save(mobileNumber);
//            System.out.println("MobileNumber saved: " + mobileNumber);
//        }
//        if (location != null) {
//            locationRepo.save(location);
//            System.out.println("Location saved: " + location);
//        }
//
//        Profile savedProfile = profileRepo.save(profile);
//        System.out.println("Profile saved: " + savedProfile);
//
//        return savedProfile;
//    }


//    public void deleteProfile(int profileid)
//    {
//        if (loggedInUsers.containsKey(profileid))
//        {
//            profileRepo.deleteById(profileid);
//        }
//        else
//        {
//            throw new IllegalStateException("User not logged in");
//        }
//
//    }

    public Profile getProfile(int profileid)
    {
        Optional<Profile> dispProfile = profileRepo.findById(profileid);
        return dispProfile.orElse(null);
    }

    public Profile updateProfile(int profileid, Profile profile)
    {
        if (loggedInUsers.containsKey(profileid))
        {
            Profile profile1 = profileRepo.findById(profileid).orElseThrow(() -> new RuntimeException("Profile not found with profileid:" + profileid));
            profile1.setUsername(profile.getUsername());
            profile1.setEmail(profile.getEmail());
            profile1.setGender(profile.getGender());
            profile1.setDateofbirth(profile.getDateofbirth());

            return profileRepo.save(profile1);
        }
        else
        {
            System.out.println("User must be logged in to update profile");
            throw new IllegalStateException("User not logged in");
        }
    }

    public String resetPassword(String email, String newPassword) {
        Profile profile = profileRepo.findByEmail(email);

        if (profile == null) {
            throw new RuntimeException("User with email " + email + " not found!");
        }

        if (!loggedInUsers.containsKey(profile.getProfileid())) {
            throw new IllegalStateException("User not logged in");
        }

        profile.setPassword(newPassword);
        profileRepo.save(profile);
        return "Password reset successful!";
    }

//    public String resetPassword(String email, String newPassword) {
//        Profile profile = profileRepo.findByEmail(email);
//        if (profile != null && loggedInUsers.containsKey(profile.getProfileid()))
//        {
//                profile.setPassword(newPassword);
//                profileRepo.save(profile);
//                return "Password reset successful!";
//            }
//        else
//        {
//            return "User with email " + email + " not found!";
//        }
//    }

    public Map<Integer, String> getLoggedInUsers()
    {
        return new HashMap<>(loggedInUsers);
    }

    public Map<Integer, Integer> getAdminEmployeeMap()
    {
        return new HashMap<>(adminEmployeeMap);
    }

    public Map<Integer, Integer> getAdminSellerMap()
    {
        return new HashMap<>(adminSellerMap);
    }

    public Map<Integer, String> getAdminLoggedInUsers()
    {
        return new HashMap<>(adminLoggedInUsers);
    }

    public Map<Integer, String> getEmployeeLoggedInUsers()
    {
        return new HashMap<>(employeeLoggedInUsers);
    }

    public Map<Integer, String> getSellerLoggedInUsers()
    {
        return new HashMap<>(sellerLoggedInUsers);
    }

    public boolean isUserLoggedIn(int profileId) {
        return loggedInUsers.containsKey(profileId);
    }
    public boolean isEmployeeLoggedIn(int profileId) {
        return loggedInUsers.containsKey(profileId) && employeeLoggedInUsers.containsKey(profileId);
    }

    public boolean isSellerLoggedIn(int profileId) {
        return loggedInUsers.containsKey(profileId) && sellerLoggedInUsers.containsKey(profileId);
    }

    public boolean isAdminLoggedIn(int profileId)
    {
        return loggedInUsers.containsKey(profileId) && adminLoggedInUsers.containsKey(profileId);
    }

    public boolean isEmpSelAdmin(int profileId) {
        return loggedInUsers.containsKey(profileId) && (employeeLoggedInUsers.containsKey(profileId) || sellerLoggedInUsers.containsKey(profileId) || (adminLoggedInUsers.containsKey(profileId)));
    }






}

