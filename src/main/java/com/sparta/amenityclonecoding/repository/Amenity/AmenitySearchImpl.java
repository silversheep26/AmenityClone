package com.sparta.amenityclonecoding.repository.Amenity;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.sparta.amenityclonecoding.dto.AmenityRequestDto;
import com.sparta.amenityclonecoding.entity.Amenity;
import com.sparta.amenityclonecoding.entity.QAmenity;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class AmenitySearchImpl extends QuerydslRepositorySupport implements AmenitySearch {
    public AmenitySearchImpl() {
        super(Amenity.class);
    }

    @Override
    public List<Amenity> searchFilter(AmenityRequestDto amenityRequestDto) {
        QAmenity amenity = QAmenity.amenity;
        JPQLQuery<Amenity> query = from(amenity);

        query.where(amenity.amenityType.eq(amenityRequestDto.getAmenityType()));

        String amenityCommon = String.join(", ", amenityRequestDto.getAmenityCommon());
        String amenityIn = String.join(", ", amenityRequestDto.getAmenityIn());
        String amenityEtc = String.join(", ", amenityRequestDto.getAmenityEtc());

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(amenity.amenityLocation.contains(amenityRequestDto.getAmenityLocation()));
        booleanBuilder.or(amenity.amenityDetailLocation.contains(amenityRequestDto.getAmenityDetailLocation()));
        booleanBuilder.or(amenity.amenityCategory.contains(amenityRequestDto.getAmenityCategory()));
        booleanBuilder.or(amenity.amenityPeople.contains(amenityRequestDto.getAmenityPeople()));
        booleanBuilder.or(amenity.amenityVal.contains(amenityRequestDto.getAmenityVal()));
        booleanBuilder.or(amenity.amenityCommon.contains(amenityCommon));
        booleanBuilder.or(amenity.amenityIn.contains(amenityIn));
        booleanBuilder.or(amenity.amenityEtc.contains(amenityEtc));
        query.where(booleanBuilder);

        return query.fetch();
    }
}
