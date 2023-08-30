package com.nunam.bms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nunam.bms.controller.BatteryManagementSystemController;
import com.nunam.bms.dao.api.BatteryDetailsDao;
import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.service.api.IBatteryDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryDetailsServiceImpl implements IBatteryDetailsService {

    private static final Logger LOGGER = LogManager.getLogger(BatteryManagementSystemController.class);

    @Autowired
    private BatteryDetailsDao batteryDetailsDao;

    @Autowired
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BatteryDetails> getBatteryInfoByID(Long batteryID) {
        LOGGER.debug("BatteryDetailsServiceImpl :: getBatteryInfoByID :: batteryID : {}", batteryID);

        List<BatteryDetails> batteryDetailsList = batteryDetailsDao.getBatteryInfoByID(batteryID);
        return batteryDetailsList;
    }

    @Override
    public List<Object> getSpecificBatteryAttributeByID(Long batteryID, String attribute) throws Exception {
        LOGGER.debug("BatteryDetailsServiceImpl :: getSpecificBatteryAttributeByTime :: batteryID : {}," +
                " attribute : {}", batteryID, attribute);
        return batteryDetailsDao.getSpecificBatteryAttributeByID(batteryID, attribute);
    }

    @Override
    public List<Object> getSpecificBatteryAttributeByTime(Long batteryID, String attribute, Long startTime, Long endTime) throws Exception {
        LOGGER.debug("BatteryDetailsServiceImpl :: getSpecificBatteryAttributeByTime :: batteryID : {}," +
                " attribute : {}, startTime : {}, endTime : {}", batteryID, attribute, startTime, endTime);
        return batteryDetailsDao.getSpecificBatteryAttributeByTime(batteryID, attribute, startTime, endTime);
    }

    @Override
    public void saveBatteryDetails(BatteryDetails batteryDetails) {
        LOGGER.debug("BatteryDetailsServiceImpl :: saveBatteryDetails :: batteryDetails : {}", batteryDetails);
        batteryDetailsDao.saveBatteryDetails(batteryDetails);
    }
}
