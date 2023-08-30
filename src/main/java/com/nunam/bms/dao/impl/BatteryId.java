package com.nunam.bms.dao.impl;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BatteryId implements Serializable {
    private Long batteryId;
    private Long time;

    public BatteryId() {
    }

    public BatteryId(Long batteryId, Long time) {
        this.batteryId = batteryId;
        this.time = time;
    }

    public Long getBatteryId() {
        return batteryId;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatteryId batteryId1 = (BatteryId) o;
        return Objects.equals(batteryId, batteryId1.batteryId) && Objects.equals(time, batteryId1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryId, time);
    }
}
