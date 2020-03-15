package com.goop.file.service;

import com.goop.file.dto.FileEntityDto;

import java.util.List;

public interface FileMetadataService {

    List<FileEntityDto> getFileMetadataByFilename(String filename);

}
