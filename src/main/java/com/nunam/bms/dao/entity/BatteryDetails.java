package com.nunam.bms.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "battery_details")
public class BatteryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "battery_id")
    private Long batteryID;

    @Column(name = "current")
    private Double current;

    @Column(name = "voltage")
    private Double voltage;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "time")
    private Long time;

    public Long getBatteryID() {
        return batteryID;
    }

    public void setBatteryID(Long batteryID) {
        this.batteryID = batteryID;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public BatteryDetails() {
    }

    public BatteryDetails(Long batteryID, Double current, Double voltage, Double temperature, Long time) {
        this.batteryID = batteryID;
        this.current = current;
        this.voltage = voltage;
        this.temperature = temperature;
        this.time = time;
    }
}
