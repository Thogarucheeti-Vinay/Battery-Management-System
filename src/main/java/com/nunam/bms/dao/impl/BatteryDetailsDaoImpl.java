package com.nunam.bms.dao.impl;

import com.nunam.bms.controller.BatteryManagementSystemController;
import com.nunam.bms.dao.api.BatteryDetailsDao;
import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.repository.IBatteryDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.nunam.bms.constants.BatteryConstants.CURRENT;
import static com.nunam.bms.constants.BatteryConstants.TEMPERATURE;
import static com.nunam.bms.constants.BatteryConstants.TIME;
import static com.nunam.bms.constants.BatteryConstants.VOLTAGE;

@Service
public class BatteryDetailsDaoImpl implements BatteryDetailsDao {

    private static final Logger LOGGER = LogManager.getLogger(BatteryManagementSystemController.class);

    @Autowired
    private IBatteryDetailsRepository batteryDetailsRepository;

    @Override
    public List<BatteryDetails> getBatteryInfoByID(Long batteryID) {
        LOGGER.debug("BatteryDetailsDaoImpl :: getBatteryInfoByID :: batteryID : {}", batteryID);

        List<BatteryDetails> batteryDetailsList =  batteryDetailsRepository.getAllInfoById(batteryID);
        if(!batteryDetailsList.isEmpty()){
            return batteryDetailsList;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Object> getSpecificBatteryAttributeByID(Long batteryID, String attribute) throws Exception {
        LOGGER.debug("BatteryDetailsDaoImpl :: getSpecificBatteryAttributeByID :: batteryID : {}," +
                " attribute : {}", batteryID, attribute);

        List<Object> attributeList = new ArrayList<>();
        List<BatteryDetails> batteryDetailsList = batteryDetailsRepository.getAllInfoById(batteryID);
        if (!batteryDetailsList.isEmpty()) {
            for (BatteryDetails batteryDetails : batteryDetailsList) {
                if (attribute.equalsIgnoreCase(TEMPERATURE)) {
                    attributeList.add(batteryDetails.getTemperature());
                } else if (attribute.equalsIgnoreCase(VOLTAGE)) {
                    attributeList.add(batteryDetails.getVoltage());
                } else if (attribute.equalsIgnoreCase(CURRENT)) {
                    attributeList.add(batteryDetails.getCurrent());
                } else if (attribute.equalsIgnoreCase(TIME)) {
                    attributeList.add(batteryDetails.getTime());
                } else {
                    throw new Exception("Invalid attribute!!");
                }
            }
        }
        return attributeList;
    }

    @Override
    public List<Object> getSpecificBatteryAttributeByTime(Long batteryID, String attribute, Long startTime, Long endTime) throws Exception {
        LOGGER.debug("BatteryDetailsDaoImpl :: getSpecificBatteryAttributeByTime :: batteryID : {}," +
                " attribute : {}, startTime : {}, endTime : {}", batteryID, attribute, startTime, endTime);

        List<Object> attributeList = new ArrayList<>();
        List<BatteryDetails> batteryDetailsList = batteryDetailsRepository.getAllInfoById(batteryID);
        if (!batteryDetailsList.isEmpty()) {
            for (BatteryDetails batteryDetails : batteryDetailsList) {
                if (attribute.equalsIgnoreCase(TEMPERATURE)
                        && (startTime <= batteryDetails.getTime() || endTime >= batteryDetails.getTime())) {

                    attributeList.add(batteryDetails.getTemperature());
                } else if (attribute.equalsIgnoreCase(VOLTAGE)
                        && (startTime <= batteryDetails.getTime() || endTime >= batteryDetails.getTime())) {

                    attributeList.add(batteryDetails.getVoltage());
                } else if (attribute.equalsIgnoreCase(CURRENT)
                        && (startTime <= batteryDetails.getTime() || endTime >= batteryDetails.getTime())) {

                    attributeList.add(batteryDetails.getCurrent());
                } else if (attribute.equalsIgnoreCase(TIME)
                        && (startTime <= batteryDetails.getTime() || endTime >= batteryDetails.getTime())) {

                    attributeList.add(batteryDetails.getTime());
                } else {
                    throw new Exception("Invalid attribute!!");
                }
            }
        }
        return attributeList;
    }

    @Override
    public void saveBatteryDetails(BatteryDetails batteryDetails) {
        LOGGER.debug("BatteryDetailsDaoImpl :: saveBatteryDetails :: batteryDetails : {}", batteryDetails);

        batteryDetailsRepository.save(batteryDetails);
    }

}
