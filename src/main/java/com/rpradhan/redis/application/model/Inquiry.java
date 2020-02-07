package com.rpradhan.redis.application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

/**
 * @author rpradhan
 */
@Data
@RedisHash(value = "Inquiry", timeToLive = 3600)
public class Inquiry implements Serializable {

    @Id
    private String id;

    @Indexed
    private String marketingClickId;
    private String details;
}
