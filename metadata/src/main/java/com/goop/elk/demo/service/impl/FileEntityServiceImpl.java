package com.goop.elk.demo.service.impl;

import com.goop.elk.demo.model.FileEntity;
import com.goop.elk.demo.repository.FileEntityRepository;
import com.goop.elk.demo.service.FileEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FileEntityServiceImpl implements FileEntityService {

    private FileEntityRepository fileEntityRepository;

    @Override
    public List<FileEntity> findAll() {
        return fileEntityRepository.findAll();
    }

    @Override
    public FileEntity findByFileName(String fileName) {
        return fileEntityRepository.findByFileName(fileName).orElseThrow(() -> new RuntimeException("File is not found"));
    }

    @Override
    public List<FileEntity> findAllByOwner(String owner) {
        return fileEntityRepository.findAllByOwner(owner);
    }

    @Override
    public void deleteFile(String id) {
        fileEntityRepository.deleteById(id);
    }

    @Override
    public FileEntity saveOrUpdateFileEntity(FileEntity fileEntity) {
        return fileEntityRepository.save(fileEntity);
    }
}
