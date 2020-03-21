package com.goop.file.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.Optional;

@Data
public class ResponseWrapper<T> {
    private final String hostname;
    private final T body;
}
