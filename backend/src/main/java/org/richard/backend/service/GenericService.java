package org.richard.backend.service;

import lombok.RequiredArgsConstructor;
import org.richard.backend.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@Service
@RequiredArgsConstructor
public class GenericService<T, ID extends Serializable> {
    private final GenericRepository<T, ID> genericRepository;


}
