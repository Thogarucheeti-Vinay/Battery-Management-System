package com.nunam.bms.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nunam.bms.dao.api.IBatteryDetailsDao;
import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.pojo.api.IBatteryDetails;
import com.nunam.bms.pojo.impl.BatteryDetailsImpl;
import com.nunam.bms.service.api.IBatteryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatteryDetailsServiceImpl implements IBatteryDetailsService {

    @Autowired
    private IBatteryDetailsDao batteryDetailsDao;

    @Autowired
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public IBatteryDetails getBatteryInfoByID(Long batteryID) throws JsonProcessingException {

        BatteryDetails batteryDetails = batteryDetailsDao.getBatteryInfoByID(batteryID).get();
        String batteryDetailsString = batteryDetails.toString();

        IBatteryDetails batteryDetailsOfID = objectMapper.readValue(batteryDetailsString, BatteryDetailsImpl.class);
        return batteryDetailsOfID;
    }

    @Override
    public Object getSpecificBatteryAttributeByID(Long batteryID, String attribute) {

        return batteryDetailsDao.getSpecificBatteryAttributeByID(batteryID, attribute);
    }

    @Override
    public void saveBatteryDetails(IBatteryDetails batteryDetails) {
        batteryDetailsDao.saveBatteryDetails(batteryDetails);
    }
}
