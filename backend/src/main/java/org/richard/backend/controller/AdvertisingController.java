package org.richard.backend.controller;

import lombok.RequiredArgsConstructor;
import org.richard.backend.dto.AdvertisingDTO;
import org.richard.backend.entity.Advertising;
import org.richard.backend.service.AdvertisingService;
import org.richard.backend.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/advertising")
public class AdvertisingController {

    private final AdvertisingService advertisingService;
//    private final GenericService<Advertising, Long> advertisingGenericService;


    @GetMapping
    public ResponseEntity<List<AdvertisingDTO>> getAllAdvertising() {
        var advertisingList = advertisingService.findAll();

        if (advertisingList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(advertisingList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisingDTO> getAdvertisingById(@PathVariable Long id) {
        return advertisingService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdvertisingDTO createAdvertising(@RequestBody AdvertisingDTO advertisingDTO) {
        return advertisingService.save(advertisingDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisingDTO> updateAdvertising(
            @PathVariable Long id,
            @RequestBody AdvertisingDTO advertisingDTO) {
        return ResponseEntity.ok(advertisingService.updateAdvertising(id, advertisingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertising(@PathVariable Long id) {
        advertisingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

