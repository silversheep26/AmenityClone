package com.sparta.amenityclonecoding.repository;

import com.sparta.amenityclonecoding.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    Amenity findAmenityByAmenityId(Long amenityId);
    List<Amenity> findAmenityByAmenityCategory(String amenityCategory);
    List<Amenity> findAmenityByAmenityTypeAndAmenityLocationAndAmenityDetailLocation(Long amenityType, String Location, String LocationDetail );

    String findQry = "select a from TB_AMENITY a where a.amenityType = :amenityType " +
                            " and a.amenityLocation = :amenityLocation" +
                            " and a.amenityDetailLocation = :amenityDetailLocation" +
                            " and a.amenityCategory = :amenityCategory" +
                            " and a.amenityPeople = :amenityPeople" +
                            " and a.amenityVal = :amenityVal" +
                            " and a.amenityPeople = :amenityPeople" +
                            " and a.amenityCommon = :amenityCommon" +
                            " and a.amenityIn = :amenityIn" +
                            " and a.amenityEtc = :amenityEtc";
    @Query(value = findQry)
    List<Amenity> searchFilter(@Param("amenityType") Long amenityType, @Param("amenityLocation") String amenityLocation,
                               @Param("amenityDetailLocation") String amenityDetailLocation, @Param("amenityCategory") String amenityCategory,
                               @Param("amenityPeople") String amenityPeople, @Param("amenityVal") String amenityVal,
                               @Param("amenityCommon") String amenityCommon, @Param("amenityIn") String amenityIn,
                               @Param("amenityEtc") String amenityEtc);

}
