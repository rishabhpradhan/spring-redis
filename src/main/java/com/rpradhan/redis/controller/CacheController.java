package com.rpradhan.redis.controller;

import com.rpradhan.redis.application.model.Inquiry;
import com.rpradhan.redis.application.model.cache.RedisCacheClient;
import com.rpradhan.redis.infrastructure.repository.InquiryCacheRepository;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rpradhan
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    private final InquiryCacheRepository inquiryCacheRepository;
    private final RedisCacheClient redisCacheClient;

    public CacheController(InquiryCacheRepository inquiryCacheRepository, RedisCacheClient redisCacheClient) {
        this.inquiryCacheRepository = inquiryCacheRepository;
        this.redisCacheClient = redisCacheClient;
    }

    @PostMapping("/put")
    public void put(@RequestBody Inquiry inquiry) {
        inquiryCacheRepository.save(inquiry);
    }

    @GetMapping("/get/{id}")
    public Inquiry put(@PathVariable String id) {
        return inquiryCacheRepository.findById(id).orElse(new Inquiry());
    }

    @PostMapping("/custom/put")
    public void cacheClientPut(@RequestBody Inquiry inquiry) {
        redisCacheClient.put(inquiry.getId(), inquiry, Expiration.milliseconds(120000));
    }

    @GetMapping("/custom/get/{id}")
    public Object cacheClientGet(@PathVariable  String id) {
        return redisCacheClient.get(id);
    }

}
