package br.edu.ufrn.backchatgpt.model;

import lombok.Data;
import java.util.List;

@Data
public class ChatRequest {
    private String model;
    private List<Message> messages;
    private int n = 1;
    private double temperature = 0.7;

    public ChatRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

}