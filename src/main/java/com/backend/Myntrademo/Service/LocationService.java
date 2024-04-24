package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Repository.LocationRepo;
import com.backend.Myntrademo.Repository.MobileNumberRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private MobileNumberRepo mobileNumberRepo;
    @Autowired
    private LocationRepo locationRepo;

    public Location createLocation(Location location) {
        return locationRepo.save(location);
    }

    public void deleteLocation(int locationid) {
        locationRepo.deleteById(locationid);
    }

    public Location getLocation(int locationid) {
        Optional<Location> dispLocation = locationRepo.findById(locationid);
        return dispLocation.orElse(null);
    }

    public Location updateLocation(int locationid, Location location) {
        Location location1 = locationRepo.findById(locationid).orElseThrow(() -> new RuntimeException("Location not found with LocationId:" + locationid));

        location1.setName(location.getName());
        location1.setBuildingnumber(location.getBuildingnumber());
        location1.setLocality(location.getLocality());
        location1.setDistrict(location.getDistrict());
        location1.setPincode(location.getPincode());
        location1.setState(location.getState());
        location1.setTypeofaddress(location.getTypeofaddress());

        return locationRepo.save(location1);
    }

}
