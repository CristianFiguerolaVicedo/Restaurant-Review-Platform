package com.cristian.restaurant.mappers;

import com.cristian.restaurant.domain.ReviewCreateUpdateRequest;
import com.cristian.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.cristian.restaurant.domain.dtos.ReviewDto;
import com.cristian.restaurant.domain.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {
    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);
}
