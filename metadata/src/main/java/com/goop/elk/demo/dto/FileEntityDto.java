package com.goop.elk.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileEntityDto {
    private String id;
    private String fileName;
    private String owner;
    private String month;
    private String type;
    private BigInteger size;
    private Map<String, Object> properties;
}

