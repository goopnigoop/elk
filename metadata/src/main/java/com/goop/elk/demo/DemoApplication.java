package com.goop.elk.demo;

import com.goop.elk.demo.model.FileEntity;
import com.goop.elk.demo.repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    FileEntityRepository fileEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> fileEntityRepository.save(new FileEntity(
                null,
                "first",
                "owner",
                "january",
                "txt",
                BigInteger.valueOf(12321312),
                new HashMap<>()));
    }

}
