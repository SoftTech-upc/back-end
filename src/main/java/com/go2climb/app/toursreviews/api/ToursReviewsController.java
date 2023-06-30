package com.go2climb.app.toursreviews.api;

import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import com.go2climb.app.toursreviews.domain.service.ToursReviewsService;
import com.go2climb.app.toursreviews.mapping.ToursReviewsMapper;
import com.go2climb.app.toursreviews.resource.CreateToursReviewsResource;
import com.go2climb.app.toursreviews.resource.ToursReviewsResource;
import com.go2climb.app.toursreviews.resource.UpdateToursReviewsResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tours_reviews")
@AllArgsConstructor
@Tag(name = "Tours", description = "It is the controller of the Tours table")
public class ToursReviewsController {

   private final ToursReviewsService toursReviewsService;
   private final ToursReviewsMapper toursReviewsMapper;

    @Operation(summary = "Get all Tours")
    @GetMapping
  public List<ToursReviews> getAll(){
       return toursReviewsService.getAll();

  }

    @Operation(summary = "Get by Id -  Tours, return only one element")
    @GetMapping("{id}")
  public ToursReviewsResource getById(@PathVariable Integer id){
      return toursReviewsMapper.toResource(toursReviewsService.getById(id).get());
  }

    @Operation(summary = "Post Tours")
    @PostMapping
  public ToursReviewsResource save(@RequestBody CreateToursReviewsResource toursReviews){
      return toursReviewsMapper.toResource(toursReviewsService.Save(toursReviewsMapper.toModel(toursReviews)));
  }

    @Operation(summary = "Put by Id -  Tours, it is necessary to send the Body object")
    @PutMapping("{id}")
  public ResponseEntity<ToursReviewsResource> update(@PathVariable Integer id, @RequestBody UpdateToursReviewsResource toursReviews ) {
    if(id.equals(toursReviews.getId())){
      ToursReviewsResource toursReviewsResource = toursReviewsMapper.toResource(toursReviewsService.Update(toursReviewsMapper.toModel(toursReviews)));
    return ResponseEntity.ok(toursReviewsResource);
    } else {
      return  ResponseEntity.badRequest().build();
    }
  }

    @Operation(summary = "Delete by Id")
    @DeleteMapping("{id}")
  public  ResponseEntity <?>  deleteById(@PathVariable Integer id){
    if(toursReviewsService.deleteById(id)) {
        return  ResponseEntity.ok().build();
    } else {
        return  ResponseEntity.notFound().build();
    }
  }
}
