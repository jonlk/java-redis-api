package com.vertwave.jredisapi.controllers;

import com.vertwave.jredisapi.domain.model.CacheItem;
import com.vertwave.jredisapi.services.CacheService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cache")
public class CacheController {

    private final CacheService cacheService;

    @PostMapping("set")
    public ResponseEntity<CacheItem> setCacheItem(@RequestBody CacheItem item) {
        return this.cacheService
                .setCacheItem(item)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CacheItem> getCacheItem(@PathVariable String id) {
        return this.cacheService
                .getCacheItem(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("all")
    public ResponseEntity<List<CacheItem>> getAllCacheItems() {
        return new ResponseEntity<>(this.cacheService
                .getAllCacheItems(), HttpStatus.OK);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCacheItem(@PathVariable String id) {
        this.cacheService.deleteCacheItem(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
