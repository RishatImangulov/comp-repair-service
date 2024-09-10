package org.richard.backend.repository;

import org.richard.backend.entity.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisingRepository extends JpaRepository<Advertising, Long> {
}
