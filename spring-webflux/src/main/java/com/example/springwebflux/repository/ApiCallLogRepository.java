package com.example.springwebflux.repository;

import com.example.springwebflux.model.ApiCallLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ApiCallLogRepository extends ReactiveMongoRepository<ApiCallLog, String> {
}