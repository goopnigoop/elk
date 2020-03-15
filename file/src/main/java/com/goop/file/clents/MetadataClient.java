package com.goop.file.clents;

import com.goop.file.dto.FileEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "metadata")
public interface MetadataClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/files/{fileName}")
    List<FileEntityDto> getFileMetadata(@PathVariable String fileName);
}
