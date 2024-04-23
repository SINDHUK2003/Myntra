package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Service.MobileNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MobileNumberController {

    @Autowired
    private MobileNumberService mobileNumberService;

    @PostMapping("/createMobile")
    public MobileNumber createMobileNumber(@RequestBody MobileNumber mobileNumber)
    {
        return mobileNumberService.createMobileNumber(mobileNumber);
    }

    @DeleteMapping("/deleteMobile/{mobilenumberid}")
    public String deleteMobileNumber(@PathVariable("mobilenumberid") int mobilenumberid)
    {
        mobileNumberService.deleteMobileNumber(mobilenumberid);
        return "MobileNumber deleted !";
    }

    @GetMapping("/getMobile/{mobilenumberid}")
    public MobileNumber getMobileNumber(@PathVariable("mobilenumberid") int mobilenumberid)
    {
        return mobileNumberService.getMobileNumber(mobilenumberid);
    }

    @PutMapping("/updateMobile/{mobilenumberid}")
    public MobileNumber updateMobileNumber(@PathVariable("mobilenumberid") int mobilenumberid,@RequestBody MobileNumber mobileNumber)
    {
        return mobileNumberService.updateMobileNumber(mobilenumberid, mobileNumber);
    }

}
