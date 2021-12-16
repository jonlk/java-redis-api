package com.vertwave.jredisapi.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
//@RedisHash(value = "CacheItem", timeToLive = 60L) //1 minute
@RedisHash(value = "CacheItem") //No expiration
public class CacheItem implements Serializable {
    @Id
    private String key;
    private String value;
    private Date lastUpdated = new Date();
}
