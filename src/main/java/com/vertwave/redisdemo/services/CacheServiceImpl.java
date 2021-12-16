package com.vertwave.redisdemo.services;

import com.vertwave.redisdemo.domain.model.CacheItem;
import com.vertwave.redisdemo.repositories.CacheItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheItemRepository repository;

    @Override
    public Optional<CacheItem> getCacheItem(String id) {
        return this.repository
                .findById(id);
    }

    @Override
    public Optional<CacheItem> setCacheItem(CacheItem item) {
        this.repository.save(item);
        return Optional.ofNullable(item);
    }
}
