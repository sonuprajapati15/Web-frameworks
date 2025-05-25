package com.example.springmvcvirtualthreads.repository;

import com.example.springmvcvirtualthreads.model.ApiCallLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiCallLogRepository extends MongoRepository<ApiCallLog, String> {
}