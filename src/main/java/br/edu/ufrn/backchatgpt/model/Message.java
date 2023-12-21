package br.edu.ufrn.backchatgpt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private String role;
    private String content;

    // constructor, getters and setters
}
