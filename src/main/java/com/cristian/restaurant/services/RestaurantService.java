package com.cristian.restaurant.services;

import com.cristian.restaurant.domain.RestaurantCreateUpdateRequest;
import com.cristian.restaurant.domain.entities.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreateUpdateRequest request);
}
