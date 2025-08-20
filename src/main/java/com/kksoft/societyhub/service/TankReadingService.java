package com.kksoft.societyhub.service;

import com.kksoft.societyhub.entity.TankReadingEntity;
import com.kksoft.societyhub.model.TankReading;
import com.kksoft.societyhub.repository.TankReadingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TankReadingService {

    private final TankReadingRepository repository;

    @Autowired
    public TankReadingService(TankReadingRepository repository) {
        this.repository = repository;
    }

    public TankReadingEntity saveReading(TankReading reading) {
        var readingEntity = new TankReadingEntity();
        readingEntity.setTankId(reading.getTankId());
        readingEntity.setWaterLevel(reading.getWaterLevel());
        readingEntity.setTimestamp(LocalDateTime.now());
        return repository.save(readingEntity);
    }

    public List<TankReadingEntity> getAllReadings() {
        return repository.findAll();
    }
}
