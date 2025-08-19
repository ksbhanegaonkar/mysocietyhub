package com.kksoft.societyhub.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tank_readings")
public class TankReadingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tank_id", nullable = false)
    private String tankId;

    @Column(name = "water_level", nullable = false)
    private Double waterLevel;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    public TankReadingEntity() {}

    public TankReadingEntity(String tankId, Double waterLevel, LocalDateTime timestamp) {
        this.tankId = tankId;
        this.waterLevel = waterLevel;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

