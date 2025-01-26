package com.SpringBootShoppingApp.exceptions;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ExceptionResponse {
    private int status;
    private String message;
    private LocalDateTime time;
}
