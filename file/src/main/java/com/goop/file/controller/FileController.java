package com.goop.file.controller;

import com.google.gson.Gson;
import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;
import com.goop.file.service.FileMetadataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    public FileController(FileMetadataService fileMetadataService) {
        this.fileMetadataService = fileMetadataService;
    }

    private FileMetadataService fileMetadataService;

    @GetMapping("/{fileName}")
    @HystrixCommand(commandKey = "getFiles",fallbackMethod = "fallback")
    ResponseEntity<?> getFileInformation(@PathVariable String fileName) {
        log.info("getting information about file: {}", fileName);
        final ResponseWrapper<List<FileEntityDto>> fileMetadataByFilename = fileMetadataService.getFileMetadataByFilename(fileName);
        Gson gson = new Gson();
        log.info("Metadata is received: {}", gson.toJson(fileMetadataByFilename));
        return ResponseEntity.ok(fileMetadataByFilename);
    }

    public ResponseEntity<?> fallback(String fileName, Throwable hystrixCommand) {
        log.warn("Something happens with service: {}", hystrixCommand.getMessage());
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
