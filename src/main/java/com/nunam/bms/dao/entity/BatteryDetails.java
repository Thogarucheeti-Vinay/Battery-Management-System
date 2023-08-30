package com.nunam.bms.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "battery_details")
public class BatteryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("battery_id")
    @Column(name = "battery_id")
    private Long batteryID;

    @JsonProperty("current")
    @Column(name = "current")
    private Double current;

    @JsonProperty("voltage")
    @Column(name = "voltage")
    private Double voltage;

    @JsonProperty("temp")
    @Column(name = "temperature")
    private Double temperature;

    @JsonProperty("time")
    @Column(name = "time")
    private Long time;

    public BatteryDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BatteryDetails(Long batteryID, Double current, Double voltage, Double temperature, Long time) {
        this.batteryID = batteryID;
        this.current = current;
        this.voltage = voltage;
        this.temperature = temperature;
        this.time = time;
    }
}
