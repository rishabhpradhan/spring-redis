package com.rpradhan.redis.infrastructure.repository;

import com.rpradhan.redis.application.model.Inquiry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rpradhan
 */
@Repository
public interface InquiryCacheRepository extends CrudRepository<Inquiry, String> {
}
