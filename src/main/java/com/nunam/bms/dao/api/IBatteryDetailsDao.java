package com.nunam.bms.dao.api;

import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.pojo.api.IBatteryDetails;

import java.util.Optional;

public interface IBatteryDetailsDao {

    Optional<BatteryDetails> getBatteryInfoByID(Long batteryID);

    Object getSpecificBatteryAttributeByID(Long batteryID, String attribute);

    void saveBatteryDetails(IBatteryDetails batteryDetails);
}
