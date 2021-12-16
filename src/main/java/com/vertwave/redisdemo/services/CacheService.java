package com.vertwave.redisdemo.services;

import com.vertwave.redisdemo.domain.model.CacheItem;

import java.util.Optional;

public interface CacheService {
    Optional<CacheItem> getCacheItem(String id);

    Optional<CacheItem> setCacheItem(CacheItem item);
}
