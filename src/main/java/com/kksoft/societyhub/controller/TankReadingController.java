package com.kksoft.societyhub.controller;

import com.kksoft.societyhub.entity.TankReadingEntity;
import com.kksoft.societyhub.model.TankReading;
import com.kksoft.societyhub.service.TankReadingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tank")
public class TankReadingController {

    private final TankReadingService service;

    @Autowired
    public TankReadingController(TankReadingService service) {
        this.service = service;
    }

    @PostMapping("/reading")
    public TankReadingEntity saveReading(@RequestBody TankReading reading) {
        return service.saveReading(reading);
    }
}
