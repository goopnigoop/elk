package com.goop.elk.demo.converter;

import com.goop.common.dto.FileEntityDto;
import com.goop.elk.demo.model.FileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileEntityMapper {
    FileEntityDto modelToDto(FileEntity source);
    FileEntity dtoToModel(FileEntityDto destination);
}
