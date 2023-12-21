package br.edu.ufrn.backchatgpt.controller;

import br.edu.ufrn.backchatgpt.model.ChatRequest;
import br.edu.ufrn.backchatgpt.model.ChatResponse;
import br.edu.ufrn.backchatgpt.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://chatgpt-h174.onrender.com"})
public class ChatController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @PostMapping("/chatbot")
    public String chat2(@RequestBody List<Message> messages) {

        // create a request
        ChatRequest request = new ChatRequest(model, messages);

        // call the API
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}