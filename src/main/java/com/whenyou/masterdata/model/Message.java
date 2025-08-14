package com.whenyou.masterdata.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String message;
    private boolean status;
    private String payload;
}
