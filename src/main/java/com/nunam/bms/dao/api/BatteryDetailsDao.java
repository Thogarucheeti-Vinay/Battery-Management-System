package com.nunam.bms.dao.api;

import com.nunam.bms.dao.entity.BatteryDetails;

import java.util.List;

public interface BatteryDetailsDao {

    List<BatteryDetails> getBatteryInfoByID(Long batteryID);

    List<Object> getSpecificBatteryAttributeByID(Long batteryID, String attribute) throws Exception;

    void saveBatteryDetails(BatteryDetails batteryDetails);

    List<Object> getSpecificBatteryAttributeByTime(Long batteryID, String attribute, Long startTime, Long endTime) throws Exception;
}
