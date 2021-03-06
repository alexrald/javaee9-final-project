package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class PostConverter implements Converter<PostDto, Post> {

    // TODO: Possible clash with frontend data format
    // define common data format between frontend and backend
    @Override
    public Post dtoToEntity(PostDto postDto) {

        return Post.builder()
                .id(postDto.id())
                .header(postDto.header())
                .content(postDto.content())
                .author(postDto.author())
                .creationTimestamp(convertDateTimeFromString(postDto.creationTimestamp()))
                .updateTimestamp(convertDateTimeFromString(postDto.updateTimestamp()))
                .build();
    }

    @Override
    public PostDto entityToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getHeader(),
                post.getContent(),
                post.getAuthor(),
                post.getCreationTimestamp().toString(),
                post.getUpdateTimestamp().toString()
                );
    }

    private ZonedDateTime convertDateTimeFromString(String timestamp) {
        return timestamp != null ? ZonedDateTime.parse(timestamp) : null;

//        if (timestamp == null)
//            return null;
//
//        return ZonedDateTime.parse(timestamp);
    }
}
