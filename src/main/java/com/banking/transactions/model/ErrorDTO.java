package com.banking.transactions.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
public class ErrorDTO {
    private String error;
    private String reason;
    private String time;


    public ErrorDTO(String reason, HttpStatus status) {
        this.reason = reason;
        this.error = status.value() + " : " + status.getReasonPhrase();
        this.time = new Date().toString();
    }
}
