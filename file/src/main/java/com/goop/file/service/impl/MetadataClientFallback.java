package com.goop.file.service.impl;

import com.goop.file.clents.MetadataClient;
import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class MetadataClientFallback implements MetadataClient {
    @Override
    public ResponseWrapper<List<FileEntityDto>> getFileMetadata(String fileName) {
        return new ResponseWrapper<>("No host is found", emptyList());
    }
}
