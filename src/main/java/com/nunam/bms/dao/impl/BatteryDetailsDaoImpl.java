package com.nunam.bms.dao.impl;

import com.nunam.bms.dao.api.IBatteryDetailsDao;
import com.nunam.bms.dao.entity.BatteryDetails;
import com.nunam.bms.pojo.api.IBatteryDetails;
import com.nunam.bms.repository.IBatteryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatteryDetailsDaoImpl implements IBatteryDetailsDao {

    @Autowired
    private IBatteryDetailsRepository batteryDetailsRepository;

    @Override
    public Optional<BatteryDetails> getBatteryInfoByID(Long batteryID) {
        Optional<BatteryDetails> batteryDetails =  batteryDetailsRepository.findById(batteryID);
        if(batteryDetails.isPresent()){
            return batteryDetails;
        }
        return null;
    }

    @Override
    public Object getSpecificBatteryAttributeByID(Long batteryID, String attribute) {
        return batteryDetailsRepository.getSpecificBatteryAttributeByID(batteryID, attribute);
    }

    @Override
    public void saveBatteryDetails(IBatteryDetails batteryDetails) {
        BatteryDetails batteryData = (BatteryDetails) batteryDetails;
        batteryDetailsRepository.save(batteryData);
    }
}
