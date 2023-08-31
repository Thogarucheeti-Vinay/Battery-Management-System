package com.nunam.bms.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "battery_details")
public class BatteryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("battery_id")
    @Column(name = "battery_id")
    private String batteryID;

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
    private Timestamp time;

    public BatteryDetails() {
    }

    public Long getId() {
        return id;
    }

    public String getBatteryID() {
        return batteryID;
    }

    public Double getCurrent() {
        return current;
    }

    public Double getVoltage() {
        return voltage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Timestamp getTime() {
        return time;
    }

    public BatteryDetails(String batteryID, Double current, Double voltage, Double temperature, Timestamp time) {
        this.batteryID = batteryID;
        this.current = current;
        this.voltage = voltage;
        this.temperature = temperature;
        this.time = time;
    }
}
