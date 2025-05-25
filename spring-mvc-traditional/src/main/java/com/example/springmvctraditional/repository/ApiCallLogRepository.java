package com.example.springmvctraditional.repository;

import com.example.springmvctraditional.model.ApiCallLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiCallLogRepository extends MongoRepository<ApiCallLog, String> {
}