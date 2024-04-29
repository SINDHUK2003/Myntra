package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {

    Profile findByEmail(String email);

}
