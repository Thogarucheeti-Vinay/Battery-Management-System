package com.nunam.bms.service.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nunam.bms.dao.entity.BatteryDetails;

import java.util.List;

public interface IBatteryDetailsService {

    List<BatteryDetails> getBatteryInfoByID(Long batteryID) throws JsonProcessingException;

    List<Object> getSpecificBatteryAttributeByID(Long batteryID, String attribute) throws Exception;

    List<Object> getSpecificBatteryAttributeByTime(Long batteryID, String attribute, Long startTime, Long endTime) throws Exception;

    void saveBatteryDetails(BatteryDetails batteryDetails);
}
