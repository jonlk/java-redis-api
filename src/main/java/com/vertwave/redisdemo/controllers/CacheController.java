package com.vertwave.redisdemo.controllers;

import com.vertwave.redisdemo.domain.model.CacheItem;
import com.vertwave.redisdemo.services.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/cache")
public class CacheController {

    private final CacheService cacheService;

    @PostMapping("setCacheItem")
    public ResponseEntity<CacheItem> setCacheItem(@RequestBody CacheItem item) {
        return this.cacheService
                .setCacheItem(item)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @GetMapping("getCacheItem/{id}")
    public ResponseEntity<CacheItem> getCacheItem(@PathVariable String id) {
        return this.cacheService
                .getCacheItem(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
