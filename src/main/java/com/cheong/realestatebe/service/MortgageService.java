package com.cheong.realestatebe.service;

import com.cheong.realestatebe.converter.MortgageCalculation;
import com.cheong.realestatebe.dto.MortgageRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class MortgageService {

    private final ChatClient chatClient;

    @Value("classpath:/prompt/rag-prompt.st")
    private Resource ragPrompt;

    public MortgageService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Mono<MortgageCalculation> calculateTotalMortgage(MortgageRequest mortgageRequest) {
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(ragPrompt);
        Prompt prompt = Prompt.builder()
                .messages(systemPromptTemplate.createMessage(mortgageRequest.getMap())).build();

        return Mono.fromCallable(() -> chatClient
                .prompt(prompt)
                .call()
                .entity(MortgageCalculation.class))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
