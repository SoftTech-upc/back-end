
package com.go2climb.app.toursreviews.api;


import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import com.go2climb.app.toursreviews.domain.service.ToursReviewsService;
import com.go2climb.app.toursreviews.mapping.ToursReviewsMapper;
import com.go2climb.app.toursreviews.resource.CreateToursReviewsResource;
import com.go2climb.app.toursreviews.resource.ToursReviewsResource;
import com.go2climb.app.toursreviews.resource.UpdateToursReviewsResource;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tours_reviews")
@AllArgsConstructor
public class ToursReviewsController {

   private final ToursReviewsService toursReviewsService;
   private final ToursReviewsMapper toursReviewsMapper;
   @GetMapping
  public List<ToursReviews> getAll(){
       return toursReviewsService.getAll();

  }
  @GetMapping("{Id}")
  public ToursReviewsResource getById(@PathVariable Integer Id){
//return  toursReviewsService.getById(Id);
      return toursReviewsMapper.toResource(toursReviewsService.getById( Id).get());
  }
  @PostMapping
  public ToursReviewsResource Save(@RequestBody CreateToursReviewsResource toursReviews){
      return toursReviewsMapper.toResource(toursReviewsService.Save(toursReviewsMapper.toModel(toursReviews)));
  }
  @PutMapping("{Id}")
 public   ResponseEntity<ToursReviewsResource> Update(@PathVariable Integer Id,
                                                      @RequestBody UpdateToursReviewsResource toursReviews ) {
if(Id.equals(toursReviews.getId())){
    ToursReviewsResource toursReviewsResource = toursReviewsMapper.toResource(
            toursReviewsService.Update(toursReviewsMapper.toModel(toursReviews)));
    return ResponseEntity.ok(toursReviewsResource);
}else {
    return  ResponseEntity.badRequest().build();
}
 }
@DeleteMapping("{Id}")
   public  ResponseEntity <?>  deleteById(   @PathVariable Integer Id){

    if(toursReviewsService.deleteById(Id) ){
        return  ResponseEntity.ok().build();
    }else {
        return  ResponseEntity.notFound().build();
    }

  }
}
