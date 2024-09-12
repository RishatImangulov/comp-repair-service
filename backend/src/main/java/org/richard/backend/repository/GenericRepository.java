package org.richard.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
