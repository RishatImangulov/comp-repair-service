package org.richard.backend.repository;

import org.richard.backend.entity.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {

}
