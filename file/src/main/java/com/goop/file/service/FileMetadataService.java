package com.goop.file.service;

import com.goop.file.dto.FileEntityDto;

public interface FileMetadataService {

    FileEntityDto getFileMetadataByFilename(String filename);

}
