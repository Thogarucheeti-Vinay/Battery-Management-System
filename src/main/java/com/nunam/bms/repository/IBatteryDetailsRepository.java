package com.nunam.bms.repository;

import com.nunam.bms.dao.entity.BatteryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBatteryDetailsRepository extends JpaRepository<BatteryDetails, Long> {

    @Query(value = "select :attribute from battery_details where battery_id = :batteryId", nativeQuery = true)
    Object getSpecificBatteryAttributeByID(@Param("batteryId") Long batteryID, @Param("attribute") String attribute);
}
