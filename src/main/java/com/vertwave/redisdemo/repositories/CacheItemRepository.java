package com.vertwave.redisdemo.repositories;

import com.vertwave.redisdemo.domain.model.CacheItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CacheItemRepository extends CrudRepository<CacheItem, String> {
}
