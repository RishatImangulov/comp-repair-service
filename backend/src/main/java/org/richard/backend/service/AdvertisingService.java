package org.richard.backend.service;

import lombok.RequiredArgsConstructor;
import org.richard.backend.dto.AdvertisingDTO;
import org.richard.backend.dto.AdvertisingMapper;
import org.richard.backend.entity.Advertising;
import org.richard.backend.entity.Advertising;
import org.richard.backend.repository.AdvertisingRepository;
import org.richard.backend.repository.ClientStatusRepository;
import org.richard.backend.repository.AdvertisingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdvertisingService {
    private final AdvertisingRepository advertisingRepository;
    private final AdvertisingMapper advertisingMapper;

    public List<AdvertisingDTO> findAll() {
        return advertisingRepository.findAll().stream()
                .map(advertisingMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AdvertisingDTO> findById(Long id) {
        return advertisingRepository.findById(id)
                .map(advertisingMapper::toDto);
    }

    public AdvertisingDTO save(AdvertisingDTO advertisingDTO) {
        Advertising advertising = advertisingMapper.toEntity(advertisingDTO);
        Advertising savedAdvertising = advertisingRepository.save(advertising);
        return advertisingMapper.toDto(savedAdvertising);
    }

    public void deleteById(Long id) {
        advertisingRepository.deleteById(id);
    }

    public AdvertisingDTO updateAdvertising(Long id, AdvertisingDTO advertisingDTO) {
        return advertisingRepository.findById(id).map((advertising) -> {

            advertising.setTitle(advertisingDTO.getTitle());
            advertising.setDescription(advertisingDTO.getDescription());

            Advertising updatedAdvertising = advertisingRepository.save(advertising);

            return advertisingMapper.toDto(updatedAdvertising);
        }).orElseThrow(() -> new RuntimeException("Advertising not found with id " + id));
    }
}
