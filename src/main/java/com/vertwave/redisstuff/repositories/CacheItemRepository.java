package com.vertwave.redisstuff.repositories;

import com.vertwave.redisstuff.domain.model.CacheItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CacheItemRepository extends CrudRepository<CacheItem, UUID> {
}
