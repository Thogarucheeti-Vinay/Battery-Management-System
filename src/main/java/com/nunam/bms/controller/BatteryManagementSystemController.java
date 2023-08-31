package com.nunam.bms.controller;

import com.nunam.bms.constants.APIConstants;
import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.pojo.APIResponse;
import com.nunam.bms.service.api.IBatteryDetailsService;
import com.nunam.bms.service.impl.APIResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BatteryManagementSystemController {

    private static final Logger LOGGER = LogManager.getLogger(BatteryManagementSystemController.class);

    @Autowired
    private APIResponseService apiResponseService;

    @Autowired
    private IBatteryDetailsService batteryDetailsService;

    @PostMapping(APIConstants.SAVE_BATTERY_DATA)
    public APIResponse saveBatteryDetails(@RequestBody BatteryDetails batteryDetails) {
        LOGGER.debug("BatteryManagementSystemController :: saveBatteryDetails :: batteryDetails : {}", batteryDetails);

        if (batteryDetails != null) {
            batteryDetailsService.saveBatteryDetails(batteryDetails);
            return apiResponseService.buildAPIResponse(HttpStatus.OK, "Battery data saved");
        }
        return apiResponseService.buildAPIResponse(HttpStatus.OK, "Battery data not found");
    }

    @GetMapping(APIConstants.GET_BATTERY_INFO_BY_ID)
    public APIResponse getBatteryInfoByID(@PathVariable Long batteryID){
        LOGGER.debug("BatteryManagementSystemController :: getBatteryInfoByID :: batteryID : {}", batteryID);

        try {
            if(batteryID == null || batteryID <=0){
                return apiResponseService.buildAPIResponse(HttpStatus.OK, "Invalid batteryID") ;
            }
            List<BatteryDetails> batteryDetails = batteryDetailsService.getBatteryInfoByID(batteryID);
            if(batteryDetails == null){
                return apiResponseService.buildAPIResponse(HttpStatus.NOT_FOUND, "batteryDetails are not found");
            }else {
                return apiResponseService.buildAPIResponse(HttpStatus.OK, batteryDetails);
            }
        } catch (Exception e){
            e.printStackTrace();
            return apiResponseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(APIConstants.GET_SPECIFIC_BATTERY_ATTRIBUTE_BY_ID)
    public APIResponse getSpecificBatteryAttributeByID(@PathVariable Long batteryID, @PathVariable String attribute){
        LOGGER.debug("BatteryManagementSystemController :: getSpecificBatteryAttributeByID :: batteryID : {}, attribute : {}",batteryID, attribute);

        try {
            if(batteryID == null || batteryID <=0 || attribute == null || attribute.isEmpty()){
                return apiResponseService.buildAPIResponse(HttpStatus.OK, "Invalid batteryID or attribute") ;
            }
            List<Object> attributeValue = batteryDetailsService.getSpecificBatteryAttributeByID(batteryID, attribute);
            if(attributeValue == null){
                return apiResponseService.buildAPIResponse(HttpStatus.NOT_FOUND, "batteryDetails are not found");
            }else {
                return apiResponseService.buildAPIResponse(HttpStatus.OK, attributeValue);
            }
        } catch (Exception e){
            e.printStackTrace();
            return apiResponseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(APIConstants.GET_SPECIFIC_BATTERY_ATTRIBUTE_BY_TIME)
    public APIResponse getSpecificBatteryAttributeByTime(@PathVariable Long batteryID, @PathVariable String attribute, @PathVariable Long startTime, @PathVariable Long endTime){
        LOGGER.debug("BatteryManagementSystemController :: getSpecificBatteryAttributeByTime :: batteryID : {}, attribute : {}, startTime : {}, endTime : {}",batteryID, attribute, startTime, endTime);

        try {
            if(batteryID == null || batteryID <=0 || attribute == null || attribute.isEmpty()){
                return apiResponseService.buildAPIResponse(HttpStatus.OK, "Invalid batteryID or attribute") ;
            }
            if(startTime == null || endTime == null || startTime > endTime) {
                return apiResponseService.buildAPIResponse(HttpStatus.OK, "Invalid start or end time") ;
            }
            List<Object> attributeValues = batteryDetailsService.getSpecificBatteryAttributeByTime(batteryID, attribute, startTime, endTime);
            if(attributeValues == null || attributeValues.isEmpty()){
                return apiResponseService.buildAPIResponse(HttpStatus.NOT_FOUND, "batteryDetails are not found");
            }else {
                return apiResponseService.buildAPIResponse(HttpStatus.OK, attributeValues);
            }
        } catch (Exception e){
            e.printStackTrace();
            return apiResponseService.buildAPIResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
