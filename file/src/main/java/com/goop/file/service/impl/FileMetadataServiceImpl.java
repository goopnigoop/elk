package com.goop.file.service.impl;

import com.goop.file.clents.MetadataClient;
import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;
import com.goop.file.service.FileMetadataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileMetadataServiceImpl implements FileMetadataService {

    private final MetadataClient metadataClient;

    public FileMetadataServiceImpl(MetadataClient metadataClient) {
        this.metadataClient = metadataClient;
    }

    @Override
    public ResponseWrapper<List<FileEntityDto>> getFileMetadataByFilename(String filename) {
        return metadataClient.getFileMetadata(filename);
    }
}
