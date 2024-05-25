package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>
{
    @Query("SELECT c FROM Cart c WHERE c.profile.profileid = :profileId")
    List<Cart> getCartByProfileId(@Param("profileId") int profileId);


}
