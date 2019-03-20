package com.sheffmachine.mongodbreactivequoteservice;

import com.sheffmachine.mongodbreactivequoteservice.client.StockQuoteClient;
import com.sheffmachine.mongodbreactivequoteservice.domain.Quote;
import com.sheffmachine.mongodbreactivequoteservice.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class QuoteRunner implements CommandLineRunner {
    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository repository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository repository) {
        this.stockQuoteClient = stockQuoteClient;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream(); // do it one way
        Flux<Quote> quoteFlux = repository.findWithTailableCursorBy();  // do it another way, whenever mogo inserts a new item, we will get it and print it.

        quoteFlux.subscribe(System.out::println);
    }
}
