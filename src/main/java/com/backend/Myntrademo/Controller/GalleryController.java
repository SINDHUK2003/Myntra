package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GalleryController {

    @Autowired
    private GalleryService galleryService;


    @PostMapping("/createGallery")
    private Gallery createGallery(@RequestBody Gallery gallery)
    {
        return galleryService.createGallery(gallery);
    }

    @GetMapping("/getGallery/{galleryid}")
    private Gallery getGallery(@PathVariable("galleryid") int galleryid)
    {
        return galleryService.getGallery(galleryid);
    }

    @DeleteMapping("/deleteGallery/{galleryid}")
    private String deleteGallery(@PathVariable("galleryid") int galleryid)
    {
        galleryService.deleteGallery(galleryid);
        return "GALLERY DELETED";
    }

    @PutMapping("/updateGallery/{galleryid}")
    private Gallery updateGallery(@PathVariable("galleryid") int galleryid, @RequestBody Gallery gallery)
    {
        return galleryService.updateGallery(galleryid, gallery);
    }

    @GetMapping("/getByType/{type}")
    private List<Gallery> getByType(@PathVariable("type") String type)
    {
        return galleryService.getByType(type);
    }



}
