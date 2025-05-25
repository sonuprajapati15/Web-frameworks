package com.example.springgrpcvirtualthreads.repository;

import com.example.springgrpcvirtualthreads.model.ApiCallLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiCallLogRepository extends MongoRepository<ApiCallLog, String> {
}