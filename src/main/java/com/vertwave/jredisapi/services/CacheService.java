package com.vertwave.jredisapi.services;

import com.vertwave.jredisapi.domain.model.CacheItem;

import java.util.Optional;

public interface CacheService {
    Optional<CacheItem> getCacheItem(String id);

    Optional<CacheItem> setCacheItem(CacheItem item);
}
