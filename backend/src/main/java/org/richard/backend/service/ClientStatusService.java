package org.richard.backend.service;

import lombok.RequiredArgsConstructor;
import org.richard.backend.dto.ClientStatusDTO;
import org.richard.backend.dto.ClientStatusMapper;
import org.richard.backend.entity.ClientStatus;
import org.richard.backend.repository.ClientStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientStatusService {
    private final ClientStatusRepository clientStatusRepository;
    private final ClientStatusMapper clientStatusMapper;

    public List<ClientStatusDTO> findAll() {
        return clientStatusRepository.findAll().stream()
                .map(clientStatusMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ClientStatusDTO> findById(Long id) {
        return clientStatusRepository.findById(id)
                .map(clientStatusMapper::toDto);
    }

    public ClientStatusDTO save(ClientStatusDTO clientStatusDTO) {
        ClientStatus clientStatus = clientStatusMapper.toEntity(clientStatusDTO);
        ClientStatus savedClientStatus = clientStatusRepository.save(clientStatus);
        return clientStatusMapper.toDto(savedClientStatus);
    }

    public void deleteById(Long id) {
        clientStatusRepository.deleteById(id);
    }

    public ClientStatusDTO updateClientStatus(Long id, ClientStatusDTO clientStatusDTO) {
        return clientStatusRepository.findById(id).map((clientStatus) -> {

            clientStatus.setTitle(clientStatusDTO.getTitle());
            clientStatus.setDescription(clientStatusDTO.getDescription());

            ClientStatus updatedClientStatus = clientStatusRepository.save(clientStatus);

            return clientStatusMapper.toDto(updatedClientStatus);
        }).orElseThrow(() -> new RuntimeException("ClientStatus not found with id " + id));
    }
}
