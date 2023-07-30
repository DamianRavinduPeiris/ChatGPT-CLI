package com.damian.chatgpt.requestbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class RequestBody {

    private String model;
    private String prompt;
    private int max_tokens;

    private double temperature;
}
