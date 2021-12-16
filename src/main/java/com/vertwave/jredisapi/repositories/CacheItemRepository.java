package com.vertwave.jredisapi.repositories;

import com.vertwave.jredisapi.domain.model.CacheItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheItemRepository extends CrudRepository<CacheItem, String> {
}
