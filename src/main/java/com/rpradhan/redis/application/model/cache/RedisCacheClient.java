package com.rpradhan.redis.application.model.cache;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

/**
 * @author rpradhan
 */
@Component
public class RedisCacheClient {

    private final LettuceConnectionFactory lettuceConnectionFactory;

    public RedisCacheClient(LettuceConnectionFactory lettuceConnectionFactory) {
        this.lettuceConnectionFactory = lettuceConnectionFactory;
    }

    public void put(String key, Object value, Expiration expiration) {
        RedisConnection connection = lettuceConnectionFactory.getConnection();
        if (value == null) {
            connection.keyCommands().del(key.getBytes());

        } else {
            connection.stringCommands().set(key.getBytes(), SerializationUtils.serialize(value), expiration, RedisStringCommands.SetOption.UPSERT);
        }
    }

    public Object get(String key) {
        RedisConnection connection = lettuceConnectionFactory.getConnection();
        byte[] value = connection.stringCommands().get(key.getBytes());
        return value != null ? SerializationUtils.deserialize(value) : null;
    }

}
