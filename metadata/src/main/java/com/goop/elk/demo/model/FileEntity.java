package com.goop.elk.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Map;

@Document(collection = "files")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileEntity {
    @Id
    private String id;
    private String fileName;
    private String owner;
    private String month;
    private String type;
    private BigInteger size;
    private Map<String, Object> properties;
}
