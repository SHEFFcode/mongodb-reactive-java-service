package com.sheffmachine.mongodbreactivequoteservice.repositories;

import com.sheffmachine.mongodbreactivequoteservice.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {
}
