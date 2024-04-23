package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileNumberRepo extends JpaRepository<MobileNumber, Integer> {
}
