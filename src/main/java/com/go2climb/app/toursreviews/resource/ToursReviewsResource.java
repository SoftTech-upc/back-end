package com.example.SoftTech.resource;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ToursReviewsResource {

    private Long id;
    private Date date;
    private String comment;
    private Long score;
}
