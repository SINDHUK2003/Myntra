package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Repository.GalleryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepo galleryRepo;

    public Gallery createGallery(Gallery gallery)
    {
        return galleryRepo.save(gallery);
    }

    public void deleteGallery(int galleryid)
    {
        galleryRepo.deleteById(galleryid);
    }

    public Gallery getGallery(int galleryid)
    {
        Optional<Gallery> dispGallery = galleryRepo.findById(galleryid);
        return dispGallery.orElse(null);
    }

    public Gallery updateGallery(int galleryid, Gallery gallery)
    {
        Gallery gallery1 = galleryRepo.findById(galleryid).orElseThrow(() -> new RuntimeException("Gallery not found with GalleryId : " + galleryid));

        gallery1.setImage1(gallery.getImage1());
        gallery1.setImage2(gallery.getImage2());
        gallery1.setImage3(gallery.getImage3());
        gallery1.setImage4(gallery.getImage4());
        gallery1.setImage5(gallery.getImage5());

        gallery1.setVideo1(gallery1.getVideo1());
        gallery1.setVideo2(gallery.getVideo2());

        gallery1.setType(gallery.getType());

        return galleryRepo.save(gallery1);
    }

    public List<Gallery> getByType(String type)
    {
        return galleryRepo.findByType(type);
    }



}
