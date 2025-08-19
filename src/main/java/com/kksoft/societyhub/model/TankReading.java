package com.kksoft.societyhub.model;

import jakarta.persistence.Column;

public class TankReading {
    private String tankId;
    private Double waterLevel;

    public TankReading() {
    }

    public TankReading(String tankId, Double waterLevel) {
        this.tankId = tankId;
        this.waterLevel = waterLevel;
    }

    public String getTankId() {
        return tankId;
    }

    public void setTankId(String tankId) {
        this.tankId = tankId;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }
}
