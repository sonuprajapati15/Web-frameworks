package com.example.graphql.repository;

import com.example.graphql.model.ApiCallLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApiCallLogRepository extends MongoRepository<ApiCallLog, String> {
}