package org.richard.backend.clientStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/client-status")
public class ClientStatusController {

    private final ClientStatusService clientStatusService;

    @GetMapping
    public List<ClientStatusDTO> getAllClientStatuss() {
        return clientStatusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientStatusDTO> getClientStatusById(@PathVariable Long id) {
        return clientStatusService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientStatusDTO createClientStatus(@RequestBody ClientStatusDTO clientStatusDTO) {
        return clientStatusService.save(clientStatusDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientStatusDTO> updateClientStatus(
            @PathVariable Long id,
            @RequestBody ClientStatusDTO clientStatusDTO) {
        return ResponseEntity.ok(clientStatusService.updateClientStatus(id, clientStatusDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientStatus(@PathVariable Long id) {
        clientStatusService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

