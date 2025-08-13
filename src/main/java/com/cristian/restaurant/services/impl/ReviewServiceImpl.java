package com.cristian.restaurant.services.impl;

import com.cristian.restaurant.domain.ReviewCreateUpdateRequest;
import com.cristian.restaurant.domain.entities.Photo;
import com.cristian.restaurant.domain.entities.Restaurant;
import com.cristian.restaurant.domain.entities.Review;
import com.cristian.restaurant.domain.entities.User;
import com.cristian.restaurant.exceptions.RestaurantNotFoundException;
import com.cristian.restaurant.exceptions.ReviewNotAllowedException;
import com.cristian.restaurant.repositories.RestaurantRepository;
import com.cristian.restaurant.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review) {
        Restaurant restaurant = getRestaurantOrThrow(restaurantId);

        boolean hasExistingReviews = restaurant.getReviews().stream()
                .anyMatch(r -> r.getWrittenBy().getId().equals(author.getId()));

        if (hasExistingReviews) {
            throw new ReviewNotAllowedException("User has already reviewed this restaurant");
        }

        List<Photo> photos = review.getPhotoIds().stream().map(url -> {
            return Photo.builder()
                    .url(url)
                    .uploadDate(LocalDateTime.now())
                    .build();
        }).toList();

        String reviewId = UUID.randomUUID().toString();

        Review reviewToCreate = Review.builder()
                .id(reviewId)
                .content(review.getContent())
                .rating(review.getStarRating())
                .photos(photos)
                .datePosted(LocalDateTime.now())
                .lastEdited(LocalDateTime.now())
                .writtenBy(author)
                .build();

        restaurant.getReviews().add(reviewToCreate);

        updateRestaurantAverageRating(restaurant);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return savedRestaurant.getReviews().stream()
                .filter(r -> reviewId.equals(r.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error retrieving created review"));
    }

    private Restaurant getRestaurantOrThrow(String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with Id not found: " + restaurantId)
                );
    }

    private void updateRestaurantAverageRating(Restaurant restaurant) {
        List<Review> reviews = restaurant.getReviews();
        if (reviews.isEmpty()) {
            restaurant.setAverageRating(0.0f);
        } else {
            double averageRating = reviews.stream().mapToDouble(Review::getRating)
                    .average()
                    .orElse(0.0);
            restaurant.setAverageRating((float) averageRating);
        }
    }
}
