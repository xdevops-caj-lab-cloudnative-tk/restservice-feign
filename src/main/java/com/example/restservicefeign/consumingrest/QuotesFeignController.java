package com.example.restservicefeign.consumingrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class QuotesFeignController {

    private final QuotesFeignClient quotesFeignClient;

    public QuotesFeignController(QuotesFeignClient quotesFeignClient) {
        this.quotesFeignClient = quotesFeignClient;
    }

    @GetMapping("/quotes")
    public List<Quote> fetchAllQuotes() {
        return quotesFeignClient.fetchAllQuotes();
    }

    @GetMapping("/quotes/{id}")
    Quote fetchOneQuote(@PathVariable Long id) {
        return quotesFeignClient.fetchOneQuote(id);
    }

    @GetMapping("/quotes/random")
    Quote fetchRandomQuote() {
        return quotesFeignClient.fetchRandomQuote();
    }

    @GetMapping("/quotes/random/slow")
    Quote fetchRandomQuoteSlow() {
        return quotesFeignClient.fetchRandomQuoteSlow();
    }
}
