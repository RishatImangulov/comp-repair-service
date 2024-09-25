package org.richard.backend.clientStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.richard.backend.entity.ClientStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientStatusMapper {

    public ClientStatusDTO toDto(ClientStatus clientStatus) {
        return ClientStatusDTO.builder()
                .id(clientStatus.getId())
                .title(clientStatus.getTitle())
                .description(clientStatus.getDescription())
                .build();
    }

    public ClientStatus toEntity(ClientStatusDTO clientStatusDto) {
        return ClientStatus.builder()
                .id(clientStatusDto.getId())
                .title(clientStatusDto.getTitle())
                .description(clientStatusDto.getDescription())
                .build();
    }
}
