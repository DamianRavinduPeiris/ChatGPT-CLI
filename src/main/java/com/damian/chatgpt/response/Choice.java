package com.damian.chatgpt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Choice {
    private String text;
    private int index;
    private Object logprobs;
    private String finish_reason;
}
