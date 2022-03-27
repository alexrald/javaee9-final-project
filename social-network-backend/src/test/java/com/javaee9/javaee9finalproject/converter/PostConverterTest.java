package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostConverterTest {

    @Autowired
    PostConverter postConverter;

    @Test
    void dtoToEntity() {

        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("The time is: " + now);

        ZonedDateTime creationTime = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime updateTime = ZonedDateTime.now(Clock.systemUTC());


        PostDto dto = new PostDto(
                1L,
                "my header",
                "long content",
                "just me",
                creationTime.toString(),
                updateTime.toString()
        );

        Post entity = postConverter.dtoToEntity(dto);

        Assertions.assertEquals(dto.header(), entity.getHeader());
        Assertions.assertEquals(creationTime, entity.getCreationTimestamp());


    }

    @Test
    void entityToDto() {
    }
}