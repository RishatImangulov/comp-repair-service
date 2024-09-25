package org.richard.backend.advertising;

import org.richard.backend.entity.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisingRepository extends JpaRepository<Advertising, Long> {
}
