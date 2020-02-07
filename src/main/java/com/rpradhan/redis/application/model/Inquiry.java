package com.rpradhan.redis.application.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author rpradhan
 */
@Data
@RedisHash(value = "Inquiry", timeToLive = 60)
public class Inquiry implements Serializable {

    private String id;
    private String marketingClickId;
    private String details;
}
