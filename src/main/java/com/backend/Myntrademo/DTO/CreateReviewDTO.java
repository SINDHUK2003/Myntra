package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Enum.Rating;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class CreateReviewDTO {
    private String title;
    private String description;
    private Rating rating;
    private Integer profileId;
    private Integer productId;
}
