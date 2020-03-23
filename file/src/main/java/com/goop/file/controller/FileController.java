package com.goop.file.controller;

import com.google.gson.Gson;
import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;
import com.goop.file.service.FileMetadataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    public FileController(FileMetadataService fileMetadataService) {
        this.fileMetadataService = fileMetadataService;
    }

    private FileMetadataService fileMetadataService;

    @GetMapping("/{fileName}")
    @HystrixCommand(fallbackMethod = "fallback")
    ResponseEntity<?> getFileInformation(@PathVariable String fileName) {
        LOGGER.info("getting information about file: {}", fileName);
        final ResponseWrapper<List<FileEntityDto>> fileMetadataByFilename = fileMetadataService.getFileMetadataByFilename(fileName);
        Gson gson = new Gson();
        LOGGER.info("Metadata is received: {}", gson.toJson(fileMetadataByFilename));
        return ResponseEntity.ok(fileMetadataByFilename);
    }

    public ResponseEntity<?> fallback(String fileName, Throwable hystrixCommand) {
        LOGGER.warn("Something happens with service: {}", hystrixCommand.getMessage());
        return new ResponseEntity<>(new ThrowableResponseWrapper("Service is unreachable",hystrixCommand),HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ThrowableResponseWrapper {
        String message;
        Throwable throwable;
    }
}
