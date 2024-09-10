package org.richard.backend.dto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.richard.backend.entity.Advertising;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdvertisingMapper {

    public AdvertisingDTO toDto(Advertising advertising) {
        return AdvertisingDTO.builder()
                .id(advertising.getId())
                .title(advertising.getTitle())
                .description(advertising.getDescription())
                .build();
    }

    public Advertising toEntity(AdvertisingDTO advertisingDto) {
        return Advertising.builder()
                .id(advertisingDto.getId())
                .title(advertisingDto.getTitle())
                .description(advertisingDto.getDescription())
                .build();
    }
}
