package com.goop.elk.demo.controller;

import com.google.gson.Gson;
import com.goop.elk.demo.converter.FileEntityMapper;
import com.goop.elk.demo.dto.FileEntityDto;
import com.goop.elk.demo.dto.ResponseWrapper;
import com.goop.elk.demo.model.FileEntity;
import com.goop.elk.demo.service.FileEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("files")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final FileEntityService fileEntityService;
    private final FileEntityMapper fileEntityMapper;
    private final Environment environment;

    @GetMapping
    public List<FileEntityDto> getFiles() {
        return fileEntityService.findAll()
                .stream()
                .map(fileEntityMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{filename}")
    public ResponseWrapper<List<FileEntityDto>> getFileByName(@PathVariable("filename") String filename) {
        log.info("Loading metadata for file: {}", filename);
        final List<FileEntityDto> listOfEntries = fileEntityService.findByFileName(filename)
                .stream()
                .map(fileEntityMapper::modelToDto)
                .collect(Collectors.toList());
        log.info("metadata is found: {}", new Gson().toJson(listOfEntries));
        return new ResponseWrapper<>(environment,listOfEntries);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateFile(@RequestBody FileEntityDto fileEntity) {
        final FileEntity savedFileEntity = fileEntityService.saveOrUpdateFileEntity(fileEntityMapper.dtoToModel(fileEntity));
        log.info("File with id {} was created :: Creation Time - {}", savedFileEntity.getId(), dateTimeFormatter.format(LocalDateTime.now()));
        return new ResponseEntity<>(savedFileEntity, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(String id) {
        fileEntityService.deleteFile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
