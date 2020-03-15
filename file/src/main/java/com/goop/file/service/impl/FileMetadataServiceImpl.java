package com.goop.file.service.impl;

import com.goop.file.dto.FileEntityDto;
import com.goop.file.service.FileMetadataService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FileMetadataServiceImpl implements FileMetadataService {

    private final RestTemplate restTemplate;

    public FileMetadataServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FileEntityDto getFileMetadataByFilename(String filename) {
        return restTemplate.getForObject("http://metadata/api/files/" + filename, FileEntityDto.class);
    }
}
