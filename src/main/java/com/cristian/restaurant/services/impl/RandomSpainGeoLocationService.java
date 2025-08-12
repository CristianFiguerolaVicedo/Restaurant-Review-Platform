package com.cristian.restaurant.services.impl;

import com.cristian.restaurant.domain.GeoLocation;
import com.cristian.restaurant.domain.entities.Address;
import com.cristian.restaurant.services.GeoLocationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomSpainGeoLocationService implements GeoLocationService {

    private static final float MIN_LATITUDE = 36.00f;
    private static final float MAX_LATITUDE = 43.79f;
    private final static float MIN_LONGITUDE = -9.30f;
    private final static float MAX_LONGITUDE = 3.33f;

    @Override
    public GeoLocation geoLocate(Address address) {
        Random random = new Random();
        double latitude = MIN_LATITUDE + random.nextDouble() * (MAX_LATITUDE-MIN_LATITUDE);
        double longitude = MIN_LONGITUDE + random.nextDouble() * (MAX_LONGITUDE-MIN_LONGITUDE);

        return GeoLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
