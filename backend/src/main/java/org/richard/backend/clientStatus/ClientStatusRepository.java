package org.richard.backend.clientStatus;

import org.richard.backend.entity.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {

}
