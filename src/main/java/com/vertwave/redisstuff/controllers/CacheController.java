package com.vertwave.redisstuff.controllers;

import com.vertwave.redisstuff.domain.model.CacheItem;
import com.vertwave.redisstuff.repositories.CacheItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/cache")
public class CacheController {

    private final CacheItemRepository repository;

    @PostMapping("setCacheItem")
    public ResponseEntity<CacheItem> setCacheItem(@RequestBody CacheItem item) {
        item.setId(UUID.randomUUID());
        item.setCreatedDate(new Date());
        repository.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("getCacheItem/{id}")
    public ResponseEntity<CacheItem> getCacheItem(@PathVariable String id) {
        return this.repository
                .findById(UUID.fromString(id))
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
