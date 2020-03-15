package com.goop.file.controller;

import com.goop.file.service.FileMetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {

    public FileController(FileMetadataService fileMetadataService) {
        this.fileMetadataService = fileMetadataService;
    }

    private FileMetadataService fileMetadataService;

    @GetMapping("/{fileName}")
    ResponseEntity<?> getFileInformation(@PathVariable String fileName) {
        return ResponseEntity.ok(fileMetadataService.getFileMetadataByFilename(fileName));
    }
}
