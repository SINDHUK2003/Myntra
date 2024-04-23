package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.MobileNumber;
import com.backend.Myntrademo.Repository.MobileNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MobileNumberService {

    @Autowired
    private MobileNumberRepo mobileNumberRepo;

    public MobileNumber createMobileNumber(MobileNumber mobileNumber)
    {
        return mobileNumberRepo.save(mobileNumber);
    }

    public void deleteMobileNumber(int mobilenumberid)
    {
        mobileNumberRepo.deleteById(mobilenumberid);
    }

    public MobileNumber getMobileNumber(int mobilenumberid)
    {
        Optional<MobileNumber> dispMobileNumber = mobileNumberRepo.findById(mobilenumberid);
        return dispMobileNumber.orElse(null);
    }

    public MobileNumber updateMobileNumber(int mobilenumberid, MobileNumber mobileNumber)
    {
        MobileNumber mobileNumber1 = mobileNumberRepo.findById(mobilenumberid).orElseThrow(() -> new RuntimeException("Mobile Number not found with MobileNumberId:" + mobilenumberid));

        mobileNumber1.setCountrycode(mobileNumber.getCountrycode());
        mobileNumber1.setMobilenumber(mobileNumber.getMobilenumber());
        mobileNumber1.setAlternatenumber(mobileNumber.getAlternatenumber());

        return mobileNumberRepo.save(mobileNumber1);
    }

}
