package com.rpradhan.redis.controller;

import com.rpradhan.redis.application.model.Inquiry;
import com.rpradhan.redis.infrastructure.repository.InquiryCacheRepository;
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

    public CacheController(InquiryCacheRepository inquiryCacheRepository) {
        this.inquiryCacheRepository = inquiryCacheRepository;
    }

    @PostMapping("/put")
    public void put(@RequestBody Inquiry inquiry) {
        inquiryCacheRepository.save(inquiry);
    }

    @GetMapping("/get/{id}")
    public Inquiry put(@PathVariable  String id) {
        return inquiryCacheRepository.findById(id).orElse(new Inquiry());
    }

}
