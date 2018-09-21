package ua.softserve.rv036.findmeplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.rv036.findmeplace.model.Feedback;
import ua.softserve.rv036.findmeplace.model.Place;
import ua.softserve.rv036.findmeplace.model.PlaceType;
import ua.softserve.rv036.findmeplace.repository.FeedbackRepository;
import ua.softserve.rv036.findmeplace.repository.PlaceRepository;
import ua.softserve.rv036.findmeplace.utils.PlaceTypeObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/map")
    List<Place> getPlace() {
        return placeRepository.findAll();
    }

    @PostMapping("/map")
    List<Place> filteredPlaces(@RequestBody PlaceTypeObject placeType) {
        List<PlaceType> list = new ArrayList<>();
        if (placeType.getRestaurant()) {
            list.add(PlaceType.RESTAURANT);
        }
        if (placeType.getParking()){
            list.add(PlaceType.PARKING);
        }
        if (placeType.getHotel()){
            list.add(PlaceType.HOTEL);
        }
        return placeRepository.findByPlaceTypeIn(list);
    }

    @GetMapping("/places/{id}")
    Optional<Place> getUserById(@PathVariable Long id) {
        return placeRepository.findById(id);
    }

    @GetMapping("places/{id}/feedbacks")
    List<Feedback> feedbacksByPlaceId(@PathVariable Long id) {
        return feedbackRepository.findByPlaceId(id);
    }

}
