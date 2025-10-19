package com.cheong.realestatebe.controller;

import com.cheong.realestatebe.converter.MortgageCalculation;
import com.cheong.realestatebe.dto.MortgageRequest;
import com.cheong.realestatebe.service.MortgageService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/api/mortgage")
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }

    @PostMapping("/calculate")
    public Mono<MortgageCalculation> calculateTotalMortgage(@RequestBody MortgageRequest mortgageRequest) {
        return mortgageService.calculateTotalMortgage(mortgageRequest);
    }
}
