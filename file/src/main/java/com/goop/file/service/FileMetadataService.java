package com.goop.file.service;


import com.goop.common.dto.FileEntityDto;

public interface FileMetadataService {

    FileEntityDto getFileMetadataByFilename(String filename);

}
