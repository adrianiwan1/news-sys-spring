package com.example.newssysspring.exceptions;

import org.springframework.lang.Nullable;

public class UserExistsException extends RuntimeException {
    public UserExistsException(@Nullable String message) {
        super(message);
    }

}
