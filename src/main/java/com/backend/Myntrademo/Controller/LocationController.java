package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Location;
import com.backend.Myntrademo.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/createLocation")
    public Location createLocation(@RequestBody Location location)
    {
        return locationService.createLocation(location);
    }

    @DeleteMapping("/deleteLocation/{locationid}")
    public String deleteLocation(@PathVariable("locationid") int locationid)
    {
        locationService.deleteLocation(locationid);
        return "Location deleted !";
    }

    @GetMapping("/getLocation/{locationid}")
    public Location getLocation(@PathVariable("locationid") int locationid)
    {
        return locationService.getLocation(locationid);
    }
    @PutMapping("/updateLocation/{locationid}")
    public Location updateLocation(@PathVariable("locationid") int locationid ,@RequestBody Location location)
    {
        return locationService.updateLocation(locationid, location);
    }




}
