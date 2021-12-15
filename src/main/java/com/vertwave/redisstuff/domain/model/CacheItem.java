package com.vertwave.redisstuff.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "CacheItem", timeToLive = 60L) //1 minute
public class CacheItem implements Serializable {
    private UUID id;
    private String value;
    private Date createdDate;
}
