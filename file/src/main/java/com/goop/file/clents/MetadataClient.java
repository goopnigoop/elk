package com.goop.file.clents;

import com.goop.file.dto.FileEntityDto;
import com.goop.file.dto.ResponseWrapper;
import com.goop.file.service.impl.MetadataClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "metadata", fallback = MetadataClientFallback.class)
public interface MetadataClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/files/{fileName}")
    ResponseWrapper<List<FileEntityDto>> getFileMetadata(@PathVariable String fileName);
}
