package com.nunam.bms.service.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nunam.bms.pojo.api.IBatteryDetails;

public interface IBatteryDetailsService {

    IBatteryDetails getBatteryInfoByID(Long batteryID) throws JsonProcessingException;

    Object getSpecificBatteryAttributeByID(Long batteryID, String attribute);

    void saveBatteryDetails(IBatteryDetails batteryDetails);
}
