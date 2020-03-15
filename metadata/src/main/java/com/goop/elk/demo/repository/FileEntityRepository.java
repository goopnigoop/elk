package com.goop.elk.demo.repository;

import com.goop.elk.demo.model.FileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileEntityRepository extends MongoRepository<FileEntity, String> {

    List<FileEntity> findByFileName(String fileName);
    List<FileEntity> findAllByOwner(String owner);
}
