package com.edugo.ecommercedemo.config;

import org.springframework.http.HttpStatus;

public record ApiError (HttpStatus status, String message){}
