package com.cristian.restaurant.services;

import com.cristian.restaurant.domain.GeoLocation;
import com.cristian.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
