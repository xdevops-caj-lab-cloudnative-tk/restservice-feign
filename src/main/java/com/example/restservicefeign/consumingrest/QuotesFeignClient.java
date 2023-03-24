package com.example.restservicefeign.consumingrest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(value = "quotes", url = "${myapp.quotes.host}")
// Spring Boot 3 (OpenFeign 4) supports `spring.cloud.openfeign.feignName.url` properties in application.yaml
@FeignClient(value = "quotes")
public interface QuotesFeignClient {

    @GetMapping("/api")
    List<Quote> fetchAllQuotes();

    @GetMapping("/api/random")
    Quote fetchRandomQuote();

    @GetMapping("/api/{id}")
    Quote fetchOneQuote(@PathVariable Long id);

    @GetMapping("/api/random/slow")
    Quote fetchRandomQuoteSlow();
}
