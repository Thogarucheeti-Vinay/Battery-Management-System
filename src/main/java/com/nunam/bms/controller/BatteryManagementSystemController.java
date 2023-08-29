package com.nunam.bms.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nunam.bms.constants.APIConstants;
import com.nunam.bms.pojo.api.IBatteryDetails;
import com.nunam.bms.pojo.impl.APIResponse;
import com.nunam.bms.service.api.IBatteryDetailsService;
import com.nunam.bms.service.impl.APIResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BatteryManagementSystemController {

    @Autowired
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private APIResponseService apiResponseService;

    @Autowired
    private IBatteryDetailsService batteryDetailsService;

    @PostMapping(APIConstants.SAVE_BATTERY_DATA)
    public APIResponse saveBatteryDetails(@RequestBody Map<String, Object> batteryDetailsMap) throws IOException {
        IBatteryDetails batteryDetails = OBJECT_MAPPER.readValue(batteryDetailsMap.toString(), IBatteryDetails.class);
        batteryDetailsService.saveBatteryDetails(batteryDetails);
    }

    @GetMapping(APIConstants.GET_BATTERY_INFO_BY_ID)
    public APIResponse getBatteryInfoByID(@PathVariable Long batteryID){

        try {
            if(batteryID == null || batteryID <=0){
                throw new Exception("Invalid params received!");
            }
            IBatteryDetails batteryDetails = batteryDetailsService.getBatteryInfoByID(batteryID);
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

        try {
            if(batteryID == null || batteryID <=0 || attribute == null || attribute.isEmpty()){
                throw new Exception("Invalid params received!");
            }
            Object attributeValue = batteryDetailsService.getSpecificBatteryAttributeByID(batteryID, attribute);
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
}
