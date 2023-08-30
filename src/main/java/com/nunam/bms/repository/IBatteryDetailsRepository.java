package com.nunam.bms.repository;

import com.nunam.bms.dao.entity.BatteryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBatteryDetailsRepository extends JpaRepository<BatteryDetails, Long> {

    @Query(value = "select * from battery_details where battery_id = :battery_id", nativeQuery = true)
    List<BatteryDetails> getAllInfoById(@Param("battery_id") Long batteryID);
}
