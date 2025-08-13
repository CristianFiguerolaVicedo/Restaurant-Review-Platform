package com.cristian.restaurant.services;

import com.cristian.restaurant.domain.ReviewCreateUpdateRequest;
import com.cristian.restaurant.domain.entities.Review;
import com.cristian.restaurant.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);
    Page<Review> listReviews(String restaurantId, Pageable pageable);
}
