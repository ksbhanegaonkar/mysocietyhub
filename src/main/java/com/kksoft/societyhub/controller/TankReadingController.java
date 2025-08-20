package com.kksoft.societyhub.controller;

import com.kksoft.societyhub.entity.TankReadingEntity;
import com.kksoft.societyhub.model.TankReading;
import com.kksoft.societyhub.service.TankReadingService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/readings/excel")
    public ResponseEntity<byte[]> downloadExcel() {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Tank Readings");

            // Header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Tank ID");
            headerRow.createCell(2).setCellValue("Water Level");
            headerRow.createCell(3).setCellValue("Timestamp");

            // Fetch data
            List<TankReadingEntity> readings = service.getAllReadings();

            int rowIdx = 1;
            for (TankReadingEntity r : readings) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(r.getId());
                row.createCell(1).setCellValue(r.getTankId());
                row.createCell(2).setCellValue(r.getWaterLevel());
                row.createCell(3).setCellValue(r.getTimestamp().toString());
            }

            workbook.write(out);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=tank_readings.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(out.toByteArray());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
