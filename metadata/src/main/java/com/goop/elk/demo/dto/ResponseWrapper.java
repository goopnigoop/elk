package com.goop.elk.demo.dto;

import lombok.Data;
import org.springframework.core.env.Environment;

import java.util.Optional;

@Data
public class ResponseWrapper<T> {
    private final String hostname;
    private final T body;

    public ResponseWrapper(final Environment environment, final T body) {
        final String hostname = environment.getProperty("HOSTNAME");
        this.hostname = Optional.ofNullable(hostname)
                .orElse(null);
        this.body = body;
    }

}
