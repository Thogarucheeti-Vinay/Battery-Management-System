package com.nunam.bms.pojo.api;

public interface IBatteryDetails {

    Long getBatteryID();

    void setBatteryID(Long batteryID);

    Double getCurrent();

    void setCurrent(Double current);

    Double getVoltage();

    void setVoltage(Double voltage);

    Double getTemperature();

    void setTemperature(Double temperature);

    Long getTime();

    void setTime(Long time);

}
