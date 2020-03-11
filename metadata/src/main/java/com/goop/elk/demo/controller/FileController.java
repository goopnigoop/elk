package com.goop.elk.demo.controller;

import com.goop.elk.demo.converter.FileEntityMapper;
import com.goop.elk.demo.dto.FileEntityDto;
import com.goop.elk.demo.model.FileEntity;
import com.goop.elk.demo.service.FileEntityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FileController {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileEntityService fileEntityService;
    private final FileEntityMapper fileEntityMapper;

    @GetMapping
    public List<FileEntityDto> getFiles(){
        return fileEntityService.findAll()
                .stream()
                .map(fileEntityMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{owner}")
    public List<FileEntityDto> getFileByName(@PathVariable("owner") String owner){
        return fileEntityService.findAllByOwner(owner)
                .stream()
                .map(fileEntityMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateFile(@RequestBody FileEntityDto fileEntity){
        final FileEntity savedFileEntity = fileEntityService.saveOrUpdateFileEntity(fileEntityMapper.dtoToModel(fileEntity));
        logger.info("File with id"+ savedFileEntity.getId() +" was created :: Creation Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
        return new ResponseEntity<>(savedFileEntity, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(String id){
        fileEntityService.deleteFile(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
