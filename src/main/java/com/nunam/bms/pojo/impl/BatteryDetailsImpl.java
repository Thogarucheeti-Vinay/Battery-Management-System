package com.nunam.bms.pojo.impl;

import com.nunam.bms.pojo.api.IBatteryDetails;

public class BatteryDetailsImpl implements IBatteryDetails {

    private Long batteryID;

    private Double current;

    private Double voltage;

    private Double temperature;

    private Long time;

    @Override
    public Long getBatteryID() {
        return batteryID;
    }

    @Override
    public void setBatteryID(Long batteryID) {
        this.batteryID = batteryID;
    }

    @Override
    public Double getCurrent() {
        return current;
    }

    @Override
    public void setCurrent(Double current) {
        this.current = current;
    }

    @Override
    public Double getVoltage() {
        return voltage;
    }

    @Override
    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    @Override
    public Double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public Long getTime() {
        return time;
    }

    @Override
    public void setTime(Long time) {
        this.time = time;
    }
}
