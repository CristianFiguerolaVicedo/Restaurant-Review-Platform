package com.cristian.restaurant.services;

import com.cristian.restaurant.domain.RestaurantCreateUpdateRequest;
import com.cristian.restaurant.domain.entities.Review;
import com.cristian.restaurant.domain.entities.User;

public interface ReviewService {
    Review createReview(User author, String restaurantId, RestaurantCreateUpdateRequest review);
}
