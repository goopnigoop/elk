package com.goop.elk.demo.service;

import com.goop.elk.demo.model.FileEntity;

import java.util.List;

public interface FileEntityService {

    List<FileEntity> findAll();
    FileEntity findByFileName(String fileName);
    List<FileEntity> findAllByOwner(String owner);
    void deleteFile(String id);
    FileEntity saveOrUpdateFileEntity(FileEntity fileEntity);
}
