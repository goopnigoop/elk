package com.goop.file.service;

import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;

import java.util.List;

public interface FileMetadataService {

    ResponseWrapper<List<FileEntityDto>> getFileMetadataByFilename(String filename);

}
