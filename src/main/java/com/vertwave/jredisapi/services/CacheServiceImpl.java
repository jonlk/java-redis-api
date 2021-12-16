package com.vertwave.jredisapi.services;

import com.vertwave.jredisapi.domain.model.CacheItem;
import com.vertwave.jredisapi.repositories.CacheItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<CacheItem> getAllCacheItems() {
        List<CacheItem> cacheItems = new ArrayList<>();
        this.repository
                .findAll()
                .forEach(cacheItems::add);
        return cacheItems;
    }

    @Override
    public void deleteCacheItem(String id) {
        this.repository.deleteById(id);
    }
}
