package com.goop.elk.demo;

import com.google.common.collect.ImmutableList;
import com.goop.elk.demo.model.FileEntity;
import com.goop.elk.demo.repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.HashMap;

@SpringBootApplication
@EnableEurekaClient
public class DemoApplication {

    @Autowired
    FileEntityRepository fileEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> saveToTheDatabase();
    }

    private void saveToTheDatabase() {
        final FileEntity firstFile = new FileEntity(
                null,
                "first",
                "owner",
                "january",
                "txt",
                BigInteger.valueOf(12321312),
                new HashMap<>());
        final FileEntity secondFile = new FileEntity(
                null,
                "second",
                "ownerN",
                "february",
                "jpg",
                BigInteger.valueOf(12321312),
                new HashMap<>());
        fileEntityRepository.saveAll(ImmutableList.of(firstFile, secondFile));
    }

}
